package de.fzi.power.interpreter.calculators.energy;

import javax.measure.Measurable;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Power;

import org.jscience.physics.amount.Amount;

/**
 * This class contains an implementation of <b>Simpson's rule</b> for numerical integration
 * given a series of sampling points and a sampling rate (more precisely, the temporal difference between
 * two consecutive sampling points).<br>
 * This implementation is tailored to calculating cumulative energy consumption based on power consumption samples. 
 * For details about Simpson's rule, cf. {@link #calculateNextInternal()}.
 * @see AbstractCumulativeEnergyCalculator
 * @author Florian Rosenthal
 */
public class SimpsonRuleCumulativeEnergyCalculator extends AbstractCumulativeEnergyCalculator {

    private static final int INIT_STEPS = 2;
    private static final int REQUIRED_ENERGY_SAMPLES = 2;
    private static final int REQUIRED_POWER_SAMPLES = 3;
    
    private Amount<Duration> weighting;
    
    /**
     * Initializes a new instance of the {@link SimpsonRuleCumulativeEnergyCalculator} class.
     */
    public SimpsonRuleCumulativeEnergyCalculator() {
        super(REQUIRED_POWER_SAMPLES, REQUIRED_ENERGY_SAMPLES, INIT_STEPS);
    }

    /**
     * Initializes a new instance of the {@link SimpsonRuleCumulativeEnergyCalculator} class with given sampling period
     * and initial offset.
     * @param samplingPeriod A {@link Measurable} denoting the sampling period,
     * i.e., the temporal difference between two consecutive power samples.
     * @param initialOffset A {@link Measurable} denoting the temporal offset of the first power sample,
     * i.e., the point in time it was taken.
     * @throws IllegalArgumentException An {@link IllegalArgumentException} is thrown in one of the following cases:
     * <ul>
     * <li>{@code samplingPeriod} is {@code null} or does not represent a positive duration</li>
     * <li>{@code initialOffset} is {@code null} or represents a negative duration</li>
     * </ul>
     * @see #SimpsonRuleCumulativeEnergyCalculator()
     * @see #getDefaultResultUnit()
     * @see #setOffset(Measurable)
     * @see #setSamplingPeriod(Measurable)
     * @see #getResultUnit()
     */
    public SimpsonRuleCumulativeEnergyCalculator(Measurable<Duration> samplingPeriod, Measurable<Duration> initialOffset) {
        super(REQUIRED_POWER_SAMPLES, REQUIRED_ENERGY_SAMPLES, INIT_STEPS, samplingPeriod, initialOffset);
    }
    
    @Override
    public void setSamplingPeriod(Measurable<Duration> samplingPeriod) {
        super.setSamplingPeriod(samplingPeriod);
        
        this.weighting = getSamplingPeriod().divide(3);
    }
    
    /**
     * Calculates the next energy sample, i.e., does the next integration step using Simpson's rule.<br>
     * That is, for all energy samples {@code y[i]} it holds:<br>
     * {@code y[i] = y[i-2] + weighting * (x[i] + 4 * x[i-1] + x[i-2])}<br>
     * where {@code x[i], x[i-1], x[i-2]} are the most recent power samples<br>and {@code weighting = samplingPeriod / 3}.
     * @return An {@link Amount} denoting the calculated energy sample {@code y[i]}.
     */
    @Override
    protected Amount<Energy> calculateNextInternal() {
        assert getCurrentlyStoredEnergySamplesCount() == REQUIRED_ENERGY_SAMPLES;
        assert getCurrentlyStoredPowerSamplesCount() == REQUIRED_POWER_SAMPLES;
        
        // y[i] = y[i-2] + weighting * (x[i] + 4 * x[i-1] + x[i-2])
        Amount<Energy> y_i2 = getOldestEnergySample();
        Amount<Power> x_i = getMostRecentPowerSample();
        Amount<Power> x_i1 = getPowerSample(1);
        Amount<Power> x_i2 = getOldestPowerSample();
        
        return y_i2.plus(weighting.times(x_i.plus(x_i1.times(4)).plus(x_i2)));
    }
      
    @Override
    protected Amount<Energy> calculateInitValue(int initValueIndex) {
       assert initValueIndex <= INIT_STEPS;
       assert getCurrentlyStoredPowerSamplesCount() == initValueIndex;
       assert getCurrentlyStoredEnergySamplesCount() == initValueIndex - 1;
       
       Amount<Energy> result = null;
       if (initValueIndex == 1) {
           // first energy sample is to be calculated (constant offset)
           // y[0] = x[0] * initial offset
           Amount<Duration> initialOffset = getInitialOffset();
           if (initialOffset == null) {
               throw new IllegalStateException("This type of energy calculator/integrator needs an "
                       + "initial (time) offset to calculate the first energy sample."); 
           }
           result = getOldestPowerSample().times(initialOffset).to(getResultUnit());
       } else {
           // second energy sample is to be calculated
           // y[1] = y[0] + weighting * (x[1] + 4 * x[0])
           assert getCurrentlyStoredEnergySamplesCount() == 1;
           Amount<Power> x0 = getOldestPowerSample();
           Amount<Power> x1 = getMostRecentPowerSample();
           Amount<Energy> y0 = getMostRecentEnergySample(); 
           
           result = y0.plus(weighting.times(x1.plus(x0.times(4))));
       }
       return result;
    }

}
