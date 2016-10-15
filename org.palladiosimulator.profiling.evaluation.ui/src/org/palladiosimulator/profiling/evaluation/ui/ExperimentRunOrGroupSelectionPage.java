package org.palladiosimulator.profiling.evaluation.ui;

import java.util.Optional;

import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
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
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentGroup;
import org.palladiosimulator.edp2.models.ExperimentData.ExperimentRun;
import org.palladiosimulator.edp2.models.Repository.Repositories;
import org.palladiosimulator.edp2.models.Repository.Repository;
import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;
import org.palladiosimulator.edp2.ui.views.navigator.NavigatorTreeFactoryImpl;
import org.palladiosimulator.edp2.ui.views.navigator.NavigatorTreeStructureAdvisorImpl;


public class ExperimentRunOrGroupSelectionPage extends WizardPage {

    private Repositories repositories;

    private TreeViewer treeViewer;
    
    private Pair<Optional<ExperimentRun>, Optional<ExperimentGroup>> selectedExperimentRunOrGroup = Pair.of(Optional.empty(), Optional.empty());
    
    public ExperimentRunOrGroupSelectionPage(Repositories repositories) {
        super("Select the Experiment Group containing the benchmarking data.");
        this.repositories = repositories;
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
                  new NavigatorTreeFactoryImpl(),
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
                    if(selectedObject instanceof ExperimentRun) {
                        selectedExperimentRunOrGroup = Pair.of(Optional.of((ExperimentRun) selectedObject), Optional.empty());
                        setPageComplete(true);
                    } else if (selectedObject instanceof ExperimentGroup) {
                        selectedExperimentRunOrGroup = Pair.of(Optional.empty(), Optional.of((ExperimentGroup) selectedObject));
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

    public Pair<Optional<ExperimentRun>, Optional<ExperimentGroup>> getSelectedExperimentRunOrGroup() {
        return selectedExperimentRunOrGroup;
    }
    
    @Override
    public boolean canFlipToNextPage() {
        return this.selectedExperimentRunOrGroup.getKey().isPresent() || this.selectedExperimentRunOrGroup.getValue().isPresent();
    }
}