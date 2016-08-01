/**
 */
package de.fzi.power.binding.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import de.fzi.power.binding.BindingPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 *
 * @generated
 */
public class BindingXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public BindingXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        BindingPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the BindingResourceFactoryImpl factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (this.registrations == null) {
            super.getRegistrations();
            this.registrations.put(XML_EXTENSION, new BindingResourceFactoryImpl());
            this.registrations.put(STAR_EXTENSION, new BindingResourceFactoryImpl());
        }
        return this.registrations;
    }

} // BindingXMLProcessor
