/**
 */
package de.fzi.power.profilingimport.mapping.impl;

import de.fzi.power.profilingimport.mapping.MappingPackage;
import de.fzi.power.profilingimport.mapping.MappingRepository;
import de.fzi.power.profilingimport.mapping.MetricToCsvMapping;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.palladiosimulator.metricspec.MetricSetDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric To Csv Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fzi.power.profilingimport.mapping.impl.MetricToCsvMappingImpl#getCsvFileUri <em>Csv File Uri</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.impl.MetricToCsvMappingImpl#getMetric <em>Metric</em>}</li>
 *   <li>{@link de.fzi.power.profilingimport.mapping.impl.MetricToCsvMappingImpl#getRepository <em>Repository</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetricToCsvMappingImpl extends IdentifierImpl implements MetricToCsvMapping {
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
    protected MetricToCsvMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.METRIC_TO_CSV_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCsvFileUri() {
        return (String)eDynamicGet(MappingPackage.METRIC_TO_CSV_MAPPING__CSV_FILE_URI, MappingPackage.Literals.METRIC_TO_CSV_MAPPING__CSV_FILE_URI, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCsvFileUri(String newCsvFileUri) {
        eDynamicSet(MappingPackage.METRIC_TO_CSV_MAPPING__CSV_FILE_URI, MappingPackage.Literals.METRIC_TO_CSV_MAPPING__CSV_FILE_URI, newCsvFileUri);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MetricSetDescription getMetric() {
        return (MetricSetDescription)eDynamicGet(MappingPackage.METRIC_TO_CSV_MAPPING__METRIC, MappingPackage.Literals.METRIC_TO_CSV_MAPPING__METRIC, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MetricSetDescription basicGetMetric() {
        return (MetricSetDescription)eDynamicGet(MappingPackage.METRIC_TO_CSV_MAPPING__METRIC, MappingPackage.Literals.METRIC_TO_CSV_MAPPING__METRIC, false, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMetric(MetricSetDescription newMetric) {
        eDynamicSet(MappingPackage.METRIC_TO_CSV_MAPPING__METRIC, MappingPackage.Literals.METRIC_TO_CSV_MAPPING__METRIC, newMetric);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MappingRepository getRepository() {
        return (MappingRepository)eDynamicGet(MappingPackage.METRIC_TO_CSV_MAPPING__REPOSITORY, MappingPackage.Literals.METRIC_TO_CSV_MAPPING__REPOSITORY, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRepository(MappingRepository newRepository, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newRepository, MappingPackage.METRIC_TO_CSV_MAPPING__REPOSITORY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRepository(MappingRepository newRepository) {
        eDynamicSet(MappingPackage.METRIC_TO_CSV_MAPPING__REPOSITORY, MappingPackage.Literals.METRIC_TO_CSV_MAPPING__REPOSITORY, newRepository);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MappingPackage.METRIC_TO_CSV_MAPPING__REPOSITORY:
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
            case MappingPackage.METRIC_TO_CSV_MAPPING__REPOSITORY:
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
            case MappingPackage.METRIC_TO_CSV_MAPPING__REPOSITORY:
                return eInternalContainer().eInverseRemove(this, MappingPackage.MAPPING_REPOSITORY__MAPPINGS, MappingRepository.class, msgs);
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
            case MappingPackage.METRIC_TO_CSV_MAPPING__CSV_FILE_URI:
                return getCsvFileUri();
            case MappingPackage.METRIC_TO_CSV_MAPPING__METRIC:
                if (resolve) return getMetric();
                return basicGetMetric();
            case MappingPackage.METRIC_TO_CSV_MAPPING__REPOSITORY:
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
            case MappingPackage.METRIC_TO_CSV_MAPPING__CSV_FILE_URI:
                setCsvFileUri((String)newValue);
                return;
            case MappingPackage.METRIC_TO_CSV_MAPPING__METRIC:
                setMetric((MetricSetDescription)newValue);
                return;
            case MappingPackage.METRIC_TO_CSV_MAPPING__REPOSITORY:
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
            case MappingPackage.METRIC_TO_CSV_MAPPING__CSV_FILE_URI:
                setCsvFileUri(CSV_FILE_URI_EDEFAULT);
                return;
            case MappingPackage.METRIC_TO_CSV_MAPPING__METRIC:
                setMetric((MetricSetDescription)null);
                return;
            case MappingPackage.METRIC_TO_CSV_MAPPING__REPOSITORY:
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
            case MappingPackage.METRIC_TO_CSV_MAPPING__CSV_FILE_URI:
                return CSV_FILE_URI_EDEFAULT == null ? getCsvFileUri() != null : !CSV_FILE_URI_EDEFAULT.equals(getCsvFileUri());
            case MappingPackage.METRIC_TO_CSV_MAPPING__METRIC:
                return basicGetMetric() != null;
            case MappingPackage.METRIC_TO_CSV_MAPPING__REPOSITORY:
                return getRepository() != null;
        }
        return super.eIsSet(featureID);
    }

} //MetricToCsvMappingImpl
