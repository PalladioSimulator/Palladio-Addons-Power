/**
 */
package de.fzi.power.util.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import de.fzi.power.util.UtilPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 *
 * @generated
 */
public class UtilXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public UtilXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        UtilPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the UtilResourceFactoryImpl factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (this.registrations == null)
        {
            super.getRegistrations();
            this.registrations.put(XML_EXTENSION, new UtilResourceFactoryImpl());
            this.registrations.put(STAR_EXTENSION, new UtilResourceFactoryImpl());
        }
        return this.registrations;
    }

} // UtilXMLProcessor
