package de.fzi.power.ui.adapters;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.palladiosimulator.edp2.datastream.configurable.IPropertyConfigurable;
import org.palladiosimulator.edp2.datastream.configurable.IPropertyListener;
import org.palladiosimulator.edp2.datastream.configurable.PropertyConfigurable;

/**
 * This class allows to combine the setting of multiple {@link IPropertyConfigurable} 
 * using one dynamic properties map.
 * 
 * Currently it is not supported for two nested {@link PropertyConfigurable} to
 * declare properties if the same name.
 * 
 * @author Sebastian Krach
 * 
 */
public class NestedPropertyConfigurableConfiguration extends PropertyConfigurable implements IPropertyListener {
    
    /** The configurables. */
    private Map<String, IPropertyConfigurable> configurables;

    /**
     * Instantiates a new nested property configurable configuration.
     *
     * @param the set of nested {@link IPropertyConfigurable}
     */
    public NestedPropertyConfigurableConfiguration(Set<? extends IPropertyConfigurable> configurables) {
        checkAndFillConfigurables(configurables);
    }

    /**
     * Checks for property duplicates and fills the configurables map
     *
     * @param configurables2 the set of {@link IPropertyConfigurable}s
     */
    private void checkAndFillConfigurables(Set<? extends IPropertyConfigurable> configurables2) {
        configurables = new HashMap<String, IPropertyConfigurable>();
        
        for (IPropertyConfigurable config : configurables2) {
            for (String key : config.getKeys()) {
                if (configurables.containsKey(key)) {
                    throw new IllegalArgumentException(
                            "NestedPropertyConfigurableConfiguration does not support nested "
                            + "configurables with duplicate keys");
                }
                configurables.put(key, config);
            }
            
            if (config instanceof PropertyConfigurable) {
                ((PropertyConfigurable) config).addObserver(this);
            }
        }
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.edp2.datastream.configurable.IPropertyConfigurable#getPropertyType(java.lang.String)
     */
    @Override
    public Class<?> getPropertyType(String key) {
        IPropertyConfigurable config = configurables.get(key);
        return config != null ? config.getPropertyType(key) : null;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.edp2.datastream.configurable.PropertyConfigurable#getDefaultConfiguration()
     */
    @Override
    public Map<String, Object> getDefaultConfiguration() {
        Map<String, Object> result = new HashMap<String, Object>();
        Set<IPropertyConfigurable> configSet = new HashSet<IPropertyConfigurable>();
        configSet.addAll(configurables.values());
        for (IPropertyConfigurable config : configSet) {
            result.putAll(config.getDefaultConfiguration());
        }
        return result;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.edp2.datastream.configurable.PropertyConfigurable#getKeys()
     */
    @Override
    public Set<String> getKeys() {
        if (configurables == null) return Collections.emptySet();
        
        return configurables.keySet();
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.edp2.datastream.configurable.PropertyConfigurable#getProperties()
     */
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> result = new HashMap<String, Object>();
        Set<IPropertyConfigurable> configSet = new HashSet<IPropertyConfigurable>();
        configSet.addAll(configurables.values());
        for (IPropertyConfigurable config : configSet) {
            result.putAll(config.getProperties());
        }
        return result;
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.edp2.datastream.configurable.PropertyConfigurable#setProperties(java.util.Map)
     */
    @Override
    public void setProperties(Map<String, Object> properties) {        
        Map<IPropertyConfigurable, Map<String, Object>> splittedProperties = new HashMap<IPropertyConfigurable, Map<String,Object>>();
        
        for (Entry<String, Object> entry : properties.entrySet()) {
            IPropertyConfigurable targetConfigurable = configurables.get(entry.getKey());
            
            if (targetConfigurable == null) {
                throw new IllegalArgumentException("Property identified by \"" + entry.getKey() + "\" does not exist");
            }
            
            Map<String, Object> nestedProperties = splittedProperties.get(targetConfigurable);
            if (nestedProperties == null) {
                nestedProperties = new HashMap<String, Object>();
                splittedProperties.put(targetConfigurable, nestedProperties);
            }
            
            nestedProperties.put(entry.getKey(), entry.getValue());
        }
        
        for (Entry<IPropertyConfigurable, Map<String, Object>> entry : splittedProperties.entrySet()) {
            entry.getKey().setProperties(entry.getValue());
        }
        
        super.getEventDispatcher().propertyChangeCompleted();
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.edp2.datastream.configurable.PropertyConfigurable#isPropertyNotSet(java.lang.String)
     */
    @Override
    public boolean isPropertyNotSet(String key) {
        IPropertyConfigurable config = configurables.get(key);
        if (config == null) {
            throw new IllegalArgumentException("Property identified by \"" + key + "\" does not exist");
        }
        return config.isPropertyNotSet(key);
    }

    /* (non-Javadoc)
     * @see org.palladiosimulator.edp2.datastream.configurable.PropertyConfigurable#unsetProperty(java.lang.String)
     */
    @Override
    public void unsetProperty(String key) {
        IPropertyConfigurable config = configurables.get(key);
        if (config == null) {
            throw new IllegalArgumentException("Property identified by \"" + key + "\" does not exist");
        }
        config.unsetProperty(key);
    }
    
    /* (non-Javadoc)
     * @see org.palladiosimulator.edp2.datastream.configurable.PropertyConfigurable#getAdapter(java.lang.Class)
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Object getAdapter(final Class adapter) {
        if (adapter.isInstance(this)) {
            return this;
        }
        return null;
    }
    
    /**
     * With the current implementation of this PropertyConfigurable it is only 
     * possible to be notified on changes applied to this nested configurable.
     *  
     * 
     * To be notified upon changes made to the nested properties direclty 
     * a listener has to be attached to the nested {@link PropertyConfigurable}. 
     */
    @Override
    public void addObserver(IPropertyListener observer) {
        // TODO Auto-generated method stub
        super.addObserver(observer);
    }
    
    @Override
    public void propertyChanged(String key, Object oldValue, Object newValue) {
        super.getEventDispatcher().propertyChanged(key, oldValue, newValue);
    }
    
    @Override
    public void propertyChangeCompleted() {
        //nothing to do here since the event is fired when all
        //nested properties are updated
    }

}
