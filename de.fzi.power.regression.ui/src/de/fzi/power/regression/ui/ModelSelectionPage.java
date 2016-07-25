package de.fzi.power.regression.ui;

import java.util.List;

import javax.measure.quantity.Power;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.fzi.power.binding.BindingPackage;
import de.fzi.power.binding.PowerBindingRepository;
import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.regression.edp2.Edp2ModelConstructor;
import org.vedantatree.expressionoasis.expressions.Expression;
import de.fzi.power.regression.r.SymbolicRegression;
import de.fzi.power.specification.PowerModelRepository;

public class ModelSelectionPage extends WizardPage {

    private ExperimentRunSelectionPage previousPage;
    private PowerBindingRepository repo;
    private ListViewer viewer;
    private Composite container;
    private Expression selectedExpression = null;
    private PowerModelRepositorySelectionPage repositorySelectionPage;
    private boolean wasVisible = false;

    public ModelSelectionPage(ExperimentRunSelectionPage runSelectionPage, PowerModelRepositorySelectionPage repositorySelectionPage, PowerBindingRepository repo) {
        super("Select from extracted Power Models");
        this.previousPage = runSelectionPage;
        this.repositorySelectionPage = repositorySelectionPage;
        this.repo = repo;
        setTitle("Extracted Power Model");
        setDescription("View and Select the Extracted Power Models.");
    }

    @Override
    public void createControl(Composite parent) {
        this.container = new Composite(parent, SWT.NONE);
        GridLayout gl = new GridLayout();
        gl.numColumns = 2;
        container.setLayout(gl);
        this.setControl(container);
        viewer = new ListViewer(container, SWT.SINGLE);
        viewer.setContentProvider(new IStructuredContentProvider() {
            @Override
            public void dispose() {
            }

            @Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            }

            @Override
            public Object[] getElements(Object inputElement) {
                return ((List<Expression>) inputElement).toArray();
            }            
        });
        viewer.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                selectedExpression = (Expression) ((StructuredSelection) event.getSelection()).getFirstElement();
            }
            
        });
    }
    
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);  
        if(visible && !wasVisible) {
            Edp2ModelConstructor constructor = new Edp2ModelConstructor(this.previousPage.getSelectedExperimentGroup());
            // TODO allow user to select repo. It can't be guaranteed that this collection is non-empty.
            PowerModelRepository modelRepo = this.repositorySelectionPage.getPowerModelRepository();
            SymbolicRegression<Power> symbolicModel = constructor.constructSymbolicModel(repo, modelRepo);
            List<Expression> eliteResults = symbolicModel.getEliteResults();
            viewer.setInput(eliteResults);
            container.layout();
        }
        wasVisible = visible;
    }
    
    @Override
    public boolean isPageComplete() {
        return this.selectedExpression != null;
    }
    
    public Expression getSelectedExpression() {
        return selectedExpression;
    }

}
