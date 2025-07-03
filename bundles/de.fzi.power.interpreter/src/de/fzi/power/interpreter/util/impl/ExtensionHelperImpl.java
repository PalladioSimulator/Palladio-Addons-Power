/** */
package de.fzi.power.interpreter.util.impl;

import java.util.List;

import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;

import de.fzi.power.interpreter.util.IExtensionHelper;

public class ExtensionHelperImpl implements IExtensionHelper {

    @Override
    public List<String> getAttributes(String extensionPointID, String elementName, String attributeName) {
        return ExtensionHelper.getAttributes(extensionPointID, elementName, attributeName);
    }

    @Override
    public <DATA_TYPE> List<DATA_TYPE> getExecutableExtensions(String extensionPointID, String attributeName) {
        return ExtensionHelper.getExecutableExtensions(extensionPointID, attributeName);
    }

    @Override
    public <DATA_TYPE> DATA_TYPE getExecutableExtension(String extensionPointID, String attributeName,
            String filterAttributeName, String filterAttributeValue) {
        return ExtensionHelper.getExecutableExtension(extensionPointID, attributeName, filterAttributeName,
                filterAttributeValue);
    }

    @Override
    public <DATA_TYPE> List<DATA_TYPE> getExecutableExtensions(String extensionPointID, String elementName,
            String attributeName) {
        return ExtensionHelper.getExecutableExtensions(extensionPointID, elementName, attributeName);
    }

    @Override
    public <DATA_TYPE> List<DATA_TYPE> getExecutableExtensions(String extensionPointID, String elementName,
            String attributeName, String filterAttributeName, String filterAttributeValue,
            Class<DATA_TYPE> extensionType) {
        return ExtensionHelper.getExecutableExtensions(extensionPointID, elementName, attributeName,
                filterAttributeName, filterAttributeValue, extensionType);
    }

    @Override
    public <DATA_TYPE> DATA_TYPE getExecutableExtension(String extensionPointID, String elementName,
            String attributeName, String filterAttributeName, String filterAttributeValue,
            Class<DATA_TYPE> extensionType) {
        return ExtensionHelper.getExecutableExtension(extensionPointID, elementName, attributeName, filterAttributeName,
                filterAttributeValue, extensionType);
    }
}
