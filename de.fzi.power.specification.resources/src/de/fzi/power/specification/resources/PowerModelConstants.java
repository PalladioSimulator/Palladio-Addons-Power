package de.fzi.power.specification.resources;

import java.io.IOException;
import java.util.Collections;

import javax.measure.quantity.Energy;
import javax.measure.quantity.Power;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.jscience.physics.amount.Amount;

import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.DistributionPowerModelSpecification;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.ResourcePowerModelSpecification;

public final class PowerModelConstants {

    private static final String PATHMAP_POWER_MODEL_MODELS_COMMON_POWER_MODELS_POWERMODEL = "pathmap://POWER_MODELS_MODELS/models/commonSpecification.spec";

    // Constants for linear power model, TODO consolidate
    public static final ResourcePowerModelSpecification LINEAR_POWER_MODEL;
    public static final FixedFactor LINEAR_POWER_MODEL_MIN_CONSUMPTION;
    public static final FixedFactor LINEAR_POWER_MODEL_MAX_CONSUMPTION;
    public static final MeasuredFactor LINEAR_POWER_MODEL_UTILIZATION;

    public static final DistributionPowerModelSpecification LINEAR_PASSTHROUGH_DISTRIBUTION;

    public static final ConsumptionFactor LINEAR_PASSTHROUGH_DISTRIBUTION_CONSTANT_LOSS;

    // Constants for non-linear power model
    public static final ResourcePowerModelSpecification NONLINEAR_REGRESSION_MODEL;
    public static final FixedFactor NONLINEAR_REGRESSION_MODEL_MIN_CONSUMPTION;
    public static final FixedFactor NONLINEAR_REGRESSION_MODEL_MAX_CONSUMPTION;
    public static final FixedFactor NONLINEAR_REGRESSION_MODEL_EXPONENT;
    public static final MeasuredFactor NONLINEAR_REGRESSION_MODEL_UTILIZATION;

    // Constants for interpolation/regression model
    public static final ResourcePowerModelSpecification INTERPOLATION_MODEL;
    public static final FixedFactor INTERPOLATION_0_UTIL;
    public static final FixedFactor INTERPOLATION_10_UTIL;
    public static final FixedFactor INTERPOLATION_20_UTIL;
    public static final FixedFactor INTERPOLATION_30_UTIL;
    public static final FixedFactor INTERPOLATION_40_UTIL;
    public static final FixedFactor INTERPOLATION_50_UTIL;
    public static final FixedFactor INTERPOLATION_60_UTIL;
    public static final FixedFactor INTERPOLATION_70_UTIL;
    public static final FixedFactor INTERPOLATION_80_UTIL;
    public static final FixedFactor INTERPOLATION_90_UTIL;
    public static final FixedFactor INTERPOLATION_100_UTIL;

    public static final DeclarativePowerModelSpecification DECLARATIVE_LINEAR_POWER_MODEL;
    public static final DeclarativePowerModelSpecification DECLARATIVE_LINEAR_PASSTHROUGH_MODEL;

    static {

        final ResourceSet resourceSet = new ResourceSetImpl();
        final Resource resource = resourceSet
                .createResource(URI.createURI(PATHMAP_POWER_MODEL_MODELS_COMMON_POWER_MODELS_POWERMODEL, true));
        try {
            resource.load(Collections.EMPTY_MAP);
        } catch (final IOException e) {
            // TODO Auto-generated catch block. Use eclipse error log instead?
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // TODO load models per hierarchy, not per ID for nested
        // elements/attributes?
        LINEAR_POWER_MODEL = (ResourcePowerModelSpecification) resource.getEObject("_daqEMDgXEeSFuYf_V61WsQ");
        LINEAR_POWER_MODEL_MIN_CONSUMPTION = (FixedFactor) resource.getEObject("_vkR8ADgXEeS9Ksbwfez2QA");
        LINEAR_POWER_MODEL_MAX_CONSUMPTION = (FixedFactor) resource.getEObject("_yosvQDgXEeS9Ksbwfez2QA");
        LINEAR_POWER_MODEL_UTILIZATION = (MeasuredFactor) resource.getEObject("_2l6y0jnEEeSXp6PobgrWpg");
        LINEAR_PASSTHROUGH_DISTRIBUTION = (DistributionPowerModelSpecification) resource
                .getEObject("_EzkPUDqsEeSeEKsoUNmaIw");
        LINEAR_PASSTHROUGH_DISTRIBUTION_CONSTANT_LOSS = (ConsumptionFactor) resource
                .getEObject("_b_IXADqsEeSeEKsoUNmaIw");

        NONLINEAR_REGRESSION_MODEL = (ResourcePowerModelSpecification) resource.getEObject("_daqEMDgXEeSFuYp_X61Wsr");
        NONLINEAR_REGRESSION_MODEL_MIN_CONSUMPTION = (FixedFactor) resource.getEObject("_vkR8ADgXEeS9Ksbwfez3NA");
        NONLINEAR_REGRESSION_MODEL_MAX_CONSUMPTION = (FixedFactor) resource.getEObject("_yosvQDgXEeS9Ksbwfqy4NA");
        NONLINEAR_REGRESSION_MODEL_EXPONENT = (FixedFactor) resource.getEObject("_yosvQDgZGeS9Ksbwfqy4NA");
        NONLINEAR_REGRESSION_MODEL_UTILIZATION = (MeasuredFactor) resource.getEObject("_2l6y0jnEEeSWp6PobgrW4NA");

        INTERPOLATION_MODEL = (ResourcePowerModelSpecification) resource.getEObject("_daqEMDgXEeSFuYp_X61Wxp");
        INTERPOLATION_0_UTIL = (FixedFactor) resource.getEObject("_vkR8ADgXEeS9Ksbwfez3XP");
        INTERPOLATION_10_UTIL = (FixedFactor) resource.getEObject("_yosvQDgXEeS9Ksbwfqy4XP");
        INTERPOLATION_20_UTIL = (FixedFactor) resource.getEObject("_yosvQDgZGeS9Ksbwfqy4XP");
        INTERPOLATION_30_UTIL = (FixedFactor) resource.getEObject("_yosvQDgZGeS9Ksbwfqy5XP");
        INTERPOLATION_40_UTIL = (FixedFactor) resource.getEObject("_yosvQDgZGeS9Ksbwfqy6XP");
        INTERPOLATION_50_UTIL = (FixedFactor) resource.getEObject("_yosvQDgZGeS9Ksbwfqy7XP");
        INTERPOLATION_60_UTIL = (FixedFactor) resource.getEObject("_yosvQDgZGeS9Ksbwfqy8XP");
        INTERPOLATION_70_UTIL = (FixedFactor) resource.getEObject("_yosvQDgZGeS9Ksbwfqy9XP");
        INTERPOLATION_80_UTIL = (FixedFactor) resource.getEObject("_yosvQDgZGeS9Ksbwfqy10P");
        INTERPOLATION_90_UTIL = (FixedFactor) resource.getEObject("_yosvQDgZGeS9Ksbwfqy11P");
        INTERPOLATION_100_UTIL = (FixedFactor) resource.getEObject("_yosvQDgZGeS9Ksbwfqy12P");

        DECLARATIVE_LINEAR_POWER_MODEL = (DeclarativePowerModelSpecification) resource
                .getEObject("_R_P5QmOQEeWW76L-WpK6kQ");
        DECLARATIVE_LINEAR_PASSTHROUGH_MODEL = (DeclarativePowerModelSpecification) resource
                .getEObject("_iIhDwGd-EeWSzN49MVDdQw");
    }

    public static final Amount<Power> ZERO_POWER = Amount.valueOf(0, SI.WATT);

    /**
     * A {@link Unit} instance denoting the energy unit watt-hours ({@code Wh}).
     */
    public static final Unit<Energy> WATT_HOURS = SI.WATT.times(NonSI.HOUR).asType(Energy.class);
    // TODO more stuff
}
