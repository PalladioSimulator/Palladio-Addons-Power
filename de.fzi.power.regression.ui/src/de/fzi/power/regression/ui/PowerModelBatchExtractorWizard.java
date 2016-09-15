package de.fzi.power.regression.ui;

import java.util.Arrays;

import org.eclipse.jface.wizard.Wizard;
import org.palladiosimulator.edp2.models.Repository.Repositories;

import de.fzi.power.binding.PowerBindingRepository;

public class PowerModelBatchExtractorWizard extends Wizard {
    
    private ExperimentGroupSelectionPage runSelectionPage;
    private BatchResultsPage resultsPage;

    public PowerModelBatchExtractorWizard(PowerBindingRepository bindingRepository, Repositories repositories) {
        this.runSelectionPage = new ExperimentGroupSelectionPage(repositories);
        this.resultsPage = new BatchResultsPage(runSelectionPage, bindingRepository);
        addPage(this.runSelectionPage);
        addPage(this.resultsPage);
    }

    @Override
    public boolean performFinish() {
        resultsPage.performFinish();
        return true;
    }
    
    @Override
    public boolean canFinish() {
        return Arrays.stream(this.getPages()).allMatch(p -> p.isPageComplete());
    }

}
