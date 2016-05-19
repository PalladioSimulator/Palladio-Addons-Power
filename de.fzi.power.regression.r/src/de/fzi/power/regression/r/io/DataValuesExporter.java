package de.fzi.power.regression.r.io;

public interface DataValuesExporter {
	
	void exportDoubleValues(String identifier, double[] toExport);
	
	void exportIntegerValues(String identifier, int[] toExport);
	
	void exportStringValues(String identifier, String[] toExport);

}
