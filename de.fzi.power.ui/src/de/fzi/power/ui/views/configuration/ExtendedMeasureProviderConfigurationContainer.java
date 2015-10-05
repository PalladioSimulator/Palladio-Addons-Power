package de.fzi.power.ui.views.configuration;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;

public class ExtendedMeasureProviderConfigurationContainer extends ExtendedMeasureProviderConfigurationUI {

    private static final String EXTENSION_POINT_ID = "de.fzi.power.ui.configuration.extendedmeasureproviderconfigurationui";
    private static final String UI_ATTRIBUTE_ID = "uiElement";

    private Control control = null;

    protected Collection<ExtendedMeasureProviderConfigurationUI> subsumedUIs;

    public ExtendedMeasureProviderConfigurationContainer() {
        this.subsumedUIs = ExtensionHelper
                .<ExtendedMeasureProviderConfigurationUI> getExecutableExtensions(EXTENSION_POINT_ID, UI_ATTRIBUTE_ID);
    }

    @Override
    public void createControl(Composite parent) {
        control = createTabFolder(parent, SWT.BORDER | SWT.FLAT);
    }

    private CTabFolder createTabFolder(Composite parent, int style) {
        CTabFolder tabFolder = new CTabFolder(parent, style);
        Iterator<ExtendedMeasureProviderConfigurationUI> tabIterator = subsumedUIs.iterator();

        while (tabIterator.hasNext()) {
            ExtendedMeasureProviderConfigurationUI tab = tabIterator.next();
            tab.createControl(tabFolder);

            CTabItem tabItem = new CTabItem(tabFolder, SWT.NULL);
            tabItem.setText(tab.getName());
            tabItem.setControl(tab.getControl());
        }
        tabFolder.setSelection(0);

        return tabFolder;
    }

    @Override
    public void initializeFrom(Map<String, Object> configuration) {
        for (ExtendedMeasureProviderConfigurationUI ui : subsumedUIs) {
            ui.initializeFrom(configuration);
        }
    }

    @Override
    public void performApply(Map<String, Object> configuration) {
        for (ExtendedMeasureProviderConfigurationUI ui : subsumedUIs) {
            ui.performApply(configuration);
        }
    }

    @Override
    public String getErrorMessage() {
        StringBuilder builder = new StringBuilder();
        for (ExtendedMeasureProviderConfigurationUI ui : subsumedUIs) {
            String msg = ui.getErrorMessage();
            if (msg != null) {
                builder.append(msg);
            }
        }
        return builder.length() > 0 ? builder.toString() : null;
    }

    @Override
    public boolean isValid() {
        boolean result = true;
        for (ExtendedMeasureProviderConfigurationUI ui : subsumedUIs) {
            result = result && ui.isValid();
        }
        return result && super.isValid();
    }

    @Override
    public String getName() {
        return "Extended Measure Provider Configuration";
    }

    @Override
    public Control getControl() {
        return control;
    }
}
