package de.fzi.power.regression.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import javax.measure.quantity.Power;

import org.eclipse.jface.wizard.Wizard;
import org.palladiosimulator.edp2.models.Repository.Repositories;

import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.regression.edp2.Edp2ModelConstructor;
import de.fzi.power.regression.r.EarthRegression;
import de.fzi.power.specification.DeclarativeResourcePowerModelSpecification;
import de.fzi.power.specification.PowerModelRepository;
import de.fzi.power.specification.SpecificationFactory;

public class EarthPowerModelExtractorWizard extends Wizard {

    private PowerBindingRepository repo;
    private PowerModelRepositorySelectionPage repositorySelectionPage;
    private ExperimentGroupSelectionPage runSelectionPage;

    public EarthPowerModelExtractorWizard(PowerBindingRepository repo, Repositories repositories) {
        this.runSelectionPage = new ExperimentGroupSelectionPage(repositories);
        this.repositorySelectionPage = new PowerModelRepositorySelectionPage();
        this.repo = repo;
        addPage(runSelectionPage);
        addPage(repositorySelectionPage);
    }

    @Override
    public boolean performFinish() {
        try {
            PowerModelRepository repository = this.repositorySelectionPage.getPowerModelRepository();
            Edp2ModelConstructor constructor = new Edp2ModelConstructor(this.runSelectionPage.getSelectedExperimentGroup());
            DeclarativeResourcePowerModelSpecification spec = SpecificationFactory.eINSTANCE.createDeclarativeResourcePowerModelSpecification();
            EarthRegression<Power> earthRegression = constructor.constructEarthModel(repo, repository, spec);
            repository.eResource().save(Collections.EMPTY_MAP);
            this.repo.eResource().save(Collections.EMPTY_MAP);
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
