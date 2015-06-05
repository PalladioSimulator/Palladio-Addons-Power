/**
 */
package de.fzi.power.infrastructure.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import de.fzi.power.infrastructure.InfrastructurePackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class InfrastructureXMLProcessor extends XMLProcessor {

    /**
     * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InfrastructureXMLProcessor() {
        super((EPackage.Registry.INSTANCE));
        InfrastructurePackage.eINSTANCE.eClass();
    }

    /**
     * Register for "*" and "xml" file extensions the InfrastructureResourceFactoryImpl factory.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations() {
        if (this.registrations == null)
        {
            super.getRegistrations();
            this.registrations.put(XML_EXTENSION, new InfrastructureResourceFactoryImpl());
            this.registrations.put(STAR_EXTENSION, new InfrastructureResourceFactoryImpl());
        }
        return this.registrations;
    }

} // InfrastructureXMLProcessor
