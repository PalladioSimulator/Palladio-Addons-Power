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
import de.fzi.power.binding.DistributionPowerBinding;

/**
 * This is the item provider adapter for a {@link de.fzi.power.binding.DistributionPowerBinding} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class DistributionPowerBindingItemProvider extends
		PowerFactorBindingItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public DistributionPowerBindingItemProvider(AdapterFactory adapterFactory) {
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

			addDistributionPowerModelPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Distribution Power Model feature.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDistributionPowerModelPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_DistributionPowerBinding_distributionPowerModel_feature"),
						getString(
								"_UI_PropertyDescriptor_description",
								"_UI_DistributionPowerBinding_distributionPowerModel_feature",
								"_UI_DistributionPowerBinding_type"),
						BindingPackage.Literals.DISTRIBUTION_POWER_BINDING__DISTRIBUTION_POWER_MODEL,
						true, false, true, null, null, null));
	}

	/**
	 * This returns DistributionPowerBinding.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(
				object,
				getResourceLocator().getImage(
						"full/obj16/DistributionPowerBinding"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DistributionPowerBinding) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_DistributionPowerBinding_type")
				: getString("_UI_DistributionPowerBinding_type") + " " + label;
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
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
