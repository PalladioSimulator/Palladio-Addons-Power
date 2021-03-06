/**
 */
package de.fzi.power.binding.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.PowerStateBinding;

/**
 * This is the item provider adapter for a {@link de.fzi.power.binding.PowerStateBinding} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class PowerStateBindingItemProvider extends AbstractPowerStateBindingItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public PowerStateBindingItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addPowerStatePropertyDescriptor(object);
            addBindingPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Power State feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected void addPowerStatePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_PowerStateBinding_powerState_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_PowerStateBinding_powerState_feature",
                                "_UI_PowerStateBinding_type"),
                        BindingPackage.Literals.POWER_STATE_BINDING__POWER_STATE, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Binding feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected void addBindingPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_PowerStateBinding_binding_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_PowerStateBinding_binding_feature",
                                "_UI_PowerStateBinding_type"),
                        BindingPackage.Literals.POWER_STATE_BINDING__BINDING, true, false, true, null, null, null));
    }

    /**
     * This returns PowerStateBinding.gif.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/PowerStateBinding"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((PowerStateBinding) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_PowerStateBinding_type")
                : getString("_UI_PowerStateBinding_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}
