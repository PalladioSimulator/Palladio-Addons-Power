/**
 */
package de.fzi.power.profilingimport.mapping.impl;

import de.fzi.power.profilingimport.mapping.MappingPackage;
import de.fzi.power.profilingimport.mapping.MappingRepository;
import de.fzi.power.profilingimport.mapping.MarkerLog;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Marker Log</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.profilingimport.mapping.impl.MarkerLogImpl#getCsvFileUri <em>Csv File Uri</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.impl.MarkerLogImpl#getRepository <em>Repository</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MarkerLogImpl extends IdentifierImpl implements MarkerLog {
    /**
     * The default value of the '{@link #getCsvFileUri() <em>Csv File Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCsvFileUri()
     * @generated
     * @ordered
     */
    protected static final String CSV_FILE_URI_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MarkerLogImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.MARKER_LOG;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCsvFileUri() {
        return (String)eDynamicGet(MappingPackage.MARKER_LOG__CSV_FILE_URI, MappingPackage.Literals.MARKER_LOG__CSV_FILE_URI, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCsvFileUri(String newCsvFileUri) {
        eDynamicSet(MappingPackage.MARKER_LOG__CSV_FILE_URI, MappingPackage.Literals.MARKER_LOG__CSV_FILE_URI, newCsvFileUri);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MappingRepository getRepository() {
        return (MappingRepository)eDynamicGet(MappingPackage.MARKER_LOG__REPOSITORY, MappingPackage.Literals.MARKER_LOG__REPOSITORY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRepository(MappingRepository newRepository, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newRepository, MappingPackage.MARKER_LOG__REPOSITORY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRepository(MappingRepository newRepository) {
        eDynamicSet(MappingPackage.MARKER_LOG__REPOSITORY, MappingPackage.Literals.MARKER_LOG__REPOSITORY, newRepository);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MappingPackage.MARKER_LOG__REPOSITORY:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetRepository((MappingRepository)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MappingPackage.MARKER_LOG__REPOSITORY:
                return basicSetRepository(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case MappingPackage.MARKER_LOG__REPOSITORY:
                return eInternalContainer().eInverseRemove(this, MappingPackage.MAPPING_REPOSITORY__MARKER_LOG, MappingRepository.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MappingPackage.MARKER_LOG__CSV_FILE_URI:
                return getCsvFileUri();
            case MappingPackage.MARKER_LOG__REPOSITORY:
                return getRepository();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MappingPackage.MARKER_LOG__CSV_FILE_URI:
                setCsvFileUri((String)newValue);
                return;
            case MappingPackage.MARKER_LOG__REPOSITORY:
                setRepository((MappingRepository)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case MappingPackage.MARKER_LOG__CSV_FILE_URI:
                setCsvFileUri(CSV_FILE_URI_EDEFAULT);
                return;
            case MappingPackage.MARKER_LOG__REPOSITORY:
                setRepository((MappingRepository)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case MappingPackage.MARKER_LOG__CSV_FILE_URI:
                return CSV_FILE_URI_EDEFAULT == null ? getCsvFileUri() != null : !CSV_FILE_URI_EDEFAULT.equals(getCsvFileUri());
            case MappingPackage.MARKER_LOG__REPOSITORY:
                return getRepository() != null;
        }
        return super.eIsSet(featureID);
    }

} //MarkerLogImpl
