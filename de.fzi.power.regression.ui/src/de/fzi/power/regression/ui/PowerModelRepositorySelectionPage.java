package de.fzi.power.regression.ui;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.fzi.power.specification.PowerModelRepository;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;

public class PowerModelRepositorySelectionPage extends WizardPage {
    
    private Text textPowerModel;
    private PowerModelRepository model;
    
    public PowerModelRepositorySelectionPage() {
        super("Select Model Resource in which the Symbolic Regression Model is to be stored.");
        setTitle("Select Power Model Resource");
        setDescription("Please select the model resource in which the Symbolic Regression Model is to be stored.");
        this.setPageComplete(false);
    }
    
    @Override
    public void createControl(Composite parent) {
        ModifyListener modifyListener = new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                ResourceSet resourceSet = new ResourceSetImpl();
                Resource powerModelResource = resourceSet.createResource(URI.createURI(textPowerModel.getText()));
                try {
                    powerModelResource.load(Collections.EMPTY_MAP);
                    model = (PowerModelRepository) powerModelResource.getContents().get(0);
                    PowerModelRepositorySelectionPage.this.setPageComplete(true);
                } catch (IOException e1) {
                    PowerModelRepositorySelectionPage.this.setPageComplete(false);
                }
            }
        };
        Composite container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        setControl(container);
        this.textPowerModel = new Text(container, SWT.SINGLE | SWT.BORDER);
        TabHelper.createFileInputSection(container, modifyListener, "Power Model Specification File", 
                new String[] {"*.spec"}, this.textPowerModel, "Select the Power Model Specification File", getShell(), "");
    }
    
    public PowerModelRepository getPowerModelRepository() {
        return this.model;
    }
    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        super.dispose();
    }

}
