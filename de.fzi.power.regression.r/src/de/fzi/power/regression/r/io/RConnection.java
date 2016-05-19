package de.fzi.power.regression.r.io;


import java.util.Vector;

import org.rosuda.JRI.REXP;

/**
 * Encapsulate the access to the R engine. Is responsible for the initialization of the R engine and
 * the execution of R commands.
 * 
 * @author groenda
 * @author strittmatter
 */
public interface RConnection {

    /**
     * Executes the command(s) in R.
     * 
     * @param rCommands
     *            One or more valid commands in R, separated by <code>\n</code>.
     * @return result Result returned from R. Empty if no result was returned.
     */
    public abstract Vector<REXP> execute(String rCommands);

    /**
     * Stores an array in a R variable.
     * 
     * @param name
     *            Name of the R variable in which the array is stored.
     * @param array
     *            Array to store in an R variable.
     */
    public abstract void assign(String name, double[] array);

    /**
     * @return the last message on the console of the connected R engine.
     */
    public abstract String getLastConsoleMessage();
}