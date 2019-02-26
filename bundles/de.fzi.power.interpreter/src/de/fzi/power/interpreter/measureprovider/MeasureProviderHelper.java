package de.fzi.power.interpreter.measureprovider;

import java.util.List;

import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;

public final class MeasureProviderHelper {

    private static final String EXTENSION_POINT_ID = "de.fzi.power.interpreter.measureprovider.extendedmeasureprovider";
    private static final String ATTRIBUTE_NAME = "provider";

    public static ExtendedMeasureProvider[] getMeasureProviderExtensions() {
        List<ExtendedMeasureProvider> providers = ExtensionHelper.getExecutableExtensions(EXTENSION_POINT_ID,
                ATTRIBUTE_NAME);
        return providers.toArray(new ExtendedMeasureProvider[providers.size()]);
    }

}
