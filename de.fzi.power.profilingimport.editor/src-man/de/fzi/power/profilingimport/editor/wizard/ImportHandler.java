package de.fzi.power.profilingimport.editor.wizard;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import de.fzi.power.profilingimport.mapping.MappingRepository;

public class ImportHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        final ISelection selection = HandlerUtil.getCurrentSelection(event);
        final TreeSelection treeSelection = (TreeSelection) selection;
        if (treeSelection.getFirstElement() instanceof MappingRepository) {
            MappingRepository repo = (MappingRepository) treeSelection.getFirstElement();
            Display.getDefault().syncExec(new Runnable() {
                public void run() {
                    final WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), new ImportWizard(repo));
                    dialog.setBlockOnOpen(true);
                    dialog.open();
                }
            });
        }
        
        return Status.OK;  
    }

}
