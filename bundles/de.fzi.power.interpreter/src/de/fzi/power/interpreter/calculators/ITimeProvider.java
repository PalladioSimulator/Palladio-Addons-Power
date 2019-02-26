package de.fzi.power.interpreter.calculators;

import javax.measure.quantity.Duration;

import org.jscience.physics.amount.Amount;

public interface ITimeProvider {

    public Amount<Duration> getCurrentTime();

}
