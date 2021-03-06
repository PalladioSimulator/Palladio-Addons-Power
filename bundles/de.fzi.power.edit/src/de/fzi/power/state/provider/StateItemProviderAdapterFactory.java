/**
 */
package de.fzi.power.state.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import de.fzi.power.state.util.StateAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class StateItemProviderAdapterFactory extends StateAdapterFactory
        implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public StateItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link de.fzi.power.state.PowerStateRepository} instances.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    protected PowerStateRepositoryItemProvider powerStateRepositoryItemProvider;

    /**
     * This creates an adapter for a {@link de.fzi.power.state.PowerStateRepository}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createPowerStateRepositoryAdapter() {
        if (powerStateRepositoryItemProvider == null) {
            powerStateRepositoryItemProvider = new PowerStateRepositoryItemProvider(this);
        }

        return powerStateRepositoryItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.fzi.power.state.TransitionState} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected TransitionStateItemProvider transitionStateItemProvider;

    /**
     * This creates an adapter for a {@link de.fzi.power.state.TransitionState}.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTransitionStateAdapter() {
        if (transitionStateItemProvider == null) {
            transitionStateItemProvider = new TransitionStateItemProvider(this);
        }

        return transitionStateItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.fzi.power.state.PowerState} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected PowerStateItemProvider powerStateItemProvider;

    /**
     * This creates an adapter for a {@link de.fzi.power.state.PowerState}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createPowerStateAdapter() {
        if (powerStateItemProvider == null) {
            powerStateItemProvider = new PowerStateItemProvider(this);
        }

        return powerStateItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link de.fzi.power.state.PowerStateMachine} instances.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected PowerStateMachineItemProvider powerStateMachineItemProvider;

    /**
     * This creates an adapter for a {@link de.fzi.power.state.PowerStateMachine}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createPowerStateMachineAdapter() {
        if (powerStateMachineItemProvider == null) {
            powerStateMachineItemProvider = new PowerStateMachineItemProvider(this);
        }

        return powerStateMachineItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void fireNotifyChanged(Notification notification) {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null) {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. 
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    @Override
    public void dispose() {
        if (powerStateRepositoryItemProvider != null)
            powerStateRepositoryItemProvider.dispose();
        if (transitionStateItemProvider != null)
            transitionStateItemProvider.dispose();
        if (powerStateItemProvider != null)
            powerStateItemProvider.dispose();
        if (powerStateMachineItemProvider != null)
            powerStateMachineItemProvider.dispose();
    }

}
