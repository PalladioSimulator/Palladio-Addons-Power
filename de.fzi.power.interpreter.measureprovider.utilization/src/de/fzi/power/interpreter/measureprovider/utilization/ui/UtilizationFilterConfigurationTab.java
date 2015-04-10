package de.fzi.power.interpreter.measureprovider.utilization.ui;

import java.util.Map;
import java.util.Vector;

import javax.measure.Measure;
import javax.measure.MeasureFormat;
import javax.measure.quantity.Duration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.jscience.physics.amount.Amount;
import org.palladiosimulator.commons.datastructureutils.MapHelper;
import org.palladiosimulator.experimentanalysis.utilizationfilter.UtilizationFilterConfiguration;

import de.fzi.power.ui.views.configuration.ExtendedMeasureProviderConfigurationUI;

public class UtilizationFilterConfigurationTab extends ExtendedMeasureProviderConfigurationUI {
    
    private Control control = null;
    private Vector<String> errorMessages;
    
    private Text windowLengthText;
    private Text windowSizeText;

    @Override
    public void createControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        control = composite;
        composite.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
        composite.setLayout(new GridLayout(2, false));
        windowLengthText = new Text(composite, SWT.BORDER); 
        windowLengthText.setToolTipText("Defines the window length over which utilization is determined with a time unit that needs to be specified.");
        
        Label labelLength = new Label(composite, SWT.NONE);
        labelLength.setText("Sliding Window Length");
        
        windowSizeText = new Text(composite, SWT.BORDER);
        windowSizeText.setToolTipText("Defines the sliding window step size over which utilization is determined with a time unit that needs to be specified.");
        
        Label labelSteps = new Label(composite, SWT.NONE);
        labelSteps.setText("Sliding Window Step Size");
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initializeFrom(Map<String, Object> configuration) {
        if (configuration.containsKey(UtilizationFilterConfiguration.WINDOW_INCREMENT_KEY)) {
            Measure<Double, Duration> incrementMeasure = 
                    MapHelper.getValue(configuration, 
                    UtilizationFilterConfiguration.WINDOW_INCREMENT_KEY,
                    Measure.class);
            windowSizeText.setText(MeasureFormat.getInstance().format(incrementMeasure));
        }
        
        if (configuration.containsKey(UtilizationFilterConfiguration.WINDOW_LENGTH_KEY)) {
            
            Measure<Double, Duration> lengthMeasure = 
                    MapHelper.getValue(configuration, 
                    UtilizationFilterConfiguration.WINDOW_LENGTH_KEY,
                    Measure.class);
            windowLengthText.setText(MeasureFormat.getInstance().format(lengthMeasure));
        }
    }

    @Override
    public void performApply(Map<String, Object> configuration) {
        Amount<Duration> windowLength = getWindowLength();
        Measure<Double, Duration> lengthMeasure = 
                Measure.valueOf(windowLength.getEstimatedValue(), 
                        windowLength.getUnit());
        Amount<Duration> windowSize = getWindowSize();
        Measure<Double, Duration> sizeMeasure = 
                Measure.valueOf(windowSize.getEstimatedValue(), 
                        windowSize.getUnit());
        
        configuration.put(
                UtilizationFilterConfiguration.WINDOW_INCREMENT_KEY, sizeMeasure);
        configuration.put(
                UtilizationFilterConfiguration.WINDOW_LENGTH_KEY, lengthMeasure);
    }

    @Override
    public String getErrorMessage() {
        if (errorMessages.size() == 0) return null;
        
        StringBuilder builder = new StringBuilder();
        for (String s : errorMessages) {
            builder.append(s);
            builder.append("\n");
        }
        return builder.toString();
    }

    @Override
    public boolean isValid() {
        errorMessages = new Vector<String>();
        boolean result = true;
        
        Amount<Duration> windowLength = getWindowLength();
        if (windowLength == null) {
            errorMessages.add(
                    "The window length must be set as an amount of time with its unit, e.g. '10s'");
            result = false;
        } else if (windowLength.getEstimatedValue() < 0) {
            errorMessages.add(
                    "The window length must be positive, e.g. '10s'");
            result = false;
        }
          
        Amount<Duration> windowSize = getWindowSize();
        if (windowSize == null) {
            errorMessages.add(
                    "The window increment must be set as an amount of time with its unit, e.g. '10s'");
            result = false;
        } else if (windowSize.getEstimatedValue() < 0) {
            errorMessages.add(
                    "The window increment must be positive, e.g. '10s'");
            result = false;
        }
        
        return result && super.isValid();
    }

    @Override
    public String getName() {
        return "Utilization Filter";
    }

    
    @SuppressWarnings("unchecked")
    protected Amount<Duration> getWindowSize() {
        Amount<Duration> windowSize = null;
        try {
            Amount<?> input = Amount.valueOf(windowSizeText.getText());
            windowSize = (Amount<Duration>) input;
        } catch(ClassCastException e) {
            // TODO
        } catch(NumberFormatException e) {
        } catch(StringIndexOutOfBoundsException e) { // Fix for JUnit AmountFormat bug
        }
        return windowSize;
    }
    
    @SuppressWarnings("unchecked")
    protected Amount<Duration> getWindowLength() {
        Amount<Duration> windowLength = null;
        try {
            Amount<?> input = Amount.valueOf(windowLengthText.getText());
            windowLength = (Amount<Duration>) input;
        } catch(ClassCastException e) {
            // TODO
        } catch(NumberFormatException e) {
        } catch(StringIndexOutOfBoundsException e) { // Fix for JUnit AmountFormat bug
        }
        return windowLength;
    }

    @Override
    public Control getControl() {
        return control;
    }
    

}
