/**
 */
package de.fzi.power.profilingimport.mapping.impl;

import de.fzi.power.profilingimport.mapping.MappingPackage;
import de.fzi.power.profilingimport.mapping.MappingRepository;
import de.fzi.power.profilingimport.mapping.MarkerLog;
import de.fzi.power.profilingimport.mapping.MetricToCsvMapping;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.profilingimport.mapping.impl.MappingRepositoryImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.impl.MappingRepositoryImpl#getMarkerLog <em>Marker Log</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingRepositoryImpl extends IdentifierImpl implements MappingRepository {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MappingRepositoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.MAPPING_REPOSITORY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    public EList<MetricToCsvMapping> getMappings() {
        return (EList<MetricToCsvMapping>)eDynamicGet(MappingPackage.MAPPING_REPOSITORY__MAPPINGS, MappingPackage.Literals.MAPPING_REPOSITORY__MAPPINGS, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MarkerLog getMarkerLog() {
        return (MarkerLog)eDynamicGet(MappingPackage.MAPPING_REPOSITORY__MARKER_LOG, MappingPackage.Literals.MAPPING_REPOSITORY__MARKER_LOG, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMarkerLog(MarkerLog newMarkerLog, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject)newMarkerLog, MappingPackage.MAPPING_REPOSITORY__MARKER_LOG, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMarkerLog(MarkerLog newMarkerLog) {
        eDynamicSet(MappingPackage.MAPPING_REPOSITORY__MARKER_LOG, MappingPackage.Literals.MAPPING_REPOSITORY__MARKER_LOG, newMarkerLog);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MappingPackage.MAPPING_REPOSITORY__MAPPINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappings()).basicAdd(otherEnd, msgs);
            case MappingPackage.MAPPING_REPOSITORY__MARKER_LOG:
                MarkerLog markerLog = getMarkerLog();
                if (markerLog != null)
                    msgs = ((InternalEObject)markerLog).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MAPPING_REPOSITORY__MARKER_LOG, null, msgs);
                return basicSetMarkerLog((MarkerLog)otherEnd, msgs);
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
            case MappingPackage.MAPPING_REPOSITORY__MAPPINGS:
                return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
            case MappingPackage.MAPPING_REPOSITORY__MARKER_LOG:
                return basicSetMarkerLog(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MappingPackage.MAPPING_REPOSITORY__MAPPINGS:
                return getMappings();
            case MappingPackage.MAPPING_REPOSITORY__MARKER_LOG:
                return getMarkerLog();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MappingPackage.MAPPING_REPOSITORY__MAPPINGS:
                getMappings().clear();
                getMappings().addAll((Collection<? extends MetricToCsvMapping>)newValue);
                return;
            case MappingPackage.MAPPING_REPOSITORY__MARKER_LOG:
                setMarkerLog((MarkerLog)newValue);
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
            case MappingPackage.MAPPING_REPOSITORY__MAPPINGS:
                getMappings().clear();
                return;
            case MappingPackage.MAPPING_REPOSITORY__MARKER_LOG:
                setMarkerLog((MarkerLog)null);
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
            case MappingPackage.MAPPING_REPOSITORY__MAPPINGS:
                return !getMappings().isEmpty();
            case MappingPackage.MAPPING_REPOSITORY__MARKER_LOG:
                return getMarkerLog() != null;
        }
        return super.eIsSet(featureID);
    }

} //MappingRepositoryImpl
