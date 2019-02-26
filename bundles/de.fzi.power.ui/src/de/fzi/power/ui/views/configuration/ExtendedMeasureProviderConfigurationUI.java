package de.fzi.power.ui.views.configuration;

import java.util.Map;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public abstract class ExtendedMeasureProviderConfigurationUI {
    
    /**
     * Creates the top level control for this properties
     * tab under the given parent composite.  This method is called once on
     * tab creation.
     *
     * @param parent the parent composite
     */
    public abstract void createControl(Composite parent);
    
    /**
     * Return the top level control. {@code createControl} has to be executed first.
     * 
     * @return the top level control
     */
    public abstract Control getControl();


    /**
     * Initializes this tab's controls with values from the given
     * properties map. This method is called when
     * a configuration is selected to view or edit, after this
     * tab's control has been created.
     * 
     * @param configuration the properties
     */
    public abstract void initializeFrom(Map<String, Object> configuration);     
    
    
    /**
     * Copies values from this tab into the given 
     * properties map.
     * 
     * @param configuration the properties
     */
    public abstract void performApply(Map<String, Object> configuration);
    
    /**
     * Returns the current error message for this tab.
     * May be <code>null</code> to indicate no error message.
     * 
     * @return the error message, or <code>null</code> if none
     */
    public abstract String getErrorMessage();
        
    /**
     * Returns whether this tab is in a valid state.
     *
     * @return whether this tab is in a valid state
     */
    public boolean isValid() {
        return true;
    }
    
    
    /**
     * Returns the name of this tab.
     * 
     * @return the name of this tab
     */
    public abstract String getName();

}
