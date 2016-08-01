/**
 */
package de.fzi.power.specification.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.binding.util.BindingSwitch;
import de.fzi.power.specification.FixedFactor;
import de.fzi.power.specification.SpecificationPackage;

/**
 * This is the item provider adapter for a {@link de.fzi.power.specification.FixedFactor} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class FixedFactorItemProvider extends ConsumptionFactorItemProvider {
    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public FixedFactorItemProvider(final AdapterFactory adapterFactory) {
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
        if (this.itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This returns FixedFactor.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/FixedFactor"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((FixedFactor) object).getName();
        return label == null || label.length() == 0 ? this.getString("_UI_FixedFactor_type")
                : this.getString("_UI_FixedFactor_type") + " " + label;
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
