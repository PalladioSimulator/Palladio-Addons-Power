package org.palladiosimulator.profiling.evaluation;

public class EvaluationResult {

    // TODO convert to Wh/Joule when returned
    private double totalMeasuredEnergyConsumption;
    private double totalPredictedEnergyConsumption;
    private String name;
    private double totalError;
    private int counter;
    
    // Hours to seconds.
    private static double CONVERSION_FACTOR = 60*60;

    public EvaluationResult(String name, double totalMeasuredEnergyConsumption, double totalPredictedEnergyConsumption, double totalError) {
        this.name = name;
        this.totalMeasuredEnergyConsumption = totalMeasuredEnergyConsumption;
        this.totalPredictedEnergyConsumption = totalPredictedEnergyConsumption;
        this.totalError = totalError;
        this.counter = 0;
    }

    public double getPredictionError() {
        return Math.abs((totalMeasuredEnergyConsumption - totalPredictedEnergyConsumption)/totalMeasuredEnergyConsumption);
    }

    public double getAbsoluteMeasured() {
        return totalMeasuredEnergyConsumption/CONVERSION_FACTOR;
    }
    
    public double getAbsolutePredicted() {
        return totalPredictedEnergyConsumption/CONVERSION_FACTOR;
    }
    
    public double getTotalError() {
        return this.totalError / counter;
    }

    public void add(EvaluationResult result) {
        this.totalMeasuredEnergyConsumption += result.totalMeasuredEnergyConsumption;
        this.totalPredictedEnergyConsumption += result.totalPredictedEnergyConsumption;
        this.totalError += result.totalError;
        counter++;
    }

    public String getName() {
        return this.name;
    }
}
