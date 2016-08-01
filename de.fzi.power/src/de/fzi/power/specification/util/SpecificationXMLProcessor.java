/**
 */
package de.fzi.power.specification.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import de.fzi.power.specification.SpecificationPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 *
 * @generated
 */
public class SpecificationXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SpecificationXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        SpecificationPackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the SpecificationResourceFactoryImpl factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (this.registrations == null) {
            super.getRegistrations();
            this.registrations.put(XML_EXTENSION, new SpecificationResourceFactoryImpl());
            this.registrations.put(STAR_EXTENSION, new SpecificationResourceFactoryImpl());
        }
        return this.registrations;
    }

} // SpecificationXMLProcessor
