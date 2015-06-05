/**
 */
package de.fzi.power.util.impl;

import javax.measure.quantity.Power;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;
import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.impl.BindingPackageImpl;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.impl.InfrastructurePackageImpl;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.specification.impl.SpecificationPackageImpl;
import de.fzi.power.util.Entity;
import de.fzi.power.util.NamedElement;
import de.fzi.power.util.UtilFactory;
import de.fzi.power.util.UtilPackage;
import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.PcmPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class UtilPackageImpl extends EPackageImpl implements UtilPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass entityEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass namedElementEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EDataType powerEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
     * value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init
     * init()}, which also performs initialization of the package, or returns the registered
     * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.fzi.power.util.UtilPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private UtilPackageImpl() {
        super(eNS_URI, UtilFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
     * upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link UtilPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to
     * obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static UtilPackage init() {
        if (isInited) {
            return (UtilPackage) EPackage.Registry.INSTANCE.getEPackage(UtilPackage.eNS_URI);
        }

        // Obtain or create and register package
        final UtilPackageImpl theUtilPackage = (UtilPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UtilPackageImpl ? EPackage.Registry.INSTANCE
                .get(eNS_URI)
                : new UtilPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ExperimentDataPackage.eINSTANCE.eClass();
        RepositoryPackage.eINSTANCE.eClass();
        MeasuringpointPackage.eINSTANCE.eClass();
        PcmPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        final SpecificationPackageImpl theSpecificationPackage = (SpecificationPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(SpecificationPackage.eNS_URI) instanceof SpecificationPackageImpl ? EPackage.Registry.INSTANCE
                        .getEPackage(SpecificationPackage.eNS_URI)
                : SpecificationPackage.eINSTANCE);
        final BindingPackageImpl theBindingPackage = (BindingPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(BindingPackage.eNS_URI) instanceof BindingPackageImpl ? EPackage.Registry.INSTANCE
                        .getEPackage(BindingPackage.eNS_URI) : BindingPackage.eINSTANCE);
        final InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(InfrastructurePackage.eNS_URI) instanceof InfrastructurePackageImpl ? EPackage.Registry.INSTANCE
                        .getEPackage(InfrastructurePackage.eNS_URI)
                : InfrastructurePackage.eINSTANCE);

        // Create package meta-data objects
        theUtilPackage.createPackageContents();
        theSpecificationPackage.createPackageContents();
        theBindingPackage.createPackageContents();
        theInfrastructurePackage.createPackageContents();

        // Initialize created meta-data
        theUtilPackage.initializePackageContents();
        theSpecificationPackage.initializePackageContents();
        theBindingPackage.initializePackageContents();
        theInfrastructurePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theUtilPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(UtilPackage.eNS_URI, theUtilPackage);
        return theUtilPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEntity() {
        return this.entityEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getNamedElement() {
        return this.namedElementEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getNamedElement_Name() {
        return (EAttribute) this.namedElementEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EDataType getPower() {
        return this.powerEDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public UtilFactory getUtilFactory() {
        return (UtilFactory) this.getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on
     * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (this.isCreated) {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.entityEClass = this.createEClass(ENTITY);

        this.namedElementEClass = this.createEClass(NAMED_ELEMENT);
        this.createEAttribute(this.namedElementEClass, NAMED_ELEMENT__NAME);

        // Create data types
        this.powerEDataType = this.createEDataType(POWER);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have
     * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Obtain other dependent packages
        final IdentifierPackage theIdentifierPackage = (IdentifierPackage) EPackage.Registry.INSTANCE
                .getEPackage(IdentifierPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.entityEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        this.entityEClass.getESuperTypes().add(this.getNamedElement());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.entityEClass, Entity.class, "Entity", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getNamedElement_Name(), this.ecorePackage.getEString(), "name", null, 0, 1,
                NamedElement.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize data types
        this.initEDataType(this.powerEDataType, Power.class, "Power", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        this.createResource(eNS_URI);
    }

} // UtilPackageImpl
