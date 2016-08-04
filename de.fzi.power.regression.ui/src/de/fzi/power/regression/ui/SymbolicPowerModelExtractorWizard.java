package de.fzi.power.regression.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import org.eclipse.jface.wizard.Wizard;
import org.palladiosimulator.edp2.models.Repository.Repositories;

import de.fzi.power.binding.PowerBindingRepository;

public class SymbolicPowerModelExtractorWizard extends Wizard {

    private PowerBindingRepository repo;
    private ModelSelectionPage modelSelectionPage;
    private PowerModelRepositorySelectionPage repositorySelectionPage;

    public SymbolicPowerModelExtractorWizard(PowerBindingRepository repo, Repositories repositories) {
        ExperimentGroupSelectionPage runSelectionPage = new ExperimentGroupSelectionPage(repositories);
        this.repositorySelectionPage = new PowerModelRepositorySelectionPage();
        this.repo = repo;
        this.modelSelectionPage = new ModelSelectionPage(runSelectionPage, repositorySelectionPage, this.repo);
        addPage(runSelectionPage);
        addPage(repositorySelectionPage);
        addPage(modelSelectionPage);
    }

    @Override
    public boolean performFinish() {
        try {
            this.repo.eResource().save(Collections.EMPTY_MAP);
            this.repositorySelectionPage.getPowerModelRepository().eResource().save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    @Override
    public boolean canFinish() {
        return Arrays.stream(this.getPages()).allMatch(p -> p.isPageComplete());
    }   
    

}
