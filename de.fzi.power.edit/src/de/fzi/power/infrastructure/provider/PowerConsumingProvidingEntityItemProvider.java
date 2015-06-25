/**
 */
package de.fzi.power.infrastructure.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.fzi.power.infrastructure.InfrastructureFactory;
import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.PowerConsumingProvidingEntity;

/**
 * This is the item provider adapter for a
 * {@link de.fzi.power.infrastructure.PowerConsumingProvidingEntity} object. <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PowerConsumingProvidingEntityItemProvider extends PowerConsumingEntityItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public PowerConsumingProvidingEntityItemProvider(final AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(final Object object) {
        if (this.itemPropertyDescriptors == null)
        {
            super.getPropertyDescriptors(object);

            this.addSuppliablePeakPowerPropertyDescriptor(object);
            this.addDistributionPowerAssemblyContextPropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Suppliable Peak Power feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addSuppliablePeakPowerPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors
                .add
                (this.createItemPropertyDescriptor
                (((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                        this.getResourceLocator(),
                        this.getString("_UI_PowerProvidingEntity_suppliablePeakPower_feature"),
                        this.getString("_UI_PropertyDescriptor_description",
                                "_UI_PowerProvidingEntity_suppliablePeakPower_feature",
                                "_UI_PowerProvidingEntity_type"),
                                InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER,
                                true,
                                false,
                                false,
                                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                                null,
                                null));
    }

    /**
     * This adds a property descriptor for the Distribution Power Assembly Context feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addDistributionPowerAssemblyContextPropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors
        .add
                (this.createItemPropertyDescriptor
                (((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(),
                        this.getResourceLocator(),
                        this.getString("_UI_PowerProvidingEntity_distributionPowerAssemblyContext_feature"),
                        this.getString("_UI_PropertyDescriptor_description",
                                "_UI_PowerProvidingEntity_distributionPowerAssemblyContext_feature",
                                "_UI_PowerProvidingEntity_type"),
                                InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__DISTRIBUTION_POWER_ASSEMBLY_CONTEXT,
                                true,
                                false,
                                true,
                                null,
                                null,
                                null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
     * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(final Object object) {
        if (this.childrenFeatures == null)
        {
            super.getChildrenFeatures(object);
            this.childrenFeatures
                    .add(InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES);
        }
        return this.childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(final Object object, final Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((PowerConsumingProvidingEntity) object).getName();
        return label == null || label.length() == 0 ?
                this.getString("_UI_PowerConsumingProvidingEntity_type") :
                this.getString("_UI_PowerConsumingProvidingEntity_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void notifyChanged(final Notification notification) {
        this.updateChildren(notification);

        switch (notification.getFeatureID(PowerConsumingProvidingEntity.class))
        {
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__SUPPLIABLE_PEAK_POWER:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        case InfrastructurePackage.POWER_CONSUMING_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
            return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that
     * can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(final Collection<Object> newChildDescriptors, final Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors.add
                (this.createChildParameter
                (InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES,
                        InfrastructureFactory.eINSTANCE.createPowerDistributionUnit()));

        newChildDescriptors.add
                (this.createChildParameter
                (InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES,
                        InfrastructureFactory.eINSTANCE.createMountedPowerDistributionUnit()));

        newChildDescriptors.add
                (this.createChildParameter
                (InfrastructurePackage.Literals.POWER_PROVIDING_ENTITY__NESTED_POWER_CONSUMING_ENTITIES,
                        InfrastructureFactory.eINSTANCE.createPowerConsumingResource()));
    }

}
