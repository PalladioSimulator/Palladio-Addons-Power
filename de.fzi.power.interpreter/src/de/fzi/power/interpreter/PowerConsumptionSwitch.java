/**
 * 
 */
package de.fzi.power.interpreter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.measure.quantity.Power;

import org.jscience.physics.amount.Amount;

import de.fzi.power.infrastructure.MountedPowerDistributionUnit;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerConsumingProvidingEntity;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerDistributionUnit;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.infrastructure.util.InfrastructureSwitch;
import de.fzi.power.specification.resources.PowerModelConstants;

/**
 * This class is used as the basis of interpreters that evaluate the power consumption of
 * {@link Infrastructure} models. It is interpreted for the current point in time associated with
 * the {@link ConsumptionContext} that is set for {@code this}.
 * 
 * @author stier
 *
 */
public final class PowerConsumptionSwitch extends InfrastructureSwitch<Amount<Power>> {

    // Consumption context under which the power consumption is evaluated.
    private ConsumptionContext consumptionContext;

    /**
     * Default, empty constructor.
     */
    private PowerConsumptionSwitch() {

    }

    /**
     * Creates a power consumption switch. It is used to evaluate the power consumption for a given
     * evaluation scope. Changes to the properties of {@code ctx} are considered in the evaluation
     * of the power consumption.
     * 
     * @param ctx
     *            A {@link ConsumptionContext} instance denoting the initial evaluation context.
     * @throws IllegalArgumentException
     *             In case the given consumption context was {@code null}.
     * @return The PowerConsumptionSwitch to be used for the evaluation.
     */
    public static PowerConsumptionSwitch createPowerConsumptionSwitch(ConsumptionContext ctx) {
        PowerConsumptionSwitch consumptionSwitch = new PowerConsumptionSwitch();
        consumptionSwitch.setConsumptionContext(ctx);
        return consumptionSwitch;
    }

    /**
     * Change the context for which the power consumption is evaluated.
     * 
     * @param ctx
     *            The {@link ConsumptionContext} to set.
     * @throws IllegalArgumentException
     *             In case {@code ctx == null}.
     */
    public void setConsumptionContext(ConsumptionContext ctx) {
        if (ctx == null) {
            throw new IllegalArgumentException("ConsumptionContext must not be null.");
        }
        this.consumptionContext = ctx;
    }

    /**
     * Evaluate the power consumption of all elements connected to {@code pdu}
     * 
     * @param pdu
     *            The power distribution unit for which the power consumption evaluation is
     *            performed
     * @return The power consumption evaluation result.
     */
    @Override
    public Amount<Power> casePowerDistributionUnit(PowerDistributionUnit pdu) {
        return this.casePowerConsumingProvidingEntity(pdu);
    }

    /**
     * Evaluates the power consumption of all elements connected to a PowerConsumingProvidingEntity.
     * 
     * @param providingConsumingEntity
     *            The entity for which the consumption is evaluated.
     * @return The power consumption evaluation result.
     */
    @Override
    public Amount<Power> casePowerConsumingProvidingEntity(PowerConsumingProvidingEntity providingConsumingEntity) {
        Collection<PowerConsumingEntity> consumingEntities = Objects.requireNonNull(providingConsumingEntity)
                .getNestedPowerConsumingEntities();
        Map<PowerConsumingEntity, Amount<Power>> consumers = new HashMap<>(consumingEntities.size());
        for (PowerConsumingEntity consumingEntity : consumingEntities) {
            consumers.put(consumingEntity, doSwitch(consumingEntity));
        }
        return this.consumptionContext.evaluateDistributionPowerConsumption(providingConsumingEntity, consumers);
    }

    /**
     * Evaluates the power consumption of all elements connected to a PowerProvidingEntity. Uses
     * {@see PowerConsumptionSwitch#doSwitch(int, org.eclipse.emf.ecore.EObject)} to evaluate the
     * consumption using the case of this switch that is the actual type of {@code ppEntity}.
     * 
     * @param ppEntity
     *            The entity for which the consumption of connected elements is evaluated.
     * @return The power consumption evaluation result.
     */
    @Override
    public Amount<Power> casePowerProvidingEntity(PowerProvidingEntity ppEntity) {
        // look for appropriate subclass in switch
        return this.doSwitch(ppEntity);
    }

    /**
     * Evaluates the power consumption of a PowerConsumingEntity. Uses
     * {@see PowerConsumptionSwitch#doSwitch(int, org.eclipse.emf.ecore.EObject)} to evaluate the
     * consumption using the case of this switch that is the actual type of {@code object}.
     * 
     * @param powerConsumingEntity
     *            The entity for which the power consumption is evaluated.
     */
    @Override
    public Amount<Power> casePowerConsumingEntity(PowerConsumingEntity powerConsumingEntity) {
        // look for appropriate subclass in switch
        return this.doSwitch(powerConsumingEntity);
    }

    /**
     * Evaluates the power consumption of a mounted PDU and the elements nested below it.
     * 
     * @param mountedPdu
     *            The power distribution unit for which the power consumption is evaluated.
     * @return The evaluated power consumption.
     */
    @Override
    public Amount<Power> caseMountedPowerDistributionUnit(MountedPowerDistributionUnit mountedPdu) {
        return this.casePowerDistributionUnit(mountedPdu);
    }

    /**
     * Evaluate the power consumption of a PowerConsumingResource. The evaluation is performed by
     * looking up the power consumption specification/power model set for the resource.
     * 
     * @param resource
     *            The power consuming resource.
     * @return The amount of power consumed by the resource.
     */
    @Override
    public Amount<Power> casePowerConsumingResource(PowerConsumingResource resource) {
        return this.consumptionContext.evaluateResourcePowerConsumption(resource);
    }

    /**
     * Evaluate the power consumption for a full {@link PowerInfrastructureRepository}.
     * 
     * @param piModel
     *            The {@link PowerInfrastructureRepository} for which the power consumption is
     *            evaluated.
     * @return The amount of power consumed throughout the whole repository model.
     */
    @Override
    public Amount<Power> casePowerInfrastructureRepository(PowerInfrastructureRepository piModel) {
        Amount<Power> sum = PowerModelConstants.ZERO_POWER;
        for (PowerProvidingEntity entity : piModel.getContainedPowerProvidingEntities()) {
            sum = sum.plus(this.casePowerProvidingEntity(entity));
        }
        return sum;
    }
}
