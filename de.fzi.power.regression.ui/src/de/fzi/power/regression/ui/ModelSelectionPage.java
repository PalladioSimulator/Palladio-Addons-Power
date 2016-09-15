package de.fzi.power.regression.ui;

import java.util.ArrayList;
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
import de.fzi.power.regression.r.expressionoasis.ExpressionUtil;
import de.fzi.power.regression.r.io.RUtils;
import de.fzi.power.specification.DeclarativePowerModelSpecification;
import de.fzi.power.specification.PowerModelRepository;
import de.fzi.power.specification.SpecificationFactory;

public class ModelSelectionPage extends WizardPage {

    private ExperimentGroupSelectionPage previousPage;
    private PowerBindingRepository repo;
    private ListViewer viewer;
    private Composite container;
    private String selectedExpression = null;
    private PowerModelRepositorySelectionPage repositorySelectionPage;
    private boolean wasVisible = false;
    private DeclarativePowerModelSpecification spec;

    public ModelSelectionPage(ExperimentGroupSelectionPage runSelectionPage, PowerModelRepositorySelectionPage repositorySelectionPage, PowerBindingRepository repo) {
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
                selectedExpression = (String) ((StructuredSelection) event.getSelection()).getFirstElement();
                spec.setFunctionalExpression(selectedExpression);
                spec.setName(spec.getFunctionalExpression());
                ModelSelectionPage.this.getContainer().updateButtons();
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
            this.spec = SpecificationFactory.eINSTANCE.createDeclarativePowerModelSpecification();
            SymbolicRegression<Power> symbolicModel = constructor.constructSymbolicModel(repo, modelRepo, spec);
            List<Expression> eliteResults = symbolicModel.getEliteResults();
            List<String> stringRepresentationElite = new ArrayList<String>();
            for(Expression curExp : eliteResults) {
                stringRepresentationElite.add(ExpressionUtil.convertToInputString(curExp));
            }
            viewer.setInput(stringRepresentationElite);
            container.layout();
        }
        wasVisible = visible;
    }
    
    @Override
    public boolean isPageComplete() {
        return this.selectedExpression != null;
    }

}
