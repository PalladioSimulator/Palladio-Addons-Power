package de.fzi.power.interpreter.calculators;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import javax.measure.quantity.Power;

import org.jscience.physics.amount.Amount;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;
import de.fzi.power.binding.AbstractPowerStateBinding;
import de.fzi.power.infrastructure.StatefulPowerConsumingResource;

public class StatefulPowerConsumingResourceCalculator implements IResourcePowerModelCalculator {

    private final StatefulPowerConsumingResource resource;
    private final Map<AbstractPowerStateBinding, IResourcePowerModelCalculator> powerCalculatorsPerState;

    public StatefulPowerConsumingResourceCalculator(final StatefulPowerConsumingResource resource,
            Map<AbstractPowerStateBinding, IResourcePowerModelCalculator> powerCalculatorsPerState) {
        this.resource = resource;
        this.powerCalculatorsPerState = powerCalculatorsPerState;
    }

    @Override
    public Amount<Power> calculate(final Collection<MeasuringValue> list) {
        return powerCalculatorsPerState.get(this.resource.getPowerState()).calculate(list);
    }

    @Override
    public Set<MetricDescription> getInputMetrics() {
        Iterator<IResourcePowerModelCalculator> iterator = this.powerCalculatorsPerState.values().iterator();
        if (!iterator.hasNext()) {
            throw new IllegalStateException("There should be a non-empty power model for at least one state.");
        }
        ;
        return new HashSet<MetricDescription>(iterator.next().getInputMetrics());
    }

}
