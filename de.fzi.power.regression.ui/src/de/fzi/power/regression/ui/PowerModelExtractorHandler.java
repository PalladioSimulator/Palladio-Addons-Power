package de.fzi.power.regression.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;
import org.palladiosimulator.edp2.EDP2Plugin;
import org.palladiosimulator.edp2.models.Repository.Repositories;

import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.specification.PowerModelRepository;

public class PowerModelExtractorHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        final ISelection selection = HandlerUtil.getCurrentSelection(event);
        final TreeSelection treeSelection = (TreeSelection) selection;
        if (treeSelection.getFirstElement() instanceof ResourcePowerBinding) {
            ResourcePowerBinding resourcePowerBinding = (ResourcePowerBinding) treeSelection.getFirstElement();
            Repositories repositories = EDP2Plugin.INSTANCE.getRepositories();
            Job job = new Job("Inferring power model from measurements in EDP2 repository") {

                @Override
                protected IStatus run(IProgressMonitor monitor) {
                    openDialog(event, resourcePowerBinding, repositories);
                    return Status.OK_STATUS;
                }
                
            };
            job.setUser(true);
            job.schedule();
        } else if(treeSelection.getFirstElement() instanceof PowerBindingRepository) {
            Repositories repositories = EDP2Plugin.INSTANCE.getRepositories();
            PowerBindingRepository bindingRepository = (PowerBindingRepository) treeSelection.getFirstElement();
            Job job = new Job("Inferring power models from measurements in EDP2 repository") {

                @Override
                protected IStatus run(IProgressMonitor monitor) {
                    openDialog(event, bindingRepository, repositories);
                    return Status.OK_STATUS;
                }
                
            };
            job.setUser(true);
            job.schedule();
        }
        
        return Status.OK;        
    }
    
    private void openDialog(ExecutionEvent event, ResourcePowerBinding resourcePowerBinding,
            Repositories repositories) {
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                PowerModelExtractorWizard extractorWizard = new PowerModelExtractorWizard(resourcePowerBinding, repositories);
                final WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), extractorWizard);
                dialog.setBlockOnOpen(true);
                dialog.open();
            }
        });
    }
    
    private void openDialog(ExecutionEvent event, PowerBindingRepository repository,
            Repositories repositories) {
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                PowerModelBatchExtractorWizard extractorWizard = new PowerModelBatchExtractorWizard(repository, repositories);
                final WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), extractorWizard);
                dialog.setBlockOnOpen(true);
                dialog.open();
            }
        });
    }
}
