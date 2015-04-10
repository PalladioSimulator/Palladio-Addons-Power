package de.fzi.power.interpreter.calculators.energy;

import java.util.Arrays;

import javax.measure.Measurable;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Power;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.jscience.physics.amount.Amount;

import de.fzi.power.specification.resources.PowerModelConstants;

/**
 * This abstract class is designed to be the base class of all algorithms that calculate cumulative energy consumptions
 * based on power consumption samples (sampling points), i.e., in an integrator-like fashion.
 * Usually, inheriting subclasses will implement certain numerical algorithms for integration of time series.
 * @author Florian Rosenthal
 */
public abstract class AbstractCumulativeEnergyCalculator {

    private final int numberOfInitSteps;
    private int calculatedEnergySamples;

    private final CircularDataContainer<Amount<Power>> powerSamplesRequiredForCalc;
    private final CircularDataContainer<Amount<Energy>> energySamplesRequiredForCalc;
    private Amount<Duration> samplingPeriod;
    private Amount<Duration> initialOffset;
    private Unit<Energy> resultUnit;
        
    private static final Amount<Duration> ZERO_DURATION = Amount.valueOf(0, SI.SECOND);
    //default sampling period: 10s
    private static final Amount<Duration> DEFAULT_SAMPLING_PERIOD = Amount.valueOf(10, SI.SECOND);

    /**
     * Initializes a new instance of the {@link AbstractCumulativeEnergyCalculator} class with the given properties.
     * @param powerSamplesNeeded A nonnegative integer indicating the number of power samples required for the calculation 
     * of a new energy sample.
     * @param energySamplesNeeded A nonnegative integer indicating the number most recently calculated energy samples
     * required for the calculation of a new one.
     * @param numberOfInitSteps A nonnegative integer indicating the number of initialization steps the implemented algorithm requires, i.e.,
     * the amount of the first energy samples that are potentially calculated in a different way.
     * @param samplingPeriod A {@link Measurable} denoting the sampling period, i.e., the temporal difference between two consecutive power samples.
     * @param initialOffset A {@link Measurable} denoting the temporal offset of the first power sample, i.e., the point in time it was taken. 
     * @param resultUnit A {@link Unit} which defining the unit of the calculated energy samples. 
     * @throws IllegalArgumentException An {@link IllegalArgumentException} is thrown in one of the following cases:
     * <ul>
     * <li>{@code powerSamplesNeeded}, {@code energySamplesNeeded} or {@code numberOfInitSteps} are {@code < 0}</li>
     * <li>{@code resultUnit} is {@code null}</li>
     * <li>{@code samplingPeriod} does not represent a positive duration</li>
     * <li>{@code initialOffset} represents a negative duration</li>
     * </ul>
     * @see #AbstractCumulativeEnergyCalculator(int, int, int)
     * @see #AbstractCumulativeEnergyCalculator(int, int, int, Measurable, Measurable)
     * @see #getDefaultResultUnit()
     */
    protected AbstractCumulativeEnergyCalculator(int powerSamplesNeeded, int energySamplesNeeded, int numberOfInitSteps, 
            Measurable<Duration> samplingPeriod, Measurable<Duration> initialOffset, Unit<Energy> resultUnit) {
        
        if (powerSamplesNeeded < 0) {
            throw new IllegalArgumentException("Calculation cannot depend on " + powerSamplesNeeded + " power samples.");
        }
        if (energySamplesNeeded < 0) {
            throw new IllegalArgumentException("Calculation cannot depend on " + energySamplesNeeded
                    + " energy samples.");
        }
        if (numberOfInitSteps < 0) {
            throw new IllegalArgumentException("Calculation cannot have less than 0 init steps.");
        }
        if (resultUnit == null) {
            throw new IllegalArgumentException("Given result unit must not be null.");
        }
        
        this.powerSamplesRequiredForCalc = new CircularDataContainer<Amount<Power>>(powerSamplesNeeded);
        this.energySamplesRequiredForCalc = new CircularDataContainer<Amount<Energy>>(energySamplesNeeded);
        this.numberOfInitSteps = numberOfInitSteps;
        this.calculatedEnergySamples = 0;
        this.resultUnit = resultUnit;
        setSamplingPeriod(samplingPeriod);
        setOffset(initialOffset);
    }
    
    /**
     * Initializes a new instance of the {@link AbstractCumulativeEnergyCalculator} class with the given properties.
     * The resulting energy samples are expressed using the default energy unit defined in this class.
     * @param powerSamplesNeeded A nonnegative integer indicating the number of power samples required for the calculation 
     * of a new energy sample.
     * @param energySamplesNeeded A nonnegative integer indicating the number most recently calculated energy samples
     * required for the calculation of a new one.
     * @param numberOfInitSteps A nonnegative integer indicating the number of initialization steps the implemented algorithm requires, i.e.,
     * the amount of the first energy samples that are potentially calculated in a different way.
     * @param samplingPeriod A {@link Measurable} denoting the sampling period, i.e., the temporal difference between two consecutive power samples.
     * @param initialOffset A {@link Measurable} denoting the temporal offset of the first power sample, i.e., the point in time it was taken. 
     * @throws IllegalArgumentException An {@link IllegalArgumentException} is thrown in one of the following cases:
     * <ul>
     * <li>{@code powerSamplesNeeded}, {@code energySamplesNeeded} or {@code numberOfInitSteps} are {@code < 0}</li>
     * <li>{@code samplingPeriod} does not represent a positive duration</li>
     * <li>{@code initialOffset} represents a negative duration</li>
     * </ul>
     * @see #AbstractCumulativeEnergyCalculator(int, int, int, Measurable, Measurable, Unit)
     * @see #AbstractCumulativeEnergyCalculator(int, int, int)
     * @see #getDefaultResultUnit()
     */
    protected AbstractCumulativeEnergyCalculator(int powerSamplesNeeded, int energySamplesNeeded, int numberOfInitSteps, 
            Measurable<Duration> samplingPeriod, Measurable<Duration> initialOffset) {
        
       this(powerSamplesNeeded, energySamplesNeeded, numberOfInitSteps, samplingPeriod, initialOffset, getDefaultResultUnit());
    }
    
    /**
     * Initializes a new instance of the {@link AbstractCumulativeEnergyCalculator} class with the given properties.
     * The resulting energy samples are expressed using the default energy unit defined in this class.
     * Additionally, a default sampling period of {@code 10s} and an initial offset of {@code 0s} is assumed.
     * @param powerSamplesNeeded A nonnegative integer indicating the number of power samples required for the calculation 
     * of a new energy sample.
     * @param energySamplesNeeded A nonnegative integer indicating the number most recently calculated energy samples
     * required for the calculation of a new one.
     * @param numberOfInitSteps A nonnegative integer indicating the number of initialization steps the implemented algorithm requires, i.e.,
     * the amount of the first energy samples that are potentially calculated in a different way.
     * @throws IllegalArgumentException An {@link IllegalArgumentException} is thrown if
     * {@code powerSamplesNeeded}, {@code energySamplesNeeded} or {@code numberOfInitSteps} are {@code < 0}
     * @see #getDefaultResultUnit()
     * @see #AbstractCumulativeEnergyCalculator(int, int, int, Measurable, Measurable, Unit)
     */
    protected AbstractCumulativeEnergyCalculator(int powerSamplesNeeded, int energySamplesNeeded, int numberOfInitSteps) {
        this(powerSamplesNeeded, energySamplesNeeded, numberOfInitSteps, DEFAULT_SAMPLING_PERIOD, ZERO_DURATION, getDefaultResultUnit());
    }

    /**
     * Resets the state of this instance.
     * In particular, the initial offset is set to {@code 0s}, the sampling period is set to default ({@code 10s})
     * and all so far calculated energy samples are discarded. Additionally, all power samples kept for calculation are cleared. 
     */
    public void reset() {
        this.calculatedEnergySamples = 0;
        this.energySamplesRequiredForCalc.clear();
        this.powerSamplesRequiredForCalc.clear();
        this.initialOffset = ZERO_DURATION;
        this.samplingPeriod = DEFAULT_SAMPLING_PERIOD;
    }
    
    /**
     * Sets the sampling period, i.e., the temporal difference between the next consecutive power samples.
     * This might be useful if the sampling points are not equidistant.
     * @param samplingPeriod An {@link Amount} denoting the sampling period,
     * i.e., the temporal difference between two consecutive power samples.
     * @throws IllegalArgumentException In case the given duration is not positive
     */
    private void setSamplingPeriod(Amount<Duration> samplingPeriod) {
        if (!samplingPeriod.isGreaterThan(ZERO_DURATION)) {
            throw new IllegalArgumentException("Sampling period, e.g., the window increment, must be positive.");
        }
        this.samplingPeriod = samplingPeriod;
    }
    
    /**
     * Sets the sampling period, i.e., the temporal difference between the next consecutive power samples.
     * This might be useful if the sampling points are not equidistant.
     * @param samplingPeriod A {@link Measurable} denoting the sampling period,
     * i.e., the temporal difference between two consecutive power samples.
     * @throws IllegalArgumentException In case the given duration is {@code null} or not positive
     */
    public void setSamplingPeriod(Measurable<Duration> samplingPeriod) {
        if (samplingPeriod == null) {
            throw new IllegalArgumentException("Sampling period must not be null.");
        }
        //delegate to private overlaod
        setSamplingPeriod(Amount.valueOf(samplingPeriod.doubleValue(SI.SECOND), SI.SECOND));
    }
    
    /**
     * Sets the initial offset, i.e., the temporal offset of the first power sample.
     * @param initialOffset An {@link Amount} denoting the temporal offset, i.e., the point in time it was taken.
     * @throws IllegalArgumentException In case the given duration is negative
     */
    private void setOffset(Amount<Duration> initialOffset) {
        if (initialOffset.isLessThan(ZERO_DURATION)) {
            throw new IllegalArgumentException("Initial offset, e.g., the window length, must be >= 0.");
        }
        this.initialOffset = initialOffset;
    }
    
    /**
     * Sets the initial offset, i.e., the temporal offset of the first power sample.
     * @param initialOffset A {@link Measurable} denoting the temporal offset, i.e., the point in time it was taken.
     * @throws IllegalArgumentException In case {@code initialOffset} is {@code null} or negative
     */
    public void setOffset(Measurable<Duration> initialOffset) {
        if (initialOffset == null) {
            throw new IllegalArgumentException("Given initial offset must not be null.");
        }
        //delegate to private overloading
        setOffset(Amount.valueOf(initialOffset.doubleValue(SI.SECOND), SI.SECOND));
    }
    
    /**
     * Gets the initial offset.
     * @return An {@link Amount} denoting the temporal offset of the first sampling point/power sample.
     */
    public Amount<Duration> getInitialOffset() {
        return this.initialOffset;
    }
    
    /**
     * Gets the current sampling period, i.e, the temporal difference between two consecutive power samples.
     * @return An {@link Amount} denoting the sampling period.
     */
    public Amount<Duration> getSamplingPeriod() {
        return this.samplingPeriod;
    }
    
    /**
     * Gets the unit in which the calculated energy samples are expressed.
     * @return An {@link Unit} denoting an energy unit.
     */
    public Unit<Energy> getResultUnit() {
        return this.resultUnit;
    }
    
    /**
     * Gets the energy unit which is used by default.
     * @return A {@link Unit} denoting {@code Wh} (watt-hours).
     * @see PowerModelConstants#WATT_HOURS
     */
    public static Unit<Energy> getDefaultResultUnit() {
        return PowerModelConstants.WATT_HOURS;
    }
    
    /**
     * Calculates the next energy sample, i.e., the next integration step is done. 
     * @param newPowerSample A {@link Measurable} holding the (most recent) power sample to be used for calculation.
     * @return An {@link Amount} holding the calculated cumulative energy sample.
     * @throws IllegalArgumentException In case the given power sample is {@code null}.
     */
    public final Amount<Energy> calculateNext(Measurable<Power> newPowerSample) {
        if (newPowerSample == null) {
            throw new IllegalArgumentException("Given power sample must not be null.");
        }
        Amount<Energy> result = null;
        //use watts as internal power unit
        this.powerSamplesRequiredForCalc.add(Amount.valueOf(newPowerSample.doubleValue(SI.WATT), SI.WATT));
        if (this.calculatedEnergySamples < this.numberOfInitSteps) {
            result = calculateInitValue(this.calculatedEnergySamples + 1);
        } else {
            result = calculateNextInternal();
        }
        ++this.calculatedEnergySamples;
        this.energySamplesRequiredForCalc.add(result);
        return result.to(this.resultUnit);
    }

    /**
     * Method to be implemented by subclasses containing the integration algorithm.
     * @return The calculated energy sample.
     */
    protected abstract Amount<Energy> calculateNextInternal();
    /**
     * Method to be implemented by subclasses which contains the initialization steps.
     * @param initValueIndex The number of the init step.
     * @return The energy sample calculated by the init step.
     */
    protected abstract Amount<Energy> calculateInitValue(int initValueIndex);
    
    /**
     * Gets the number of power samples/sampling points which are currently kept for integration.
     * @return A value {@code <= powerSamplesNeeded} in case not all required init steps have been done yet, <br>
     * {@code powerSamplesNeeded} otherwise.
     * @see #AbstractCumulativeEnergyCalculator(int, int, int, Amount, Amount, Unit)
     */
    protected int getCurrentlyStoredPowerSamplesCount() {
        return this.powerSamplesRequiredForCalc.size();
    }
    
    /**
     * Gets the number of already calculated energy samples which are currently kept for integration.
     * @return A value {@code <= energySamplesNeeded} in case not all required init steps have been done yet, <br>
     * {@code energySamplesNeeded} otherwise.
     * @see #AbstractCumulativeEnergyCalculator(int, int, int, Amount, Amount, Unit)
     */
    protected int getCurrentlyStoredEnergySamplesCount() {
        return this.energySamplesRequiredForCalc.size();
    }
    
    /**
     * Gets the least recently calculated energy sample (expressed in terms of previous integration steps)
     * which has to be kept for the next integration step.
     * @return The energy sample that was calculated {@code energySamplesNeeded}
     * steps before in case all init steps have been done, the least recent otherwise.
     * @see #getEnergySample(int)
     */
    protected Amount<Energy> getOldestEnergySample() {
        return this.energySamplesRequiredForCalc.getOldestElement();
    }
    
    /**
     * Gets the energy sample associated with the given index.<br>
     * Note, that index is related to previous integration steps, i.e.,: 
     * <ul>
     * <li>{@code index = 0} denotes the energy sample calculated in the most recent integration step</li>
     * <li>{@code index = 1} denotes the energy sample calculated in the last but one step</li>
     * <li>...</li>
     * <li>{@code index = energySamplesNeeded - 1} denotes the least recent energy sample that is available</li>
     * </ul> 
     * @param index An integer value as described above.
     * @return The energy sample corresponding to the given index or {@code null} if none are available.
     * @throws IndexOutOfBoundsException In case the given {@code index} is not within the range described above.
     */
    //age = 0: most recent value
    //age = 1: last but one value
    //age = energySamplesNeeded - 1: oldest value
    protected Amount<Energy> getEnergySample(int index) {
        if (index < 0 || (!this.energySamplesRequiredForCalc.isEmpty() && index > this.energySamplesRequiredForCalc.size() - 1)) {
            throw new IndexOutOfBoundsException();
        }
        if (this.energySamplesRequiredForCalc.isEmpty()) {
            return null;
        }
        return this.energySamplesRequiredForCalc.get(this.energySamplesRequiredForCalc.size() - 1 - index);
    }
    
    /**
    * Gets the least recently power sample (expressed in terms of previous integration steps)
    * which has to be kept for the next integration step.<br>
    * @return The power sample that was passed to {@link #calculateNext(Amount)}
    * {@code powerSamplesNeede} steps before in case all init steps have been done,
    * the least recent one otherwise.
    * @see #calculateNext(Amount)
    * @see #getPowerSample(int)
    */
    protected Amount<Power> getOldestPowerSample() {
        return this.powerSamplesRequiredForCalc.getOldestElement();
    }
    
    /**
     * Gets the stored power sample associated with the given index.<br>
     * Note, that index is related to previous integration steps, i.e.,: 
     * <ul>
     * <li>{@code index = 0} denotes the power sample used in the most recent integration step</li>
     * <li>{@code index = 1} denotes the power sample used in the last but one step</li>
     * <li>...</li>
     * <li>{@code index = powerSamplesNeeded - 1} denotes the least recent power sample that is available</li>
     * </ul> 
     * @param index An integer value as described above.
     * @return The power sample corresponding to the given index, or {@code null} if none are available.
     * @throws IndexOutOfBoundsException In case the given {@code index} is not within the range described above.
     */
    //age = 0: most recent value
    //age = 1: last but one value
    //age = powerSamplesNeeded - 1: oldest value
    protected Amount<Power> getPowerSample(int index) {
        if (index < 0 || (!this.powerSamplesRequiredForCalc.isEmpty() && index > this.powerSamplesRequiredForCalc.size() - 1)) {
            throw new IndexOutOfBoundsException();
        }
        if (this.powerSamplesRequiredForCalc.isEmpty())
            return null;
        return this.powerSamplesRequiredForCalc.get(this.powerSamplesRequiredForCalc.size() - 1 - index);
    }
    
    /**
     * Gets the power sample that was used for the most recent integration step.
     * @return An {@link Amount} denoting the power sample used for the most recent integration step.
     */
    protected Amount<Power> getMostRecentPowerSample() {
        return getPowerSample(0);
    }
    
    /** 
     * Gets the energy sample that was calculated in the last integration step.
    * @return An {@link Amount} denoting the energy sample that was most recently calulated.
    */
    protected Amount<Energy> getMostRecentEnergySample() {
        return getEnergySample(0);
    }
    
    /**
     * Circular, fixed size buffer that is used internally to store the samples required for calculation.
     * @author Florian Rosenthal
     *
     * @param <T> Type of the elements to be store in the buffer.
     */
    private static final class CircularDataContainer<T> {
        
        //the data container will be used in a circular way
        private final T[] data;
        //pointer to the least recent element of the data
        //that is the element which was added least recently
        //this is as base "address" for all data accesses
        private int oldestElementPointer = 0;
        private int currentElementCount = 0;

        @SuppressWarnings("unchecked")
        private CircularDataContainer(int size) {
            assert size > 0;
            Object[] tmp = new Object[size];
            data = (T[]) tmp;
        }

        public int size() {
            return this.currentElementCount;
        }

        public int maxSize() {
            return this.data.length;
        }
        
        public boolean isEmpty() {
            return this.currentElementCount == 0;
        }

        public boolean add(T e) {
            if (size() == maxSize()) {
                removeOldestElement();
            }
            int index = this.oldestElementPointer + this.currentElementCount;
            index %= maxSize();

            this.data[index] = e;
            this.currentElementCount++;
            return true;
        }

        public T getOldestElement() {
            return this.data[oldestElementPointer];
        }

        public boolean removeOldestElement() {
            if (!isEmpty()) {
                this.data[oldestElementPointer] = null;
                adjustOldestElementPointer();
                this.currentElementCount--;
            }
            return true;
        }

        private void adjustOldestElementPointer() {
            this.oldestElementPointer++;
            this.oldestElementPointer %= maxSize();
            assert this.oldestElementPointer >= 0 && this.oldestElementPointer < maxSize();
        }
        
        public void clear() {
            Arrays.fill(data, null);
            this.oldestElementPointer = this.currentElementCount = 0;

        }

        public T get(int index) {
            assert index >= 0;
            return this.data[(this.oldestElementPointer + index) % maxSize()];
        }

    }
}
