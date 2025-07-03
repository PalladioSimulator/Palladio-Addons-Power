/** */
package de.fzi.power.interpreter.util;

import java.util.List;

import de.fzi.power.interpreter.util.impl.ExtensionHelperImpl;

public interface IExtensionHelper {
    IExtensionHelper INSTANCE = new ExtensionHelperImpl();

    List<String> getAttributes(String extensionPointID, String elementName, String attributeName);

    <DATA_TYPE> List<DATA_TYPE> getExecutableExtensions(String extensionPointID, String attributeName);

    <DATA_TYPE> DATA_TYPE getExecutableExtension(String extensionPointID, String attributeName,
            String filterAttributeName, String filterAttributeValue);

    <DATA_TYPE> List<DATA_TYPE> getExecutableExtensions(String extensionPointID, String elementName,
            String attributeName);

    <DATA_TYPE> List<DATA_TYPE> getExecutableExtensions(String extensionPointID, String elementName,
            String attributeName, String filterAttributeName, String filterAttributeValue,
            Class<DATA_TYPE> extensionType);

    <DATA_TYPE> DATA_TYPE getExecutableExtension(String extensionPointID, String elementName, String attributeName,
            String filterAttributeName, String filterAttributeValue, Class<DATA_TYPE> extensionType);

}
