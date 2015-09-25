package de.fzi.power.interpreter.calculator.expressionoasis;

import java.net.URL;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.vedantatree.expressionoasis.config.ConfigFactory;

public class Activator implements BundleActivator {

    private static BundleContext context;

    static BundleContext getContext() {
        return context;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        URL url = context.getBundle().getEntry("config/config.xml");
        System.setProperty(ConfigFactory.CONFIG_FILE_PATH_KEY, url.toString());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
    }

}
