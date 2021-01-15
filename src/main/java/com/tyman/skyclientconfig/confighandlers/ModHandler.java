package com.tyman.skyclientconfig.confighandlers;

public abstract class ModHandler {
    /**
     * This will return the modid of this handler, mainly used for detecting if mods are loaded.
     * @return  The modid of the mod this handler is for
     */
    public abstract String getModid();

    /**
     * This is an optional method to override the default config prefix (the first part of a config query).
     * @return  The config prefix this handler should use
     */
    public String getConfigPrefix() {
        return this.getModid();
    }

    /**
     * Initializes the internals of the handler, to get it ready to be queried
     */
    public abstract void init();

    /**
     * Get a config property from this handler
     * @param property The name of the property to get
     * @return The value of the config property as an Object
     * @throws IllegalAccessException if the field is unable to be retrieved
     */
    public abstract Object getConfigProperty(String property) throws IllegalAccessException;

    /**
     * Sets a config property for this handler's mod
     * @param prop The property to set
     * @param value The value to set the property to
     * @throws IllegalAccessException if the field is unable to be set
     */
    public abstract void setConfigProperty(String prop, Object value) throws IllegalAccessException;
}
