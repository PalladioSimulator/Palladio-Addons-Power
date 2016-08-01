package de.fzi.power.regression.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.measure.quantity.Power;
import javax.measure.quantity.Quantity;

import org.eclipse.jface.wizard.Wizard;
import org.palladiosimulator.edp2.models.Repository.Repositories;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.regression.r.DoubleModelParameter;

public class PowerModelExtractorWizard extends Wizard {

    private ResourcePowerBinding resourcePowerBinding;
    private ExperimentRunSelectionPage runSelectionPage;
    private ResultingPowerModelPage resultsPage;

    public PowerModelExtractorWizard(ResourcePowerBinding resourcePowerBinding, Repositories repositories) {
        this.resourcePowerBinding = resourcePowerBinding;
        this.runSelectionPage = new ExperimentRunSelectionPage(repositories);
        this.resultsPage = new ResultingPowerModelPage(runSelectionPage, this.resourcePowerBinding);
        addPage(runSelectionPage);
        addPage(resultsPage);
    }

    @Override
    public boolean performFinish() {
        List<DoubleModelParameter<? extends Quantity>> params = this.resultsPage.getParams();
        for(DoubleModelParameter<? extends Quantity> curParam : params) {
            AbstractFixedFactorValue matchingFactorValue = resourcePowerBinding.getFixedFactorValues()
                    .stream().filter(p -> p.getBoundFactor().getName()
                            .equals(curParam.getName())).findAny().get();
            matchingFactorValue.setValue(curParam.getValue());
        }
        try {
            resourcePowerBinding.eResource().save(Collections.EMPTY_MAP);
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
