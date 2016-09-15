package de.fzi.power.regression.ui;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.measure.quantity.Power;
import javax.measure.quantity.Quantity;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.fzi.power.binding.AbstractFixedFactorValue;
import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.regression.edp2.Edp2ModelConstructor;
import de.fzi.power.regression.r.AbstractNonLinearRegression;
import de.fzi.power.regression.r.DoubleModelParameter;

public class BatchResultsPage extends WizardPage {

    private ExperimentGroupSelectionPage runSelectionPage;
    private PowerBindingRepository repository;
    private Map<ResourcePowerBinding, List<DoubleModelParameter<? extends Quantity>>> resultMap = new HashMap<>();
    private Text text;

    public BatchResultsPage(ExperimentGroupSelectionPage runSelectionPage, PowerBindingRepository repository) {
        super("Confirm extracted power model parameters.");
        this.runSelectionPage = runSelectionPage;
        this.repository = repository;
        setTitle("AIC values for power models.");
        setDescription("The following contains a copiable list of AIC parameters for the selected power models.");
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        setControl(container);
        container.setLayout(new FillLayout());
        this.text = new Text(container, SWT.BORDER | SWT.MULTI);
    }

    public void performFinish() {
        for(Entry<ResourcePowerBinding, List<DoubleModelParameter<? extends Quantity>>> curEntry : resultMap.entrySet()) {
            ResourcePowerBinding binding = curEntry.getKey();
            List<DoubleModelParameter<? extends Quantity>> params = curEntry.getValue();
            for(DoubleModelParameter<? extends Quantity> curParam : params) {
                AbstractFixedFactorValue matchingFactorValue = binding.getFixedFactorValues()
                        .stream().filter(p -> p.getBoundFactor().getName()
                                .equals(curParam.getName())).findAny().get();
                matchingFactorValue.setValue(curParam.getValue());
            }
        }
        try {
            repository.eResource().save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if(visible) {
            StringBuilder resultBuilder = new StringBuilder();
            Collection<ResourcePowerBinding> bindings = EcoreUtil.<ResourcePowerBinding>getObjectsByType(repository.getPowerBindings(), BindingPackage.eINSTANCE.getResourcePowerBinding());
            for(ResourcePowerBinding binding : bindings) {
                Edp2ModelConstructor constructor = new Edp2ModelConstructor(this.runSelectionPage.getSelectedExperimentGroup());
                AbstractNonLinearRegression<Power> model = constructor.constructPowerModel(binding);
                resultMap.put(binding, model.deriveParameters());
                String aicString = model.getAIC() == null ? "" : Double.toString(model.getAIC());
                resultBuilder.append(binding.getName() + "\t" + aicString + "\n");
            }
            text.setText(resultBuilder.toString());
        }
    }
}
