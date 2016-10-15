package org.palladiosimulator.profiling.evaluation.ui;

import java.util.Arrays;
import org.eclipse.jface.wizard.Wizard;
import org.palladiosimulator.edp2.models.Repository.Repositories;
import de.fzi.power.binding.PowerBindingRepository;

public class PowerEvaluationWizard extends Wizard {

    private PowerBindingRepository bindingRepo;
    private Repositories repositories;
    
    private ExperimentRunOrGroupSelectionPage runOrGroupSelectionPage;
    private ResultsPage resultsPage;

    public PowerEvaluationWizard(PowerBindingRepository bindingRepo, Repositories repositories) {
        this.bindingRepo = bindingRepo;
        this.repositories = repositories;
        this.runOrGroupSelectionPage = new ExperimentRunOrGroupSelectionPage(repositories);
        this.resultsPage = new ResultsPage(runOrGroupSelectionPage, bindingRepo);
        this.addPage(runOrGroupSelectionPage);
        this.addPage(resultsPage);
    }

    @Override
    public boolean performFinish() {
        return Arrays.asList(this.getPages()).stream().allMatch(p -> p.canFlipToNextPage());
    }

}
