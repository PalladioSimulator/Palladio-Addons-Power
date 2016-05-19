package de.fzi.power.regression.ui;

import java.util.Arrays;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.Repository.Repositories;

import de.fzi.power.binding.ResourcePowerBinding;

public class PowerModelExtractorWizard extends Wizard {

    private ResourcePowerBinding resourcePowerBinding;
    private ExperimentRunSelectionPage runSelectionPage;
    private ResultingPowerModelPage resultsPage;

    public PowerModelExtractorWizard(ResourcePowerBinding resourcePowerBinding, Repositories repositories) {
        this.resourcePowerBinding = resourcePowerBinding;
        this.runSelectionPage = new ExperimentRunSelectionPage(repositories, this.resourcePowerBinding);
        this.resultsPage = new ResultingPowerModelPage(runSelectionPage, this.resourcePowerBinding);
        addPage(runSelectionPage);
        addPage(resultsPage);
    }

    @Override
    public boolean performFinish() {
        return Arrays.stream(this.getPages()).allMatch(p -> p.isPageComplete());
    }
    
    public ExperimentGroup getSelectedExperimentGroup() {
        return runSelectionPage.getSelectedExperimentGroup();
    }

}
