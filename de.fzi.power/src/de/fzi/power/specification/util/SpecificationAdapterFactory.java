/**
 */
package de.fzi.power.specification.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.fzi.power.specification.BlackBoxDistributionPowerModelSpecification;
import de.fzi.power.specification.BlackBoxPowerModelSpecification;
import de.fzi.power.specification.BlackBoxResourcePowerModelSpecification;
import de.fzi.power.specification.ConsumptionFactor;
import de.fzi.power.specification.DeclarativeDistributionPowerModelSpecification;
import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.DeclarativeResourcePowerModelSpecification;
import de.fzi.power.specification.DistributionPowerModelSpecification;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.MeasuredFactor;
import de.fzi.power.specification.PowerModelRepository;
import de.fzi.power.specification.PowerModelSpecification;
import de.fzi.power.specification.ResourcePowerModelSpecification;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.util.Entity;
import de.fzi.power.util.NamedElement;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 *
 * @see de.fzi.power.specification.SpecificationPackage
 * @generated
 */
public class SpecificationAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static SpecificationPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SpecificationAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = SpecificationPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
     * --> This implementation returns <code>true</code> if the object is either the model's package
     * or is an instance object of the model. <!-- end-user-doc -->
     *
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected SpecificationSwitch<Adapter> modelSwitch = new SpecificationSwitch<Adapter>() {
        @Override
        public Adapter casePowerModelRepository(final PowerModelRepository object) {
            return SpecificationAdapterFactory.this.createPowerModelRepositoryAdapter();
        }

        @Override
        public Adapter casePowerModelSpecification(final PowerModelSpecification object) {
            return SpecificationAdapterFactory.this.createPowerModelSpecificationAdapter();
        }

        @Override
        public Adapter caseResourcePowerModelSpecification(final ResourcePowerModelSpecification object) {
            return SpecificationAdapterFactory.this.createResourcePowerModelSpecificationAdapter();
        }

        @Override
        public Adapter caseDistributionPowerModelSpecification(final DistributionPowerModelSpecification object) {
            return SpecificationAdapterFactory.this.createDistributionPowerModelSpecificationAdapter();
        }

        @Override
        public Adapter caseFixedFactor(final FixedFactor object) {
            return SpecificationAdapterFactory.this.createFixedFactorAdapter();
        }

        @Override
        public Adapter caseConsumptionFactor(final ConsumptionFactor object) {
            return SpecificationAdapterFactory.this.createConsumptionFactorAdapter();
        }

        @Override
        public Adapter caseMeasuredFactor(final MeasuredFactor object) {
            return SpecificationAdapterFactory.this.createMeasuredFactorAdapter();
        }

        @Override
        public Adapter caseDeclarativePowerModelSpecification(final DeclarativePowerModelSpecification object) {
            return SpecificationAdapterFactory.this.createDeclarativePowerModelSpecificationAdapter();
        }

        @Override
        public Adapter caseDeclarativeResourcePowerModelSpecification(
                final DeclarativeResourcePowerModelSpecification object) {
            return SpecificationAdapterFactory.this.createDeclarativeResourcePowerModelSpecificationAdapter();
        }

        @Override
        public Adapter caseDeclarativeDistributionPowerModelSpecification(
                final DeclarativeDistributionPowerModelSpecification object) {
            return SpecificationAdapterFactory.this.createDeclarativeDistributionPowerModelSpecificationAdapter();
        }

        @Override
        public Adapter caseBlackBoxPowerModelSpecification(final BlackBoxPowerModelSpecification object) {
            return SpecificationAdapterFactory.this.createBlackBoxPowerModelSpecificationAdapter();
        }

        @Override
        public Adapter caseBlackBoxDistributionPowerModelSpecification(
                final BlackBoxDistributionPowerModelSpecification object) {
            return SpecificationAdapterFactory.this.createBlackBoxDistributionPowerModelSpecificationAdapter();
        }

        @Override
        public Adapter caseBlackBoxResourcePowerModelSpecification(
                final BlackBoxResourcePowerModelSpecification object) {
            return SpecificationAdapterFactory.this.createBlackBoxResourcePowerModelSpecificationAdapter();
        }

        @Override
        public Adapter caseIdentifier(final Identifier object) {
            return SpecificationAdapterFactory.this.createIdentifierAdapter();
        }

        @Override
        public Adapter caseNamedElement(final NamedElement object) {
            return SpecificationAdapterFactory.this.createNamedElementAdapter();
        }

        @Override
        public Adapter caseEntity(final Entity object) {
            return SpecificationAdapterFactory.this.createEntityAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object) {
            return SpecificationAdapterFactory.this.createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(final Notifier target) {
        return this.modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.fzi.power.specification.PowerModelRepository <em>Power Model Repository</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.PowerModelRepository
     * @generated
     */
    public Adapter createPowerModelRepositoryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.fzi.power.specification.PowerModelSpecification <em>Power Model
     * Specification</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.PowerModelSpecification
     * @generated
     */
    public Adapter createPowerModelSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.fzi.power.specification.ResourcePowerModelSpecification <em>Resource Power Model
     * Specification</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.ResourcePowerModelSpecification
     * @generated
     */
    public Adapter createResourcePowerModelSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.fzi.power.specification.DistributionPowerModelSpecification <em>Distribution Power
     * Model Specification</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.DistributionPowerModelSpecification
     * @generated
     */
    public Adapter createDistributionPowerModelSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.specification.FixedFactor
     * <em>Fixed Factor</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.FixedFactor
     * @generated
     */
    public Adapter createFixedFactorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.power.specification.ConsumptionFactor <em>Consumption Factor</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.ConsumptionFactor
     * @generated
     */
    public Adapter createConsumptionFactorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.fzi.power.specification.MeasuredFactor <em>Measured Factor</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.MeasuredFactor
     * @generated
     */
    public Adapter createMeasuredFactorAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.fzi.power.specification.DeclarativePowerModelSpecification <em>Declarative Power
     * Model Specification</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.DeclarativePowerModelSpecification
     * @generated
     */
    public Adapter createDeclarativePowerModelSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.fzi.power.specification.DeclarativeResourcePowerModelSpecification <em>Declarative
     * Resource Power Model Specification</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.DeclarativeResourcePowerModelSpecification
     * @generated
     */
    public Adapter createDeclarativeResourcePowerModelSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.fzi.power.specification.DeclarativeDistributionPowerModelSpecification
     * <em>Declarative Distribution Power Model Specification</em>}'. <!-- begin-user-doc --> This
     * default implementation returns null so that we can easily ignore cases; it's useful to ignore
     * a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.DeclarativeDistributionPowerModelSpecification
     * @generated
     */
    public Adapter createDeclarativeDistributionPowerModelSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.fzi.power.specification.BlackBoxPowerModelSpecification <em>Black Box Power Model
     * Specification</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.BlackBoxPowerModelSpecification
     * @generated
     */
    public Adapter createBlackBoxPowerModelSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.fzi.power.specification.BlackBoxDistributionPowerModelSpecification <em>Black Box
     * Distribution Power Model Specification</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.BlackBoxDistributionPowerModelSpecification
     * @generated
     */
    public Adapter createBlackBoxDistributionPowerModelSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class
     * '{@link de.fzi.power.specification.BlackBoxResourcePowerModelSpecification <em>Black Box
     * Resource Power Model Specification</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.specification.BlackBoxResourcePowerModelSpecification
     * @generated
     */
    public Adapter createBlackBoxResourcePowerModelSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier
     * <em>Identifier</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.uka.ipd.sdq.identifier.Identifier
     * @generated
     */
    public Adapter createIdentifierAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.util.NamedElement <em>Named
     * Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we
     * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.util.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.fzi.power.util.Entity
     * <em>Entity</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @see de.fzi.power.util.Entity
     * @generated
     */
    public Adapter createEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     *
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // SpecificationAdapterFactory
