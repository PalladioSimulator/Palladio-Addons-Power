package de.fzi.power.interpreter;

import java.util.Objects;

import de.fzi.power.infrastructure.MountedPowerDistributionUnit;
import de.fzi.power.infrastructure.PowerConsumingResourceSet;
import de.fzi.power.infrastructure.PowerDistributionUnit;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.infrastructure.StatefulPowerConsumingResourceSet;
import de.fzi.power.infrastructure.util.InfrastructureSwitch;
import de.fzi.power.interpreter.calculators.CalculatorInstantiator;

/**
 * Switch used by an interpreter to update the power models for elements depending on the
 * {@see PowerAssemblyContext} that has been set for them.
 * 
 * @author stier
 *
 */
public class PowerModelUpdaterSwitch extends InfrastructureSwitch<Void> {

    // Factory used for instantiating calculators.
    private final CalculatorInstantiator calcInstantiator;
    // Registry onto which created calculators are attached/registered to.
    private final PowerModelRegistry registry;

    /**
     * Creates the switch for updating the power models registered in the {@link PowerModelRegistry}
     * of an interpreted power infrastructure model.
     * 
     * @param registry
     *            The registry onto which the power models are registered.
     * @param calcInstantiator
     *            The factory used for instantiating the respective updated elements.
     */
    public PowerModelUpdaterSwitch(PowerModelRegistry registry, CalculatorInstantiator calcInstantiator) {
        this.registry = Objects.requireNonNull(registry);
        this.calcInstantiator = Objects.requireNonNull(calcInstantiator);
    }

    @Override
    public Void casePowerInfrastructureRepository(PowerInfrastructureRepository repo) {
        // delegate switch to all nested (child) elements
        repo.getContainedPowerProvidingEntities().forEach(this::doSwitch);
        return null;
    }

    /**
     * Update the power model for a {@link PowerDistributionUnit}.
     * 
     * @param The
     *            updated PDU.
     * @return Nothing.
     */
    @Override
    public Void casePowerDistributionUnit(PowerDistributionUnit powerDistributionUnit) {
        this.casePowerProvidingEntity(powerDistributionUnit);
        return null;
    }

    /**
     * Update the power model for a {@link PowerProvidingEntity}.
     * 
     * @param The
     *            updated {@link PowerProvidingEntity} entity.
     * @return Nothing.
     */
    @Override
    public Void casePowerProvidingEntity(PowerProvidingEntity ppe) {
        // process all nested elements first
        ppe.getNestedPowerConsumingEntities().forEach(this::doSwitch);
        this.registry.updateDistributionPowerModel(ppe,
                this.calcInstantiator.instantiatePowerProvidingEntityCalculator(ppe));
        return null;
    }

    /**
     * Update the power model for a {@link MountedPowerDistributionUnit}.
     * 
     * @param The
     *            updated mounted PDU.
     * @return Nothing.
     */
    @Override
    public Void caseMountedPowerDistributionUnit(MountedPowerDistributionUnit mountedPdu) {
        return this.casePowerDistributionUnit(mountedPdu);
    }

    /**
     * Update the power model for a power-consuming resource ({@link PowerConsumingResource}) such
     * as a CPU, HDD etc.
     * 
     * @param powerConsumingResource
     *            The resource for which the power model is updated.
     * @return Nothing.
     */
    @Override
    public Void casePowerConsumingResourceSet(final PowerConsumingResourceSet powerConsumingResource) {
        this.registry.updateResourcePowerModel(powerConsumingResource,
                this.calcInstantiator.instantiateResourceCalculator(powerConsumingResource));
        return null;
    }

    @Override
    public Void caseStatefulPowerConsumingResourceSet(final StatefulPowerConsumingResourceSet powerConsumingResource) {
        this.registry.updateStatefulPowerConsumingResource(powerConsumingResource,
                this.calcInstantiator.instantiateStatefulResourcePowerModelCalculator(powerConsumingResource));
        return null;
    }

}
