package de.fz.power.interpreter.calculators.energy.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.measure.quantity.Duration;
import javax.measure.quantity.Energy;
import javax.measure.quantity.Power;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.jscience.physics.amount.Amount;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import de.fzi.power.interpreter.calculators.energy.AbstractCumulativeEnergyCalculator;

public abstract class AbstractCumulativeEnergyCalculatorTest {

    private static final double DELTA = Math.pow(10, -12);
    private static final Amount<Power> INPUT_POWER_SAMPLE = Amount.valueOf(100, SI.WATT);

    private MockEnergyCalculator calculatorUnderTest;
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Before
    public void setUp() throws Exception {
        this.calculatorUnderTest = new MockEnergyCalculator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testReset() {
        Amount<Duration> expectedInitialOffset = Amount.valueOf(0, SI.SECOND);
        Amount<Duration> expectedSamplingPeriod = Amount.valueOf(10, SI.SECOND);
        int expectedPowerSamplesCount = 0;
        int expectedEnergySamplesCount = 0;
        
        this.calculatorUnderTest.reset();
        
        assertEquals(expectedPowerSamplesCount, this.calculatorUnderTest.getPowerSamplesCount());
        assertEquals(expectedEnergySamplesCount, this.calculatorUnderTest.getEnergySamplesCount());
        
        assertTrue(expectedInitialOffset.approximates(this.calculatorUnderTest.getInitialOffset()));
        assertTrue(expectedSamplingPeriod.approximates(this.calculatorUnderTest.getSamplingPeriod()));
    }

    @Test
    public void testSetSamplingPeriodNull() {
        this.expectedException.expect(IllegalArgumentException.class);
        this.calculatorUnderTest.setSamplingPeriod(null);
    }

    @Test
    public void testSetSamplingPeriodNotPositive() {
        this.expectedException.expect(IllegalArgumentException.class);
        this.calculatorUnderTest.setSamplingPeriod(Amount.valueOf(0, NonSI.HOUR));
        this.expectedException = ExpectedException.none();
        this.expectedException.expect(IllegalArgumentException.class);
        this.calculatorUnderTest.setSamplingPeriod(Amount.valueOf(-1.5, SI.SECOND));
    }
    
    @Test
    public void testSetSamplingPeriod() {
        Amount<Duration> expectedSamplingPeriod = Amount.valueOf(42, SI.SECOND);
        this.calculatorUnderTest.setSamplingPeriod(expectedSamplingPeriod);
        assertEquals(expectedSamplingPeriod.doubleValue(SI.SECOND), this.calculatorUnderTest.getSamplingPeriod().doubleValue(SI.SECOND), DELTA);
    }
    
    @Test
    public void testSetOffsetNull() {
        this.expectedException.expect(IllegalArgumentException.class);
        this.calculatorUnderTest.setOffset(null);
    }

    @Test
    public void testSetOffsetNegative() {
        this.expectedException.expect(IllegalArgumentException.class);
        this.calculatorUnderTest.setOffset(Amount.valueOf(-1.5, SI.SECOND));
    }
    
    @Test
    public void testSetOffset() {
        Amount<Duration> expectedInitialOffset = Amount.valueOf(42, SI.SECOND);
        this.calculatorUnderTest.setOffset(expectedInitialOffset);
        assertEquals(expectedInitialOffset.doubleValue(SI.SECOND), this.calculatorUnderTest.getInitialOffset().doubleValue(SI.SECOND), DELTA);
    }

    @Test
    public void testGetResultUnit() {
        Unit<Energy> expectedUnit = SI.JOULE;
        assertEquals(expectedUnit, new MockEnergyCalculator(expectedUnit).getResultUnit());
    }

    @Test
    public void testCalculateNext() {
        //one init step as defined by calculator under test
        Amount<Energy> expectedEnergySample = Amount.valueOf(0, SI.JOULE); 
        
        //init step
        Amount<Energy> actual = this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE).to(SI.JOULE);
        assertEquals(expectedEnergySample.doubleValue(SI.JOULE), actual.doubleValue(SI.JOULE), DELTA);
        
        //first "regular" step of algorithm/calculator
        expectedEnergySample = INPUT_POWER_SAMPLE.times(Amount.valueOf(1, SI.SECOND)).to(SI.JOULE);
        actual = this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE).to(SI.JOULE);
        assertEquals(expectedEnergySample.doubleValue(SI.JOULE), actual.doubleValue(SI.JOULE), DELTA);
        
    }

   
    @Test
    public void testGetCurrentlyStoredPowerSamplesCount() {
        //up to 3 (according to calculator ctor) power samples can be stored, so check this
        assertEquals(0, this.calculatorUnderTest.getPowerSamplesCount());
        
        this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        assertEquals(1, this.calculatorUnderTest.getPowerSamplesCount());
        
        this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        assertEquals(2, this.calculatorUnderTest.getPowerSamplesCount());
        
        this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        assertEquals(3, this.calculatorUnderTest.getPowerSamplesCount());
        
        //now the interesting case: 3 are already stored, add a new one, oldest once should be replaced
        this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        assertEquals(3, this.calculatorUnderTest.getPowerSamplesCount());
    }

    @Test
    public void testGetCurrentlyStoredEnergySamplesCount() {
        //up to 2 (according to calculator ctor) energy samples can be stored, so check this
        assertEquals(0, this.calculatorUnderTest.getEnergySamplesCount());
        
        this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        assertEquals(1, this.calculatorUnderTest.getEnergySamplesCount());
        
        this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        assertEquals(2, this.calculatorUnderTest.getEnergySamplesCount());
        
        //now the interesting case: 2 are already stored, calculate a new one, oldest once should be replaced
        this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        assertEquals(2, this.calculatorUnderTest.getEnergySamplesCount());
    }

    @Test
    public void testGetOldestEnergySample() {
        assertNull(this.calculatorUnderTest.getOldestEnergySample());
        //up to 2 energy samples are stored
        Amount<Energy> expected = this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        assertEquals(expected.doubleValue(SI.JOULE), this.calculatorUnderTest.getOldestEnergySample().doubleValue(SI.JOULE), DELTA);
        
        Amount<Energy> nextExpected = this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        assertEquals(expected.doubleValue(SI.JOULE), this.calculatorUnderTest.getOldestEnergySample().doubleValue(SI.JOULE), DELTA);
     
        this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        assertEquals(nextExpected.doubleValue(SI.JOULE), this.calculatorUnderTest.getOldestEnergySample().doubleValue(SI.JOULE), DELTA);
    }
    
  @Test
  public void testGetMostRecentEnergySample() {
      assertNull(this.calculatorUnderTest.getMostRecentEnergySample());
      //up to 2 energy samples are stored
      Amount<Energy> expected = this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
      assertEquals(expected.doubleValue(SI.JOULE), this.calculatorUnderTest.getMostRecentEnergySample().doubleValue(SI.JOULE), DELTA);
      
      expected = this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
      assertEquals(expected.doubleValue(SI.JOULE), this.calculatorUnderTest.getMostRecentEnergySample().doubleValue(SI.JOULE), DELTA);
   
      expected = this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
      assertEquals(expected.doubleValue(SI.JOULE), this.calculatorUnderTest.getMostRecentEnergySample().doubleValue(SI.JOULE), DELTA);
  }

    @Test
    public void testGetEnergySampleIndexOutOfBounds() {
        this.expectedException.expect(IndexOutOfBoundsException.class);
        this.calculatorUnderTest.getEnergySample(-1);
        this.expectedException = ExpectedException.none();
        
        this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        //one energy sample calculated, so let's access the second (index = 1)
        this.expectedException.expect(IndexOutOfBoundsException.class);
        this.calculatorUnderTest.getEnergySample(1);
    }

    @Test
    public void testGetEnergySample() {
        //up to 2 energy samples are stored

        // access the most recent
        Amount<Energy> expectedMostRecent = this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        assertEquals(expectedMostRecent.doubleValue(SI.JOULE), this.calculatorUnderTest.getEnergySample(0).doubleValue(SI.JOULE), DELTA);
        
        // access the last two samples
        Amount<Energy> expectedLeastRecent = expectedMostRecent;
        expectedMostRecent = this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        
        assertEquals(expectedMostRecent.doubleValue(SI.JOULE), this.calculatorUnderTest.getEnergySample(0).doubleValue(SI.JOULE), DELTA);
        assertEquals(expectedLeastRecent.doubleValue(SI.JOULE), this.calculatorUnderTest.getEnergySample(1).doubleValue(SI.JOULE), DELTA);
     
        // again, access the last tow
        expectedLeastRecent = expectedMostRecent;
        expectedMostRecent = this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        
        assertEquals(expectedMostRecent.doubleValue(SI.JOULE), this.calculatorUnderTest.getEnergySample(0).doubleValue(SI.JOULE), DELTA);
        assertEquals(expectedLeastRecent.doubleValue(SI.JOULE), this.calculatorUnderTest.getEnergySample(1).doubleValue(SI.JOULE), DELTA);
    }
    
    @Test
    public void testGetOldestPowerSample() {
        assertNull(this.calculatorUnderTest.getOldestPowerSample());
        //up to 3 power samples are stored
        Amount<Power> firstInputSample = INPUT_POWER_SAMPLE;
        Amount<Power> secondInputSample = firstInputSample.times(2);
        Amount<Power> thirdInputSample = secondInputSample.times(2);
        Amount<Power> fourthInputSample = thirdInputSample.times(2);
        
        this.calculatorUnderTest.calculateNext(firstInputSample);
        assertEquals(firstInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getOldestPowerSample().doubleValue(SI.WATT), DELTA);
        
        this.calculatorUnderTest.calculateNext(secondInputSample);
        assertEquals(firstInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getOldestPowerSample().doubleValue(SI.WATT), DELTA);
     
        this.calculatorUnderTest.calculateNext(thirdInputSample);
        assertEquals(firstInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getOldestPowerSample().doubleValue(SI.WATT), DELTA);
        
        this.calculatorUnderTest.calculateNext(fourthInputSample);
        assertEquals(secondInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getOldestPowerSample().doubleValue(SI.WATT), DELTA);
    }

    @Test
    public void testGetMostRecentPowerSample() {
        assertNull(this.calculatorUnderTest.getMostRecentPowerSample());
        //up to 3 power samples are stored
        Amount<Power> firstInputSample = INPUT_POWER_SAMPLE;
        Amount<Power> secondInputSample = firstInputSample.times(2);
        Amount<Power> thirdInputSample = secondInputSample.times(2);
        Amount<Power> fourthInputSample = thirdInputSample.times(2);
        
        this.calculatorUnderTest.calculateNext(firstInputSample);
        assertEquals(firstInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getMostRecentPowerSample().doubleValue(SI.WATT), DELTA);
        
        this.calculatorUnderTest.calculateNext(secondInputSample);
        assertEquals(secondInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getMostRecentPowerSample().doubleValue(SI.WATT), DELTA);
     
        this.calculatorUnderTest.calculateNext(thirdInputSample);
        assertEquals(thirdInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getMostRecentPowerSample().doubleValue(SI.WATT), DELTA);
        
        this.calculatorUnderTest.calculateNext(fourthInputSample);
        assertEquals(fourthInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getMostRecentPowerSample().doubleValue(SI.WATT), DELTA);
    }
  
    @Test
    public void testGetPowerSampleIndexOutOfBounds() {
        this.expectedException.expect(IndexOutOfBoundsException.class);
        this.calculatorUnderTest.getPowerSample(-1);
        this.expectedException = ExpectedException.none();
        
        this.calculatorUnderTest.calculateNext(INPUT_POWER_SAMPLE);
        //one power sample stored, so let's access the second (index = 1)
        this.expectedException.expect(IndexOutOfBoundsException.class);
        this.calculatorUnderTest.getPowerSample(1);
    }

    @Test
    public void testGetPowerSample() {
        //up to 3 power samples are stored
        Amount<Power> firstInputSample = INPUT_POWER_SAMPLE;
        Amount<Power> secondInputSample = firstInputSample.times(2);
        Amount<Power> thirdInputSample = secondInputSample.times(2);
        Amount<Power> fourthInputSample = thirdInputSample.times(2);
        
        // access the most recent
        this.calculatorUnderTest.calculateNext(firstInputSample);
        assertEquals(firstInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getPowerSample(0).doubleValue(SI.WATT), DELTA);
        
        // access the last two samples
        this.calculatorUnderTest.calculateNext(secondInputSample);
        assertEquals(secondInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getPowerSample(0).doubleValue(SI.WATT), DELTA);
        assertEquals(firstInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getPowerSample(1).doubleValue(SI.WATT), DELTA);
     
        // access the last three
        this.calculatorUnderTest.calculateNext(thirdInputSample);
        assertEquals(thirdInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getPowerSample(0).doubleValue(SI.WATT), DELTA);
        assertEquals(secondInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getPowerSample(1).doubleValue(SI.WATT), DELTA);
        assertEquals(firstInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getPowerSample(2).doubleValue(SI.WATT), DELTA);
        
        // again, access the last three
        this.calculatorUnderTest.calculateNext(fourthInputSample);
        assertEquals(fourthInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getPowerSample(0).doubleValue(SI.WATT), DELTA);
        assertEquals(thirdInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getPowerSample(1).doubleValue(SI.WATT), DELTA);
        assertEquals(secondInputSample.doubleValue(SI.WATT), this.calculatorUnderTest.getPowerSample(2).doubleValue(SI.WATT), DELTA);
    }
    
    private static class MockEnergyCalculator extends AbstractCumulativeEnergyCalculator {

        protected MockEnergyCalculator(Unit<Energy> resultUnit) {
            super(3, 2, 1, Amount.valueOf(5, SI.SECOND), Amount.valueOf(10, SI.SECOND), resultUnit);
        }
        
        protected MockEnergyCalculator() {
            super(3, 2, 1);
        }

        @Override
        protected Amount<Energy> calculateNextInternal() {
            //some kind of identity function, multiply by 1s yields an energy amount
            return getMostRecentPowerSample().times(Amount.valueOf(1, SI.SECOND)).to(getResultUnit());
        }

        @Override
        protected Amount<Energy> calculateInitValue(int initValueIndex) {
            //no initialization energy value
            return Amount.valueOf(0, getResultUnit());
        }
        
        private int getEnergySamplesCount() {
            return super.getCurrentlyStoredEnergySamplesCount();
        }
        
        private int getPowerSamplesCount() {
            return super.getCurrentlyStoredPowerSamplesCount();
        }
        
        @Override
        protected Amount<Energy> getEnergySample(int index) {
            return super.getEnergySample(index);
        }
        
        @Override
        protected Amount<Energy> getOldestEnergySample() {
            return super.getOldestEnergySample();
        }
        
        @Override
        protected Amount<Energy> getMostRecentEnergySample() {
            return super.getMostRecentEnergySample();
        }
        
        @Override
        protected Amount<Power> getPowerSample(int index) {
            return super.getPowerSample(index);
        }
        
        @Override
        protected Amount<Power> getOldestPowerSample() {
            return super.getOldestPowerSample();
        }
        
        @Override
        protected Amount<Power> getMostRecentPowerSample() {
            return super.getMostRecentPowerSample();
        }
    }
}
