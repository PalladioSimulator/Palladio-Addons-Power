package de.fzi.power.interpreter.measureprovider;

import java.util.Vector;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;

public final class MeasureProviderHelper {

    // TODO: implement extension point and resolve providers this way
    public static ExtendedMeasureProvider[] getMeasureProviderExtensions() {
        Vector<ExtendedMeasureProvider> providers = new Vector<ExtendedMeasureProvider>();
        // TODO eventually extract into helper class
        IExtension[] extensions = Platform.getExtensionRegistry()
                .getExtensionPoint("de.fzi.power.interpreter.measureprovider.extendedmeasureprovider")
                .getExtensions();
        for (IExtension extension : extensions) {

            for (IConfigurationElement element : extension.getConfigurationElements()) {
                ExtendedMeasureProvider provider;

                try {
                    provider = (ExtendedMeasureProvider) element.createExecutableExtension("provider");

                    if (provider != null) {
                        providers.add(provider);
                    }

                } catch (CoreException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return providers.toArray(new ExtendedMeasureProvider[providers.size()]);
    }

}
