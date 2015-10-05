package de.fzi.power.interpreter;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.edp2.models.measuringpoint.ResourceURIMeasuringPoint;
import org.palladiosimulator.edp2.models.measuringpoint.util.MeasuringpointSwitch;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.MetricSetDescription;
import org.palladiosimulator.metricspec.MetricSpecPackage;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.util.ResourceenvironmentSwitch;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.util.PcmmeasuringpointSwitch;

import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.infrastructure.util.InfrastructureSwitch;
import de.fzi.power.interpreter.measureprovider.ExtendedMeasureProvider;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * Utility class that contains common classes, methods or objects used at multiple locations in the
 * power interpreter project.
 * 
 * @author Sebastian Krach, Florian Rosenthal
 * 
 */
public final class InterpreterUtils {

    private static final PcmmeasuringpointSwitch<ProcessingResourceSpecification> PCMMEASURINGPOINT_SWITCH = new PcmmeasuringpointSwitch<ProcessingResourceSpecification>() {
        @Override
        public ProcessingResourceSpecification caseActiveResourceMeasuringPoint(
                final ActiveResourceMeasuringPoint point) {
            return point.getActiveResource();
        }

        @Override
        public ProcessingResourceSpecification defaultCase(final EObject eObject) {
            return MEASURINGPOINT_SWITCH.doSwitch(eObject);
        }
    };

    private static final MeasuringpointSwitch<ProcessingResourceSpecification> MEASURINGPOINT_SWITCH = new MeasuringpointSwitch<ProcessingResourceSpecification>() {
        @Override
        public ProcessingResourceSpecification caseResourceURIMeasuringPoint(final ResourceURIMeasuringPoint point) {
            URI resourceUri = URI.createURI(point.getResourceURI());
            if (resourceUri.fragment() != null) {
                // this check avoids an illegal argument exception thrown in the loadAndResolve
                // method
                // in case no fragment is present
                // this is the case if point is a ReconfigurationMeasuringPoint instance
                return RESOURCEENV_SWITCH
                        .doSwitch(EMFLoadHelper.loadAndResolveEObject(new ResourceSetImpl(), resourceUri));
            }
            return null;
        }
    };

    private static final ResourceenvironmentSwitch<ProcessingResourceSpecification> RESOURCEENV_SWITCH = new ResourceenvironmentSwitch<ProcessingResourceSpecification>() {
        @Override
        public ProcessingResourceSpecification caseProcessingResourceSpecification(
                final ProcessingResourceSpecification proc) {
            return proc;
        }
    };

    /**
     * Gets the processing resource specification that is associated with the given measuring point.
     * 
     * @param measuringPoint
     *            A {@link MeasuringPoint} of arbitrary kind.
     * @return The {@link ProcessingResourceSpecification} that is associated with the given
     *         measuring point, or {@code null}.
     * @throws NullPointerException
     *             In case the given measuring point is {@code null}.
     */
    public static ProcessingResourceSpecification getProcessingResourceSpecificationFromMeasuringPoint(
            MeasuringPoint measuringPoint) {
        return PCMMEASURINGPOINT_SWITCH
                .doSwitch(Objects.requireNonNull(measuringPoint, "Given measuring point must not be null."));
    }

    private static final InfrastructureSwitch<Set<ProcessingResourceSpecification>> INFRASTRUCTURE_SWITCH = new InfrastructureSwitch<Set<ProcessingResourceSpecification>>() {

        // inner node (composite nodes): just step down until we reach a leaf
        @Override
        public Set<ProcessingResourceSpecification> casePowerProvidingEntity(PowerProvidingEntity ppe) {
            Set<ProcessingResourceSpecification> result = new HashSet<>();
            for (PowerConsumingEntity dist : ppe.getNestedPowerConsumingEntities()) {
                result.addAll(this.doSwitch(dist));
            }
            return result;
        }

        // process leaf
        @Override
        public Set<ProcessingResourceSpecification> casePowerConsumingResource(PowerConsumingResource resource) {
            return Collections.singleton(resource.getProcessingResourceSpecification());

        }

        @Override
        public Set<ProcessingResourceSpecification> defaultCase(EObject obj) {
            return Collections.emptySet();
        }
    };

    /**
     * Gets all the processing resource specifications that are subsumed by the given model element.
     * That is, a top down search for {@code ProcessingResourceSpecification}s is started at the
     * given element, yielding all specifications that are associated with leafs (e.g,
     * {@code PowerConsumingEntity}s of the corresponding infrastructure model.
     * 
     * @param infModelElement
     *            An {@link EObject} representing an element from an infrastructure model.
     * @return A set (i.e., a unique collection) containing all collected
     *         {@code ProcessingResourceSpecification}s. If none were found, an empty set is
     *         returned.
     * @throws NullPointerException
     *             A {@link NullPointerException} is thrown, if the given argument is {@code null}.
     */
    public static Set<ProcessingResourceSpecification> getProcessingResourceSpecsFromInfrastructureElement(
            EObject infModelElement) {
        return INFRASTRUCTURE_SWITCH
                .doSwitch(Objects.requireNonNull(infModelElement, "Given EObject must not be null."));
    }

    /**
     * Gets the {@link PowerProvidingEntity} the given measuring point points to.<br>
     * In the current implementation, only {@link ResourceURIMeasuringPoint}s are processed as this
     * is sufficient for all contemporary use cases. That is, for all other types of measuring
     * points {@code null} is returned.
     * 
     * @param measuringPoint
     *            A reference to a {@link MeasuringPoint} model object.
     * @return The {@link PowerProvidingEntity} model element the given measuring point is
     *         associated with, {@code null} otherwise.
     * @throws IllegalArgumentException
     *             An {@link IllegalArgumentException} is thrown, if the given argument is
     *             {@code null}.
     */
    public static PowerProvidingEntity getPowerProvindingEntityFromMeasuringPoint(MeasuringPoint measuringPoint) {
        if (measuringPoint == null) {
            throw new IllegalArgumentException("Given MeasuringPoint must not be null.");
        }
        return new MeasuringpointSwitch<PowerProvidingEntity>() {

            private final InfrastructureSwitch<PowerProvidingEntity> infSwitch = new InfrastructureSwitch<PowerProvidingEntity>() {
                @Override
                public PowerProvidingEntity casePowerProvidingEntity(PowerProvidingEntity ppe) {
                    return ppe;
                }
            };

            @Override
            public PowerProvidingEntity caseResourceURIMeasuringPoint(ResourceURIMeasuringPoint mp) {
                URI resourceUri = URI.createURI(mp.getResourceURI());
                if (resourceUri.fragment() != null) {
                    // this check avoids an illegal argument exception thrown in the loadAndResolve
                    // method
                    // in case no fragment is present
                    // this is the case if point is a ReconfigurationMeasuringPoint instance
                    return infSwitch.doSwitch(EMFLoadHelper.loadAndResolveEObject(new ResourceSetImpl(), resourceUri));
                }
                return null;
            }
        }.doSwitch(measuringPoint);
    }

    /**
     * Helper method that checks whether the required metric ({@code required}) equals the provided
     * one ({@code available}) or is subsumed by it..
     *
     * @param required
     *            the required metric
     * @param available
     *            the available metric
     * 
     * @return true, the required metric is satisfied by Measurements of the available metric
     */
    public static boolean isRequiredMetricSatisfiedBy(final MetricDescription required,
            final MetricDescription available) {
        boolean result = false;
        if (MetricSpecPackage.eINSTANCE.getMetricSetDescription().isInstance(required)) {
            final MetricSetDescription requiredSet = (MetricSetDescription) required;
            result = true;
            for (MetricDescription subsumedMetric : requiredSet.getSubsumedMetrics()) {
                result &= isRequiredMetricSatisfiedBy(subsumedMetric, available);
            }
        } else if (required.equals(available)) {
            result = true;
        } else if (required.getId().equals(available.getId())) {
            result = true;
        } else if (MetricSpecPackage.eINSTANCE.getMetricSetDescription().isInstance(available)) {
            MetricSetDescription availableSet = (MetricSetDescription) available;
            for (MetricDescription desc : availableSet.getSubsumedMetrics()) {
                result |= isRequiredMetricSatisfiedBy(required, desc);
            }
        }
        return result;
    }

    /**
     * Creates a new {@link HashMap} decorated with an {@link IdentifierMatchingMapDecorator) to
     * allow to use EMF model elements from potentially different sources as key.
     * 
     * @return a decorated map
     */
    public static <K extends Identifier, V> Map<K, V> createIdentifierMatchingHashMap() {
        return new IdentifierMatchingMapDecorator<K, V>(new HashMap<String, V>(), new HashMap<String, K>());
    }

    /**
     * Creates a new {@link HashMap} decorated with an {@link IdentifierMatchingMapDecorator) to
     * allow to use EMF model elements from potentially different sources as key.
     * 
     * @param size
     *            the size of the initial map
     * 
     * @return a decorated map
     */
    public static <K extends Identifier, V> Map<K, V> createIdentifierMatchingHashMap(int size) {
        return new IdentifierMatchingMapDecorator<K, V>(new HashMap<String, V>(size), new HashMap<String, K>(size));
    }

    /**
     * A Decorator the allows to use EMF model objects as key as long as they are uniquely
     * identified their {@code Id}.
     *
     * @param <K>
     *            the key type
     * @param <V>
     *            the value type
     */
    private static class IdentifierMatchingMapDecorator<K extends Identifier, V> implements Map<K, V> {
        private final Map<String, V> decoratedMap;
        private final Map<String, K> keyMap;

        /**
         * Creates a new decorator based on two subsumed maps.
         * 
         * @param decoratedMap
         *            the decorated map linking the identifier to the actual value
         * @param keyMap
         *            the decorated map linking the identifier to the key object
         */
        private IdentifierMatchingMapDecorator(Map<String, V> decoratedMap, Map<String, K> keyMap) {
            this.decoratedMap = decoratedMap;
            this.keyMap = keyMap;
        }

        @Override
        public int size() {
            return decoratedMap.size();
        }

        @Override
        public boolean isEmpty() {
            return decoratedMap.isEmpty();
        }

        @Override
        public boolean containsKey(Object key) {
            if (key == null || !(key instanceof Identifier)) {
                return false;
            }
            return decoratedMap.containsKey(((Identifier) key).getId());
        }

        @Override
        public boolean containsValue(Object value) {
            return decoratedMap.containsValue(value);
        }

        @Override
        public V get(Object key) {
            if (key == null || !(key instanceof Identifier)) {
                return null;
            }
            return decoratedMap.get(((Identifier) key).getId());
        }

        @Override
        public V put(K key, V value) {
            if (key == null || !(key instanceof Identifier)) {
                return null;
            }
            keyMap.put(key.getId(), key);
            return decoratedMap.put(key.getId(), value);
        }

        @Override
        public V remove(Object key) {
            if (key == null || !(key instanceof Identifier)) {
                return null;
            }
            keyMap.remove(((Identifier) key).getId());
            return decoratedMap.remove(((Identifier) key).getId());
        }

        @Override
        public void putAll(Map<? extends K, ? extends V> m) {
            for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }

        @Override
        public void clear() {
            keyMap.clear();
            decoratedMap.clear();
        }

        @Override
        public Set<K> keySet() {
            return new HashSet<K>(keyMap.values());
        }

        @Override
        public Collection<V> values() {
            return decoratedMap.values();
        }

        @Override
        public Set<java.util.Map.Entry<K, V>> entrySet() {
            Set<Entry<K, V>> resultSet = new HashSet<Map.Entry<K, V>>();
            for (Entry<String, K> entry : keyMap.entrySet()) {
                resultSet.add(new AbstractMap.SimpleEntry<K, V>(entry.getValue(), decoratedMap.get(entry.getKey())));
            }
            return resultSet;
        }

    }

    public static Map<MetricDescription, IDataSource> determineDataSourcesForAvailableMetrics(
            Set<IDataSource> dataSources, Set<ExtendedMeasureProvider> measureProviders) {
        Map<MetricDescription, IDataSource> metricToDataSource = createIdentifierMatchingHashMap();

        for (IDataSource inputSource : dataSources) {
            metricToDataSource.put(inputSource.getMetricDesciption(), inputSource);
        }

        int oldSize;

        do {
            oldSize = metricToDataSource.size();
            for (ExtendedMeasureProvider provider : measureProviders) {
                for (MetricDescription m : provider.getTargetMetrics()) {
                    if (metricToDataSource.containsKey(m)) {
                        continue;
                    }
                    if (provider.canProvideMetric(m, metricToDataSource.keySet())) {

                        metricToDataSource.put(m,
                                provider.getDataSource(new HashSet<IDataSource>(metricToDataSource.values())));
                    }
                }
            }
        } while (metricToDataSource.size() > oldSize);

        return Collections.unmodifiableMap(metricToDataSource);
    }

}
