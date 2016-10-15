package org.palladiosimulator.profiling.evaluation.ui;

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

public class EvaluationExecutionHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        final ISelection selection = HandlerUtil.getCurrentSelection(event);
        final TreeSelection treeSelection = (TreeSelection) selection;
        if(treeSelection.getFirstElement() instanceof PowerBindingRepository) {
            Repositories repositories = EDP2Plugin.INSTANCE.getRepositories();
            PowerBindingRepository bindingRepo = (PowerBindingRepository) treeSelection.getFirstElement();
            Job job = new Job("Evaluating accuracy of power models") {

                @Override
                protected IStatus run(IProgressMonitor monitor) {
                    openDialog(event, bindingRepo, repositories);
                    return Status.OK_STATUS;
                }
                
            };
            job.setUser(true);
            job.schedule();
        }
        return Status.OK;
    }
    
    private void openDialog(ExecutionEvent event, PowerBindingRepository bindingRepo,
            Repositories repositories) {
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                PowerEvaluationWizard wizard = new PowerEvaluationWizard(bindingRepo, repositories);
                final WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), wizard);
                dialog.setBlockOnOpen(true);
                dialog.open();
            }
        });
    }

}
