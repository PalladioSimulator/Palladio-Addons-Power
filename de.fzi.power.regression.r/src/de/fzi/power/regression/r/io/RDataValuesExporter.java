package de.fzi.power.regression.r.io;

public class RDataValuesExporter implements DataValuesExporter {

	private RRegressionConnection rConnection;

	public RDataValuesExporter(RRegressionConnection rConnection) {
		this.rConnection = rConnection;
	}

	@Override
	public void exportDoubleValues(String identifier, double[] toExport) {
		rConnection.assign(RUtils.sanitizeNameForR(identifier), toExport);
	}

	@Override
	public void exportIntegerValues(String identifier, int[] toExport) {
		rConnection.assign(RUtils.sanitizeNameForR(identifier), toExport);
	}

	@Override
	public void exportStringValues(String identifier, String[] toExport) {
		rConnection.assign(RUtils.sanitizeNameForR(identifier), toExport);
	}

}
