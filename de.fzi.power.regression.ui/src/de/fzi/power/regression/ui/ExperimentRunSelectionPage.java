package de.fzi.power.regression.ui;

import java.util.List;

import javax.measure.quantity.Power;

import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.Repository.Repositories;
import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;
import org.palladiosimulator.edp2.ui.views.navigator.NavigatorTreeStructureAdvisorImpl;

import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.regression.edp2.Edp2ModelConstructor;
import de.fzi.power.regression.r.AbstractNonLinearRegression;
import de.fzi.power.regression.r.DoubleModelParameter;

public class ExperimentRunSelectionPage extends WizardPage {

    private Repositories repositories;
    
    private final IEMFListProperty NODES = EMFProperties
            .list(RepositoryPackage.Literals.REPOSITORIES__AVAILABLE_REPOSITORIES);

    private TreeViewer treeViewer;
    
    private ExperimentGroup selectedExperimentGroup;

    private ResourcePowerBinding binding;

    private List<DoubleModelParameter<Power>> modelParameters;

    private AbstractNonLinearRegression<Power> constructPowerModel;
    
    public ExperimentRunSelectionPage(Repositories repositories, ResourcePowerBinding binding) {
        super("Select the Experiment Group containing the benchmarking data.");
        this.repositories = repositories;
        this.binding = binding;
        setPageComplete(false);
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout gl = new GridLayout();
        container.setLayout(gl);
        this.setControl(container);
        this.treeViewer = new TreeViewer(container, SWT.FULL_SELECTION);
        this.treeViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
        ObservableListTreeContentProvider contentProvider =
                new ObservableListTreeContentProvider(
                  new ExperimentRunTreeFactoryImpl(),
                  new NavigatorTreeStructureAdvisorImpl()
              );
        this.treeViewer.setContentProvider(contentProvider);
        final IEMFListProperty nodes = EMFProperties
                .list(RepositoryPackage.Literals.REPOSITORIES__AVAILABLE_REPOSITORIES);
        this.treeViewer.setInput(nodes.observe(repositories));
        this.treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                ISelection selection = event.getSelection();
                if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
                    IStructuredSelection structuredSelection = (IStructuredSelection) selection;
                    Object selectedObject = structuredSelection.getFirstElement();
                    if(selectedObject instanceof ExperimentGroup) {
                        selectedExperimentGroup = (ExperimentGroup) selectedObject;
                        setPageComplete(true);
                    } else {
                        setPageComplete(false);
                    }
                }

            }
        });
        
        ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
                ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
        
        treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(
                adapterFactory));

    }

    public ExperimentGroup getSelectedExperimentGroup() {
        return selectedExperimentGroup;
    }
    
    @Override
    public IWizardPage getNextPage() {
        if(this.selectedExperimentGroup != null) {
            Edp2ModelConstructor constructor = new Edp2ModelConstructor(this.selectedExperimentGroup);
            this.constructPowerModel = constructor.constructPowerModel(this.binding);
            this.modelParameters = constructPowerModel.constructModel();
            return super.getNextPage();
        }
        
        return null;
        }

    public List<DoubleModelParameter<Power>> getModelParameters() {
        return modelParameters;
    }

    public AbstractNonLinearRegression<Power> getPowerModel() {
        return this.constructPowerModel;
    }
}
