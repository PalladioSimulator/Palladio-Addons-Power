package de.fzi.power.ui.views.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;

import de.fzi.power.infrastructure.MountedPowerDistributionUnit;
import de.fzi.power.infrastructure.PowerConsumingEntity;
import de.fzi.power.infrastructure.PowerConsumingResource;
import de.fzi.power.infrastructure.PowerDistributionUnit;
import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.infrastructure.util.InfrastructureSwitch;
import de.fzi.power.ui.views.navigator.Navigator;

public class PowerInfrastructureEntititySelectionListener implements ISelectionListener {

    private final Navigator navigator;

    public PowerInfrastructureEntititySelectionListener(Navigator navigator) {
        this.navigator = navigator;
    }

    public void selectionChanged(IWorkbenchPart sourcePart, ISelection selection) {
        if(selection instanceof TreeSelection) {
            Object selectedObject = ((TreeSelection) selection).getFirstElement();
            if(selectedObject instanceof EObject) {
                PowerProvidingEntity selectedPowerProvidingEntity = new InfrastructureSwitch<PowerProvidingEntity>() {
                    public PowerProvidingEntity casePowerProvidingEntity(final PowerProvidingEntity entity) {
                        return entity;
                    }                        
                    public PowerProvidingEntity caseMountedPowerDistributionUnit(final MountedPowerDistributionUnit object) {
                        return object;
                    }
                    public PowerProvidingEntity casePowerDistributionUnit(final PowerDistributionUnit object) {
                        return object;
                    }
                }.doSwitch((EObject) selectedObject);
                if(selectedPowerProvidingEntity != null) {
                    navigator.setSelectedPowerProvidingEntity(selectedPowerProvidingEntity);
                }
            }
        }
    }

}
