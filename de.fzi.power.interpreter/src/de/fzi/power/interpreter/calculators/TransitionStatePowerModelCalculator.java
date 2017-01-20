package de.fzi.power.interpreter.calculators;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Power;
import javax.measure.unit.Unit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.NumericalBaseMetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import de.fzi.power.binding.TransitionStateBinding;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.StatefulPowerConsumingResource;
import tools.descartes.dlim.generator.ModelEvaluator;

public class TransitionStatePowerModelCalculator implements IResourcePowerModelCalculator {
    private final ModelEvaluator evaluator;
    private final Unit<Power> targetUnit;

    public TransitionStatePowerModelCalculator(final StatefulPowerConsumingResource resource,
            final TransitionStateBinding stateBinding, final ITimeProvider provider) {
        resource.eAdapters().add(new EContentAdapter() {
            @Override
            public void notifyChanged(Notification notification) {
                if (notification.getEventType() == Notification.SET
                        && InfrastructurePackage.eINSTANCE.getStatefulPowerConsumingResource()
                                .isInstance(notification.getNotifier())
                        && InfrastructurePackage.eINSTANCE.getStatefulPowerConsumingResource_PowerState()
                                .equals(notification.getFeature())) {
                    transitionStart = provider.getCurrentTime();
                }
            }
        });
        this.evaluator = new ModelEvaluator(stateBinding.getTransitionConsumption().getPowerCurve());
        this.targetUnit = stateBinding.getTransitionConsumption().getUnit();
    }

    // TODO implement via notify
    Amount<Duration> transitionStart;

    @Override
    public Amount<Power> calculate(final Collection<MeasuringValue> list) {
        final NumericalBaseMetricDescription timeMetric = (NumericalBaseMetricDescription) MetricDescriptionConstants.POINT_IN_TIME_METRIC;
        final Measure<Double, Duration> curTime = list.stream().map(m -> m.<Double, Duration> getMeasureForMetric(timeMetric))
                .findAny().get();
        final double timeDiff = curTime.doubleValue(transitionStart.getUnit()) - transitionStart.doubleValue(transitionStart.getUnit());
        final double consumption = evaluator.getArrivalRateAtTime(timeDiff);
        return Amount.valueOf(consumption, targetUnit);
    }

    @Override
    public Set<MetricDescription> getInputMetrics() {
        return Collections.singleton(MetricDescriptionConstants.POINT_IN_TIME_METRIC);
    }

}
