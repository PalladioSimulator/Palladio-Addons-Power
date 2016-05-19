package de.fzi.power.regression.ui;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.emf.databinding.EMFProperties;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;

public class ExperimentRunTreeFactoryImpl implements IObservableFactory {

    @Override
    public IObservable createObservable(Object target) {
        if(target instanceof IObservableList) {
            return (IObservable) target;
        } else if (target instanceof Repository) {
            return EMFProperties.list(RepositoryPackage.Literals.REPOSITORY__EXPERIMENT_GROUPS).observe(target);
        } else if (target instanceof ExperimentGroup) {
            return EMFProperties.multiList(ExperimentDataPackage.Literals.EXPERIMENT_GROUP__REPORTS,
                    ExperimentDataPackage.Literals.EXPERIMENT_GROUP__EXPERIMENT_SETTINGS).observe(target);
        }
        return null;
    }

}
