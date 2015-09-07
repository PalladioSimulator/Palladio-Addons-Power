package de.fzi.power.ui.views.navigator;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.palladiosimulator.edp2.datastream.IDataSource;
import org.palladiosimulator.edp2.datastream.IDataSourceListener;
import org.palladiosimulator.edp2.datastream.IDataStream;
import org.palladiosimulator.edp2.datastream.chaindescription.ChainDescription;
import org.palladiosimulator.edp2.datastream.configurable.IPropertyConfigurable;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.edp2.visualization.AbstractVisualizationInput;
import org.palladiosimulator.edp2.visualization.AbstractVisualizationSingleDatastreamConfiguration;
import org.palladiosimulator.edp2.visualization.IVisualisationInput;
import org.palladiosimulator.edp2.visualization.IVisualisationSingleDatastreamInput;
import org.palladiosimulator.measurementframework.MeasuringValue;
import org.palladiosimulator.metricspec.MetricDescription;
import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;

import de.fzi.power.infrastructure.PowerProvidingEntity;
import de.fzi.power.interpreter.calculators.energy.AbstractCumulativeEnergyCalculator;
import de.fzi.power.interpreter.calculators.energy.SimpsonRuleCumulativeEnergyCalculator;
import de.fzi.power.ui.Activator;
import de.fzi.power.ui.adapters.AnalysisCumulativeEnergyConsumptionAdapter;
import de.fzi.power.ui.adapters.AnalysisPowerConsumptionAdapter;
import de.fzi.power.ui.views.configuration.ExtendedMeasureProviderConfigurationContainer;
import de.fzi.power.ui.views.util.Edp2RunSelectionListener;
import de.fzi.power.ui.views.util.PowerInfrastructureEntititySelectionListener;

public class Navigator extends ViewPart {

    private static final Logger LOGGER = Logger.getLogger(Navigator.class.getCanonicalName());

    private ISelectionListener listener = new PowerInfrastructureEntititySelectionListener(this);
    private PowerProvidingEntity powerProvidingEntity = null;

    private ISelectionListener edp2listener = new Edp2RunSelectionListener(this);
    private ExperimentRun run;

    private ExtendedMeasureProviderConfigurationContainer configurationContainer;

    private static final String DATASINK_EXTENSION_POINT_ID = "org.palladiosimulator.edp2.visualization.datasink";
    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";
    private static final String ELEMENT_ID_PROPERTY = "property";
    private static final String PROPERTY_KEY_ATTRIBUTE = "key";
    private static final String PROPERTY_VALUE_ATTRIBUTE = "value";
    private static final String NAME_ATTRIBUTE = "name";

    private static final String SCATTER_PLOT_ID = "org.palladiosimulator.edp2.visualization.inputs.ScatterPlotInput";
    private static final String CHART_TITLE = "Power Consumption over Time";
    private static final String CHART_TITLE_ATTRIBUTE = "title";

    private static final String ENERGY_TITLE = "Cumulative Energy Consumption over Time";

    public Navigator() {
        super();
    }

    @Override
    public void createPartControl(Composite parent) {
        parent.setLayout(new GridLayout());

        // TODO make this better by registering/unregistering to specific change listener when
        // de.fzi.power.infrastructure.presentation.InfrastructureEditorID is invoked.
        ISelectionService service = getSite().getWorkbenchWindow().getSelectionService();
        service.addSelectionListener(listener);
        service.addSelectionListener(edp2listener);

        configurationContainer = new ExtendedMeasureProviderConfigurationContainer();
        configurationContainer.createControl(parent);
        configurationContainer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        configurationContainer.initializeFrom(new AnalysisPowerConsumptionAdapter().getProperties());

        Button analyzeConsumptionButton = new Button(parent, SWT.PUSH);
        analyzeConsumptionButton.setText("Show power consumption over time");
        analyzeConsumptionButton.setLayoutData(new GridData(SWT.END, SWT.END, true, false, 1, 1));

        Listener buttonListener = new Listener() {
            @Override
            public void handleEvent(Event event) {
                // todo do this with strategy pattern or utility methods returning a Boolean
                if (powerProvidingEntity == null || run == null) {
                    if (powerProvidingEntity == null) {
                        MessageDialog
                                .openError(
                                        Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(),
                                        "No PowerProvidingEntity selected",
                                        "Make sure to select a PowerProvidingEntity in one of the EMF-based tree editors, e.g. a MountedPowerDistributionUnit instance.");
                    } else if (run == null) {
                        MessageDialog.openError(Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
                                .getShell(), "No ExperimentRun selected",
                                "Make sure to select an ExperimentRun in EDP2's 'Experiment' View.");
                    }
                } else if (!configurationContainer.isValid()) {
                    MessageDialog.openError(
                            Activator.getDefault().getWorkbench().getActiveWorkbenchWindow().getShell(),
                            "Configuration Validation Error", configurationContainer.getErrorMessage());
                } else {
                    AnalysisPowerConsumptionAdapter powerAdapter = createAndOpenPowerConsumptionChart();
                    if (powerAdapter != null)
                        createAndOpenEnergyConsumptionChart(powerAdapter);
                }
            }

            private Listener init(Navigator navigator) {
                return this;
            }
        }.init(this);
        analyzeConsumptionButton.addListener(SWT.Selection, buttonListener);

    }

    private AnalysisPowerConsumptionAdapter createAndOpenPowerConsumptionChart() {

        AnalysisPowerConsumptionAdapter adapter = null;

        IPropertyConfigurable configurable = null;
        IConfigurationElement element = null;
        IConfigurationElement[] visualizationExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
                DATASINK_EXTENSION_POINT_ID);
        for (IConfigurationElement e : visualizationExtensions) {
            if (e.getAttribute(ID_ATTRIBUTE).equals(SCATTER_PLOT_ID)) {
                try {
                    configurable = (AbstractVisualizationInput<?>) e.createExecutableExtension(CLASS_ATTRIBUTE);
                } catch (CoreException e1) {
                    LOGGER.log(
                            Level.SEVERE,
                            "Error in creating a Visualization referenced in an extension: Respective Id is "
                                    + e.getAttribute(ID_ATTRIBUTE) + ".");
                    LOGGER.log(Level.SEVERE, e1.getMessage());
                    throw new RuntimeException();
                }
                element = e;
                break;
            }
        }
        if (configurable != null) {
            adapter = new AnalysisPowerConsumptionAdapter();

            adapter.setExperimentRun(run);
            adapter.setPowerProvidingEntity(powerProvidingEntity);

            Map<String, Object> adapterConfiguration = adapter.getProperties();
            configurationContainer.performApply(adapterConfiguration);
            adapter.setProperties(adapterConfiguration);

            Map<String, Object> elementProperties = new HashMap<String, Object>(configurable.getProperties());
            for (final IConfigurationElement property : element.getChildren(ELEMENT_ID_PROPERTY)) {
                elementProperties.put(property.getAttribute(PROPERTY_KEY_ATTRIBUTE),
                        property.getAttribute(PROPERTY_VALUE_ATTRIBUTE));
            }
            // add chart title
            elementProperties.put(CHART_TITLE_ATTRIBUTE, CHART_TITLE);
            elementProperties.put(AbstractVisualizationSingleDatastreamConfiguration.INPUT_NAME_KEY, CHART_TITLE);
            configurable.setProperties(elementProperties);
            final ChainDescription chainDescription = new ChainDescription(element.getAttribute(ID_ATTRIBUTE),
                    element.getAttribute(NAME_ATTRIBUTE), adapter, configurable);

            @SuppressWarnings("unchecked")
            IVisualisationInput<IVisualisationSingleDatastreamInput> input = (IVisualisationInput<IVisualisationSingleDatastreamInput>) chainDescription
                    .getVisualizationInput();
            input.addInput(input.createNewInput(adapter));

            try {
                final IWorkbenchPage page = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
                        .getActivePage();
                page.openEditor(input, "org.palladiosimulator.edp2.visualization.editors.JFreeChartEditor");
            } catch (final PartInitException exception) {
                throw new RuntimeException(exception);
            }
        }
        return adapter;
    }

    private void createAndOpenEnergyConsumptionChart(final AnalysisPowerConsumptionAdapter powerAdapter) {

        IPropertyConfigurable configurable = null;
        IConfigurationElement element = null;
        IConfigurationElement[] visualizationExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
                DATASINK_EXTENSION_POINT_ID);
        for (IConfigurationElement e : visualizationExtensions) {
            if (e.getAttribute(ID_ATTRIBUTE).equals(SCATTER_PLOT_ID)) {
                try {
                    configurable = (AbstractVisualizationInput<?>) e.createExecutableExtension(CLASS_ATTRIBUTE);
                } catch (CoreException e1) {
                    LOGGER.log(
                            Level.SEVERE,
                            "Error in creating a Visualization referenced in an extension: Respective Id is "
                                    + e.getAttribute(ID_ATTRIBUTE) + ".");
                    LOGGER.log(Level.SEVERE, e1.getMessage());
                    throw new RuntimeException();
                }
                element = e;
                break;
            }
        }
        if (configurable != null) {
            AbstractCumulativeEnergyCalculator energyCalculator = new SimpsonRuleCumulativeEnergyCalculator();
            AnalysisCumulativeEnergyConsumptionAdapter energyAdapter = new AnalysisCumulativeEnergyConsumptionAdapter(
                    energyCalculator);
            energyAdapter.setDataSource(new EnergyAdapterDataSource(powerAdapter, configurable));
            
            Map<String, Object> elementProperties = new HashMap<String, Object>(configurable.getProperties());
            for (final IConfigurationElement property : element.getChildren(ELEMENT_ID_PROPERTY)) {
                elementProperties.put(property.getAttribute(PROPERTY_KEY_ATTRIBUTE),
                        property.getAttribute(PROPERTY_VALUE_ATTRIBUTE));
            }
            // add chart title
            elementProperties.put(CHART_TITLE_ATTRIBUTE, ENERGY_TITLE);
            elementProperties.put(AbstractVisualizationSingleDatastreamConfiguration.INPUT_NAME_KEY, ENERGY_TITLE);
            configurable.setProperties(elementProperties);
            final ChainDescription chainDescription = new ChainDescription(element.getAttribute(ID_ATTRIBUTE),
                    element.getAttribute(NAME_ATTRIBUTE), energyAdapter, configurable);

            @SuppressWarnings("unchecked")
            IVisualisationInput<IVisualisationSingleDatastreamInput> input = (IVisualisationInput<IVisualisationSingleDatastreamInput>) chainDescription
                    .getVisualizationInput();
            input.addInput(input.createNewInput(energyAdapter));

            try {
                final IWorkbenchPage page = Activator.getDefault().getWorkbench().getActiveWorkbenchWindow()
                        .getActivePage();
                page.openEditor(input, "org.palladiosimulator.edp2.visualization.editors.JFreeChartEditor");
            } catch (final PartInitException exception) {
                throw new RuntimeException(exception);
            }
        }

    }

    @Override
    public void setFocus() {
    }

    public void setSelectedPowerProvidingEntity(PowerProvidingEntity selectedPowerProvidingEntity) {
        this.powerProvidingEntity = selectedPowerProvidingEntity;
    }

    public void setSelectedExperimentRun(ExperimentRun run) {
        this.run = run;
    }

    private static class EnergyAdapterDataSource implements IDataSource {

        private final AnalysisPowerConsumptionAdapter powerAdapter;
        private final IPropertyConfigurable conf;
        
        public EnergyAdapterDataSource(AnalysisPowerConsumptionAdapter powerAdapter, IPropertyConfigurable conf) {
            this.powerAdapter = powerAdapter;
            this.conf = conf;
        }
        
        @Override
        public boolean isCompatibleWith(MetricDescription other) {
            return getMetricDesciption().equals(other);
        }

        @Override
        public MetricDescription getMetricDesciption() {
            return MetricDescriptionConstants.POWER_CONSUMPTION_TUPLE;
        }

        @Override
        public MeasuringPoint getMeasuringPoint() {
            return powerAdapter.getMeasuringPoint();
        }

        @Override
        public <G extends IPropertyConfigurable> G getConfiguration() {
            @SuppressWarnings("unchecked")
            G config = (G) conf;
            return config;
        }

        @SuppressWarnings("unchecked")
        @Override
        public IDataStream<MeasuringValue> getDataStream() {
            return powerAdapter.getDataStream();
        }

        @Override
        public void addObserver(IDataSourceListener observer) {
            // don't do nothing
        }

        @Override
        public void removeObserver(IDataSourceListener observer) {
            // don't do nothing
        }
        
    }
}
