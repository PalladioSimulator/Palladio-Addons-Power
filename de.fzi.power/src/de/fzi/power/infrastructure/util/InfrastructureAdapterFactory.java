/**
 */
package de.fzi.power.infrastructure.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.MountedPowerDistributionUnit;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerConsumingProvidingEntity;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerDistributionUnit;
import de.fzi.power.infrastructure.PowerInfrastructureRepository;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.util.Entity;
import de.fzi.power.util.NamedElement;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see de.fzi.power.infrastructure.InfrastructurePackage
 * @generated
 */
public class InfrastructureAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static InfrastructurePackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public InfrastructureAdapterFactory() {
        if (modelPackage == null)
        {
            modelPackage = InfrastructurePackage.eINSTANCE;
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
        if (object == modelPackage)
        {
            return true;
        }
        if (object instanceof EObject)
        {
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
    protected InfrastructureSwitch<Adapter> modelSwitch = new InfrastructureSwitch<Adapter>()
            {
        @Override
        public Adapter casePowerDistributionUnit(final PowerDistributionUnit object)
        {
            return InfrastructureAdapterFactory.this.createPowerDistributionUnitAdapter();
        }

        @Override
        public Adapter casePowerConsumingProvidingEntity(final PowerConsumingProvidingEntity object)
        {
            return InfrastructureAdapterFactory.this.createPowerConsumingProvidingEntityAdapter();
        }

        @Override
        public Adapter casePowerProvidingEntity(final PowerProvidingEntity object)
        {
            return InfrastructureAdapterFactory.this.createPowerProvidingEntityAdapter();
        }

        @Override
        public Adapter casePowerConsumingEntity(final PowerConsumingEntity object)
        {
            return InfrastructureAdapterFactory.this.createPowerConsumingEntityAdapter();
        }

        @Override
        public Adapter caseMountedPowerDistributionUnit(final MountedPowerDistributionUnit object)
        {
            return InfrastructureAdapterFactory.this.createMountedPowerDistributionUnitAdapter();
        }

        @Override
        public Adapter casePowerConsumingResource(final PowerConsumingResource object)
        {
            return InfrastructureAdapterFactory.this.createPowerConsumingResourceAdapter();
        }

        @Override
        public Adapter casePowerInfrastructureRepository(final PowerInfrastructureRepository object)
        {
            return InfrastructureAdapterFactory.this.createPowerInfrastructureRepositoryAdapter();
        }

        @Override
        public Adapter caseIdentifier(final Identifier object)
        {
            return InfrastructureAdapterFactory.this.createIdentifierAdapter();
        }

        @Override
        public Adapter caseNamedElement(final NamedElement object)
        {
            return InfrastructureAdapterFactory.this.createNamedElementAdapter();
        }

        @Override
        public Adapter caseEntity(final Entity object)
        {
            return InfrastructureAdapterFactory.this.createEntityAdapter();
        }

        @Override
        public Adapter defaultCase(final EObject object)
        {
            return InfrastructureAdapterFactory.this.createEObjectAdapter();
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
             * Creates a new adapter for an object of class '
     * {@link de.fzi.power.infrastructure.PowerDistributionUnit <em>Power Distribution Unit</em>}'.
             * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
             * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
             * end-user-doc -->
             * 
     * @return the new adapter.
             * @see de.fzi.power.infrastructure.PowerDistributionUnit
             * @generated
             */
            public Adapter createPowerDistributionUnitAdapter() {
                return null;
            }

            /**
             * Creates a new adapter for an object of class '
     * {@link de.fzi.power.infrastructure.PowerConsumingProvidingEntity
     * <em>Power Consuming Providing Entity</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
             * @see de.fzi.power.infrastructure.PowerConsumingProvidingEntity
             * @generated
             */
            public Adapter createPowerConsumingProvidingEntityAdapter() {
                return null;
            }

            /**
             * Creates a new adapter for an object of class '
     * {@link de.fzi.power.infrastructure.PowerProvidingEntity <em>Power Providing Entity</em>}'.
             * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
             * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
             * end-user-doc -->
             * 
     * @return the new adapter.
             * @see de.fzi.power.infrastructure.PowerProvidingEntity
             * @generated
             */
            public Adapter createPowerProvidingEntityAdapter() {
                return null;
            }

            /**
             * Creates a new adapter for an object of class '
     * {@link de.fzi.power.infrastructure.PowerConsumingEntity <em>Power Consuming Entity</em>}'.
             * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
             * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
             * end-user-doc -->
             * 
     * @return the new adapter.
             * @see de.fzi.power.infrastructure.PowerConsumingEntity
             * @generated
             */
            public Adapter createPowerConsumingEntityAdapter() {
                return null;
            }

            /**
             * Creates a new adapter for an object of class '
     * {@link de.fzi.power.infrastructure.MountedPowerDistributionUnit
     * <em>Mounted Power Distribution Unit</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
             * @see de.fzi.power.infrastructure.MountedPowerDistributionUnit
             * @generated
             */
            public Adapter createMountedPowerDistributionUnitAdapter() {
                return null;
            }

            /**
             * Creates a new adapter for an object of class '
     * {@link de.fzi.power.infrastructure.PowerConsumingResource <em>Power Consuming Resource</em>}
     * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
             * @see de.fzi.power.infrastructure.PowerConsumingResource
             * @generated
             */
            public Adapter createPowerConsumingResourceAdapter() {
                return null;
            }

            /**
             * Creates a new adapter for an object of class '
     * {@link de.fzi.power.infrastructure.PowerInfrastructureRepository
     * <em>Power Infrastructure Repository</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
             * @see de.fzi.power.infrastructure.PowerInfrastructureRepository
             * @generated
             */
            public Adapter createPowerInfrastructureRepositoryAdapter() {
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
             * Creates a new adapter for an object of class '{@link de.fzi.power.util.NamedElement
     * <em>Named Element</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
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

} // InfrastructureAdapterFactory
