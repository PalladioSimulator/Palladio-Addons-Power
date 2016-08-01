package de.fzi.power.regression.ui;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.measure.quantity.Power;
import javax.measure.quantity.Quantity;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import de.fzi.power.binding.ResourcePowerBinding;
import de.fzi.power.regression.edp2.Edp2ModelConstructor;
import de.fzi.power.regression.r.AbstractNonLinearRegression;
import de.fzi.power.regression.r.DoubleModelParameter;
import de.fzi.power.specification.DeclarativePowerModelSpecification;

public class ResultingPowerModelPage extends WizardPage {

    private ExperimentRunSelectionPage previousPage;
    private ResourcePowerBinding powerModelBinding;
    private TableViewer viewer;
    private FormData formData;
    private Canvas plotGroup;
    private Label label;
    private Table table;
    private Composite container;
    private FormData parameterForm;
    private List<DoubleModelParameter<? extends Quantity>> params;

    public ResultingPowerModelPage(ExperimentRunSelectionPage runSelectionPage, ResourcePowerBinding resourcePowerBinding) {
        super("Confirm extracted Power Model");
        this.previousPage = runSelectionPage;
        this.powerModelBinding = resourcePowerBinding;
        setTitle("Extracted Power Model");
        setDescription("View and Confirm the Extracted Power Model Parameters.");
    }

    @Override
    public void createControl(Composite parent) {
        this.container = new Composite(parent, SWT.NONE);
        FormLayout layout = new FormLayout();
        container.setLayout(layout);
        this.plotGroup = new Canvas(container, SWT.CENTER | SWT.BORDER);
        this.formData = new FormData();
        formData.width = 600;
        formData.height = 400;
        plotGroup.setLayoutData(formData);

        this.viewer = new TableViewer(container, SWT.MULTI | SWT.BORDER);
        this.viewer.setContentProvider(ArrayContentProvider.getInstance());
        this.table = this.viewer.getTable();
        this.parameterForm = new FormData();
        table.setLayoutData(parameterForm);
        String[] titles = { "Parameter", "Value", "Unit"};
        table.setHeaderVisible(true);
        
        TableViewerColumn nameCol = createTableViewerColumn(this.viewer, titles[0], 100, 0);
        nameCol.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                return ((DoubleModelParameter<Power>) element).getName();
            }
        });
        
        TableViewerColumn valueCol = createTableViewerColumn(viewer, titles[1], 100, 1);
        valueCol.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                DoubleModelParameter<Power> doubleParam = ((DoubleModelParameter<Power>) element);
                return doubleParam.getValue().getValue().toString();
            }
        });
        
        TableViewerColumn unitCol = createTableViewerColumn(viewer, titles[2], 100, 2);
        unitCol.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                return ((DoubleModelParameter<Power>) element).getUnit().toString();
            }
        });

        setControl(this.container);
    }
    
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);  
        if(visible) {
            Edp2ModelConstructor constructor = new Edp2ModelConstructor(this.previousPage.getSelectedExperimentGroup());
            AbstractNonLinearRegression<Power> model = constructor.constructPowerModel(this.powerModelBinding);
            
            String powerModelInfo = "Power Model: " + ((DeclarativePowerModelSpecification) this.powerModelBinding.getResourcePowerModelSpecification()).getFunctionalExpression();
            this.label = new Label(container, SWT.LEFT);
            FormData modelForm = new FormData();
            label.setLayoutData(modelForm);
            label.setText(powerModelInfo);
            this.params = model.deriveParameters();
            this.viewer.setInput(this.params);
            TableColumn[] tableColumns = this.table.getColumns();
            for(int idx = 0; idx < tableColumns.length; idx++) {
                tableColumns[idx].pack();
            }
            File plotFile;
            try {
                plotFile = model.generateVectorPlot(formData.width, formData.height, this.getShell().getFont().getFontData()[0].getHeight());
            } catch (IOException e) {
                throw new IllegalStateException("Could not access the file generated by R. Check file access privileges.", e);
            }
            plotGroup.setBackgroundImage(new Image(Display.getCurrent(), plotFile.getAbsolutePath()));
            this.viewer.refresh();
            plotGroup.redraw();
            modelForm.top = new FormAttachment(plotGroup, 4);
            this.parameterForm.top = new FormAttachment(label, 4);
            modelForm.width = formData.width;
            final Point newSize = this.getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
            this.getShell().setSize(newSize);
            container.pack();
        }
    }

    private TableViewerColumn createTableViewerColumn(TableViewer viewer, String title, int bound, final int colNumber) {
        final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
            SWT.NONE, colNumber);
        final TableColumn column = viewerColumn.getColumn();
        column.setText(title);
        column.setWidth(bound);
        column.setResizable(true);
        column.setMoveable(true);
        return viewerColumn;
    }
    
    public List<DoubleModelParameter<? extends Quantity>> getParams() {
        return this.params;
    }
}