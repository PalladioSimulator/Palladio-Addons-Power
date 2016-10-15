package org.palladiosimulator.profiling.evaluation.ui;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentSetting;
import org.palladiosimulator.profiling.evaluation.EvaluationResult;
import org.palladiosimulator.profiling.evaluation.ImmediateConsumptionCalculator;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.ResourcePowerBinding;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;

public class ResultsPage extends WizardPage {

    private static final String TAB = "\t";
    private static final String HEADER = "Name" + TAB + "Measured" + TAB + "Predicted" + TAB + "Error" + TAB + "Aggregate Error\n";
    boolean previouslyVisible = false;
    private ExperimentRunOrGroupSelectionPage runOrGroupSelectionPage;
    private PowerBindingRepository bindingRepo;
    private Text text;
    
    public ResultsPage(ExperimentRunOrGroupSelectionPage runOrGroupSelectionPage, PowerBindingRepository bindingRepo) {
        super("Comparison of Measured and Predicted Consumption");
        setTitle("Comparison of Measured and Predicted Consumption");
        this.runOrGroupSelectionPage = runOrGroupSelectionPage;
        this.bindingRepo = bindingRepo;
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        setControl(container);


        container.setLayout(new FillLayout());


        this.text = new Text(container, SWT.BORDER | SWT.MULTI);
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if(visible && previouslyVisible == false) {
            ImmediateConsumptionCalculator calculator = new ImmediateConsumptionCalculator();
            Collection<ResourcePowerBinding> bindings = EcoreUtil.<ResourcePowerBinding>getObjectsByType(bindingRepo.getPowerBindings(), BindingPackage.eINSTANCE.getResourcePowerBinding());
            StringBuilder builder = new StringBuilder();
            List<ExperimentRun> map = runOrGroupSelectionPage.getSelectedExperimentRunOrGroup().getRight().map(g -> g.getExperimentSettings().stream().collect(Collectors.toList()).stream().flatMap(m -> m.getExperimentRuns().stream()).collect(Collectors.toList())).orElseGet(Collections::emptyList);
            Optional<List<ExperimentRun>> map2 = runOrGroupSelectionPage.getSelectedExperimentRunOrGroup().getLeft().map(Collections::singletonList);
            List<ExperimentRun> runs = map2.orElse(map);
            // Filter HDD only
            //runs = runs.stream().filter(s -> s.getExperimentSetting().getDescription().contains("storageWriteKbpsRandom = Infinity")).collect(Collectors.toList());
            //runs = runs.stream().filter(s -> !s.getExperimentSetting().getDescription().contains("storageWriteKbpsRandom = Infinity")).collect(Collectors.toList());
            Pattern pattern = Pattern.compile("/workloads/(.*?)_");
            String previousDescriptor = "";
            Map<ResourcePowerBinding, EvaluationResult> aggregateMap = new HashMap<ResourcePowerBinding, EvaluationResult>();
            for(ExperimentRun run : runs) {           
                final String curDescription = run.getExperimentSetting().getDescription();
                final Matcher curMatcher = pattern.matcher(curDescription);
                final Matcher prevMatcher = pattern.matcher(previousDescriptor);
                final boolean headerEqual = (curDescription.equals(previousDescriptor));
                final boolean curMatches = curMatcher.find();
                final boolean prevMatches = prevMatcher.find();
                boolean equalMatches = false;
                if(prevMatches && curMatches) {
                    equalMatches = curMatcher.group(1).equals(prevMatcher.group(1));
                }
                if(!(previousDescriptor.equals("RT_CURVE") || previousDescriptor.startsWith("TargetLevel")) &&(!equalMatches || (!curMatches && !headerEqual))) {
                    if(prevMatches && !headerEqual) {
                        addHeader(builder,prevMatcher.group().substring(0, prevMatcher.group().length()-1));
                    } else {
                        addHeader(builder,curDescription);
                    }
                    for(ResourcePowerBinding binding : bindings) {
                        if(aggregateMap.get(binding) != null) {
                            EvaluationResult prevAggregate = aggregateMap.get(binding);
                            addResult(builder, binding, prevAggregate);
                        }
                        EvaluationResult aggregate = new EvaluationResult(this.getDescription(), 0d, 0d, 0d);
                        aggregateMap.put(binding, aggregate);
                    }
                }
                for(ResourcePowerBinding binding : bindings) {
                    EvaluationResult aggregate = aggregateMap.get(binding);
                    EvaluationResult result = calculator.calculate(run, binding); 
                    aggregate.add(result);
                }
                
                previousDescriptor = curDescription;
            }

            final Matcher prevMatcher = pattern.matcher(previousDescriptor);
            boolean prevMatches = prevMatcher.find();
            if(prevMatches) {
                addHeader(builder, prevMatcher.group(1));
            } else {
                addHeader(builder, previousDescriptor);
            }
            for(ResourcePowerBinding binding : bindings) {
                addResult(builder, binding, aggregateMap.get(binding));
            }
            text.setText(builder.toString());     
        }
        previouslyVisible = visible;
    }

    private void addHeader(StringBuilder builder, String previousDescriptor) {
        builder.append("\n" + previousDescriptor + "\n");
        builder.append(HEADER);
    }

    private void addResult(StringBuilder builder, ResourcePowerBinding binding, EvaluationResult aggregate) {
        builder.append(binding.getName() + TAB + aggregate.getAbsoluteMeasured() + TAB + aggregate.getAbsolutePredicted()
        + TAB + aggregate.getPredictionError() + TAB + aggregate.getTotalError()/aggregate.getAbsoluteMeasured() + "\n");
    }
}
