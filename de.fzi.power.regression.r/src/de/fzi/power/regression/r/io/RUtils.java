package de.fzi.power.regression.r.io;

public final class RUtils {
	
	public static void ensurePackageAvailability(Iterable<String> packages, RRegressionConnection rCon) {
		for (String pckg : packages)
			rCon.checkPackageAvailability(pckg);
	}
	
	public static void saveDataFrameToCSV(String dataFrameName, String fileName) {
	    RRegressionConnectionImpl.getRRegressionConnection()
			.execute("write.table(" + dataFrameName + ", \"" + fileName + "\", sep=\",\")");
	}
	
	public static String sanitizeNameForR(String name) {
		return name.replace(' ', '_');
	}
}
