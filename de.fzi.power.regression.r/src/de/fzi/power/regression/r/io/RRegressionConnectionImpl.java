package de.fzi.power.regression.r.io;

import java.util.Vector;

import org.apache.log4j.Logger;
import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class RRegressionConnectionImpl implements RRegressionConnection {
    /** The logger used by this class. */
    private static final Logger LOGGER = Logger.getLogger(RRegressionConnectionImpl.class.getName());

    /** The text console of the connected R engine. */
    private static RTextConsole rConsole = new RTextConsole();

    /** The R engine that is used by this class. */
    private static Rengine rengine = null;
    /** Global connection to the R engine. */
    private static RRegressionConnectionImpl rConnection = null;
    
    public static RRegressionConnection getRRegressionConnection() {
    	if (rConnection == null) {
    	    rConnection = new RRegressionConnectionImpl();
            rConnection.initalizeConnection();
            rConnection.execute("options(warn=-1)");
    	}
        return rConnection;
    }
	

	@Override
	public void assign(String name, int[] array) {
		rengine.assign(name, array);
	}

	@Override
	public void assign(String name, String[] array) {
		rengine.assign(name, array);
		
	}
	
    /**
     * Checks the availability of the package with the given name in R. If it is not available an
     * error message is logged and displayed.
     * 
     * @param packageName
     *            The name of the R package.
     */
	@Override
    public void checkPackageAvailability(final String packageName) {
        String previousMessage = getLastConsoleMessage();
        rengine.eval("options(warn=-1)");
        rengine.eval("library(" + packageName + ")");
        String result = getLastConsoleMessage();
        if (!previousMessage.equals(result) && !result.startsWith("In Sys.setlocale")) {
            throw new IllegalArgumentException("Library \"" + packageName + "\" is not available. Please "
                    + "install the \"" + packageName + "\" package in your R " + "installation.\n Error details: "
                    + result + "\n" + "Possible Solution: \n"
                    + "If you are using Windows Vista check if the package is "
                    + "in the installation path of R and not in the user path."
                    + "This can be achieved by executing the R command " + "\"library\".");
        }
    }
	
    /**
     * Initializes the connection to a R engine.
     */
    protected void initalizeConnection() {

        checkPathValidity();

        // initialize connection

        // Disable complete shut dpwn, if an exception within R is detected.
        // Properties prop=new Properties();
        // prop.put("jri.ignore.ule", "yes");
        // System.setProperties(prop);
        System.setProperty("jri.ignore.ule", "yes");

        // just making sure we have the right version of everything
        try {
            if (!Rengine.versionCheck()) {
                long javaVersion = Rengine.getVersion();
                long rniVersion = Rengine.rniGetVersion();
                LOGGER.error("Creating R engine ** Version mismatch - Java files (version "
                        + javaVersion + ") do not " + "match library version (version " + rniVersion + ").");
                // return; // keep on trying to get a more detailed error message
            }
        } catch (UnsatisfiedLinkError ule) {
            LOGGER.error(
                    "Could not load the dynamic link libaries that are " + "necessary to connect the sensorframework "
                            + " to R 2.12. The JRI provided with this package is "
                            + "designed for R 2.12.0, check the detailed "
                            + "error message if a version conflict may have occured."
                            + "Ensure jri.dll is within the java.library.path "
                            + "variable and R's bin directory is on the system " + "path. Details: java.library.path="
                            + System.getProperty("java.library.path") + ";errorMessage=" + ule.getMessage());
            return;
        }

        // 1) we pass the arguments from the command line
        // 2) we won't use the main loop at first, we'll start it later
        // (that's the "false" as second argument)
        // 3) the callbacks are implemented by the TextConsole class
        // above
        rengine = new Rengine(new String[] {
                "--vanilla", "--slave"
        }, false, rConsole);

        // the engine creates R is a new thread, so we should wait until
        // it's ready

        if (!rengine.waitForR()) {
            LOGGER.error(
                            "Creating R engine ** Waiting for the R engine to come up "
                                    + "failed. Please check the R-output on the console for more details, as they are written to System.out and System.err");
            rengine = null;
            return;
        }

        LOGGER.info("Connection to R established " + "successfully.");
        prepareEnvironment();
        checkPackageAvailability();
    }
    
    /**
     * Checks the availability of all necessary packages. If some are not available an error message
     * is logged.
     */
    private void checkPackageAvailability() {
        checkPackageAvailability("plotrix");
    }
    
    /**
     * Checks if the java.library.path is valid for system.loadLibrary().
     */
    private void checkPathValidity() {
        String libraryPath = System.getProperty("java.library.path");
        String[] libraryPaths = libraryPath.split(";");
        Vector<String> conflictingPaths = new Vector<String>();
        for (String path : libraryPaths) {
            if (path.contains(" ") && !path.startsWith("\"") && !path.endsWith("\"")) {
                conflictingPaths.add(path);
            }
        }
        if (!conflictingPaths.isEmpty()) {
            String formattedPath = "";
            for (String conflictPath : conflictingPaths) {
                formattedPath += "'" + conflictPath + "', ";
            }
            // cut last ", "
            formattedPath = formattedPath.substring(0, formattedPath.length() - 2);
            LOGGER.warn("The environment variable java.library.path contains "
                    + " unescaped spaces. This may lead to errors loading "
                    + "the necessary dynamic link libraries of R.\n\n"
                    + "Conflicting parts of the java.library.path are: " + formattedPath + "\n\n"
                    + "A possible solution is to set the library path to"
                    + " point to the path containing jri.dll via the -D"
                    + " command line switch of the java VM of by setting"
                    + " it via the eclipse.ini file. However, this does" + " not work in all cases.");
        }
    }
    
    /**
     * This method is used to prepare the R environment. Additionally, Information about the R
     * environment is gathered and logged with level debug.
     */
    private void prepareEnvironment() {
        rengine.eval("Sys.setlocale(\"LC_ALL\", \"German_Germany.1252\")");
        rengine.eval("Sys.setlocale(\"LC_NUMERIC\", \"C\")");
        rengine.eval("rUser <- chartr(\"\\\\\", \"/\", " + "Sys.getenv(\"R_USER\"))");
        rengine.eval("rLibs <- chartr(\"\\\\\", \"/\", " + "Sys.getenv(\"R_LIBS_USER\"))");
        rengine.eval("homedrive <- chartr(\"\\\\\", \"/\", " + "Sys.getenv(\"HOMEDRIVE\"))");
        rengine.eval("homepath <- chartr(\"\\\\\", \"/\", " + "Sys.getenv(\"HOMEPATH\"))");
        rengine.eval("usrLibPath <- substring(strsplit(rLibs, " + "rUser)[[1]][2],2)");
        rengine.eval("Sys.setenv(\"R_USER\"=paste(homedrive, homepath, " + "sep=\"\"))");
        rengine.eval("Sys.setenv(\"R_LIBS_USER\"=paste(Sys.getenv(\"R_USER\"), " + "usrLibPath, sep=\"\")[[1]])");

        REXP envContent = rengine.eval("Sys.getenv()");
        REXP envNames = rengine.eval("names(s <- Sys.getenv())");
        String[] sEnvContent = envContent.asStringArray();
        String[] sEnvNames = envNames.asStringArray();
        String locale = "";
        for (int number = 0; number < sEnvContent.length; number++) {
            locale += sEnvNames[number] + " = " + sEnvContent[number] + "\n";
        }
        REXP locales = rengine.eval("Sys.getlocale()");
        String[] sLocales = locales.asStringArray();
        locale += "\nLocalization information:\n";
        for (int number = 0; number < sLocales.length; number++) {
            locale += sLocales[number] + "\n";
        }

        LOGGER.debug("Environmental Information:\n" + locale);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.IRConnection#execute(java
     * .lang.String)
     */
    @Override
    public Vector<REXP> execute(final String rCommands) {
        if (!isEngineAvailable()) {
            throw new UnsupportedOperationException("Tried to execute command in R without having a R engine"
                    + " available.");
        }

        String[] commands = rCommands.split("\n");
        String result = "";
        REXP resultExp;
        Vector<REXP> resultExpArray = new Vector<REXP>();

        for (String command : commands) {
            resultExp = rengine.eval(command);
            if (resultExp != null) {
                result += resultExp.toString() + "\n";
                resultExpArray.add(resultExp);
            }
        }

        return resultExpArray;
    }
    
    /**
     * checks if an R engine could be found and the connection is established.
     * 
     * @return <code>true</code> if the connection is established.
     */
    public static boolean isEngineAvailable() {
        return !(rengine == null);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.IRConnection#
     * getLastConsoleMessage()
     */
    @Override
    public String getLastConsoleMessage() {
        return rConsole.getLastMessage();

    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.IRConnection#assign(java
     * .lang.String, double[])
     */
    @Override
    public void assign(final String name, final double[] array) {
        rengine.assign(name, array);
    }
}
