/**
 */
package de.fzi.power.infrastructure.provider;

import de.fzi.power.infrastructure.InfrastructurePackage;
import de.fzi.power.infrastructure.StatefulPowerConsumingResource;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * This is the item provider adapter for a {@link de.fzi.power.infrastructure.StatefulPowerConsumingResource} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StatefulPowerConsumingResourceItemProvider extends
		AbstractPowerConsumingResourceItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatefulPowerConsumingResourceItemProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addPowerStatePropertyDescriptor(object);
			addStatefulResourcePowerBindingPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Power State feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPowerStatePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_StatefulPowerConsumingResource_powerState_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_StatefulPowerConsumingResource_powerState_feature",
								"_UI_StatefulPowerConsumingResource_type"),
						InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__POWER_STATE,
						true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Stateful Resource Power Binding feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatefulResourcePowerBindingPropertyDescriptor(
			Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_StatefulPowerConsumingResource_statefulResourcePowerBinding_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_StatefulPowerConsumingResource_statefulResourcePowerBinding_feature",
								"_UI_StatefulPowerConsumingResource_type"),
						InfrastructurePackage.Literals.STATEFUL_POWER_CONSUMING_RESOURCE__STATEFUL_RESOURCE_POWER_BINDING,
						true, false, true, null, null, null));
	}

	/**
	 * This returns StatefulPowerConsumingResource.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(
				object,
				getResourceLocator().getImage(
						"full/obj16/StatefulPowerConsumingResource"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((StatefulPowerConsumingResource) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_StatefulPowerConsumingResource_type")
				: getString("_UI_StatefulPowerConsumingResource_type") + " "
						+ label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
