/**
 */
package de.fzi.power.binding.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.binding.util.BindingSwitch;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.SpecificationPackage;
import de.fzi.power.util.provider.PowerEditPlugin;
import de.uka.ipd.sdq.identifier.provider.IdentifierItemProvider;

/**
 * This is the item provider adapter for a {@link de.fzi.power.binding.AbstractFixedFactorValue} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class AbstractFixedFactorValueItemProvider extends IdentifierItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    public AbstractFixedFactorValueItemProvider(AdapterFactory adapterFactory) {
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

            addBoundFactorPropertyDescriptor(object);
            addValuePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Bound Factor feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected void addBoundFactorPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_AbstractFixedFactorValue_boundFactor_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractFixedFactorValue_boundFactor_feature",
                        "_UI_AbstractFixedFactorValue_type"),
                BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__BOUND_FACTOR, true, false, true, null, null,
                null));
    }

    /**
     * This adds a property descriptor for the Value feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected void addValuePropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                        getResourceLocator(), getString("_UI_AbstractFixedFactorValue_value_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_AbstractFixedFactorValue_value_feature",
                                "_UI_AbstractFixedFactorValue_type"),
                        BindingPackage.Literals.ABSTRACT_FIXED_FACTOR_VALUE__VALUE, true, false, false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((AbstractFixedFactorValue<?>) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_AbstractFixedFactorValue_type")
                : getString("_UI_AbstractFixedFactorValue_type") + " " + label;
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

        switch (notification.getFeatureID(AbstractFixedFactorValue.class)) {
        case BindingPackage.ABSTRACT_FIXED_FACTOR_VALUE__VALUE:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
        }
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

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return PowerEditPlugin.INSTANCE;
    }

    /**
     * @generated NOT
     */
    @Override
    protected ItemPropertyDescriptor createItemPropertyDescriptor(final AdapterFactory adapterFactory,
            final ResourceLocator resourceLocator, final String displayName, final String description,
            final org.eclipse.emf.ecore.EStructuralFeature feature, final boolean isSettable, final boolean multiLine,
            final boolean sortChoices, final Object staticImage, final String category, final String[] filterFlags) {
        return new ItemPropertyDescriptor(adapterFactory, resourceLocator, displayName, description, feature,
                isSettable, multiLine, sortChoices, staticImage, category, filterFlags) {
            @Override
            public Collection<?> getChoiceOfValues(final Object object) {
                final Collection<?> choiceOfValues = super.getChoiceOfValues(object);
                if (choiceOfValues != null && object instanceof AbstractFixedFactorValue<?>) {
                    final Collection<FixedFactor> limitedSelection = new ArrayList<FixedFactor>();
                    final AbstractFixedFactorValue<?> curFactorValue = (AbstractFixedFactorValue<?>) object;
                    if (curFactorValue.getPowerBinding() instanceof ResourcePowerBinding) {
                        new BindingSwitch<Void>() {
                            @Override
                            public Void caseResourcePowerBinding(final ResourcePowerBinding binding) {
                                for (final FixedFactor curFactor : EcoreUtil.<FixedFactor> getObjectsByType(
                                        binding.getResourcePowerModelSpecification().getConsumptionFactors(),
                                        SpecificationPackage.eINSTANCE.getFixedFactor())) {
                                    if (choiceOfValues.contains(curFactor)) {
                                        limitedSelection.add(curFactor);
                                    }
                                }
                                return null;
                            };
                        }.doSwitch(curFactorValue.getPowerBinding());
                        return limitedSelection;
                    }
                }
                return choiceOfValues;
            }
        };
    };

}
