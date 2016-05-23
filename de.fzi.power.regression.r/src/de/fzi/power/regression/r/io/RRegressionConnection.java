package de.fzi.power.regression.r.io;

public interface RRegressionConnection extends IRConnection {
	
    /**
     * Stores an array in a R variable.
     * 
     * @param name
     *            Name of the R variable in which the array is stored.
     * @param array
     *            Array to store in an R variable.
     */
    abstract void assign(String name, int[] array);
    
    /**
     * Stores an array in a R variable.
     * 
     * @param name
     *            Name of the R variable in which the array is stored.
     * @param array
     *            Array to store in an R variable.
     */
    abstract void assign(String name, String[] array);

    /**
     * Checks the availability of the package with the given name in R. If it is not available an
     * error message is logged and displayed.
     * 
     * @param packageName
     *            The name of the R package.
     */
    void checkPackageAvailability(final String packageName);
}
