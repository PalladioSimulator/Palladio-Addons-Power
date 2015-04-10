package de.fzi.power.ui.views.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.ExperimentData.util.ExperimentDataSwitch;

import de.fzi.power.ui.views.navigator.Navigator;

public class Edp2RunSelectionListener implements ISelectionListener {

    private final Navigator navigator;

    public Edp2RunSelectionListener(Navigator navigator) {
        this.navigator = navigator;
    }
    
    @Override
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        if(selection instanceof TreeSelection) {
            Object selectedObject = ((TreeSelection) selection).getFirstElement();
            if(selectedObject instanceof EObject) {
                ExperimentRun run = new ExperimentDataSwitch<ExperimentRun>() {
                    public ExperimentRun caseExperimentRun(ExperimentRun run) {
                        return run;
                    }
                }.doSwitch((EObject) selectedObject);
                if(run != null) {
                    navigator.setSelectedExperimentRun(run);
                }
            }
        }
    }

}
