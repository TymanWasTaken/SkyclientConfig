package com.tyman.skyclientconfig;

import com.tyman.skyclientconfig.confighandlers.ModHandler;

public class BaseHandler {
    /**
     * Search the handlers and get the config value for the correct mod
     * @param prop The property to get, must be in format "configPrefix.property"
     * @return The retrieved object
     * @throws IllegalAccessException if the field is unable to be retrieved
     */
    public static Object getConfigProp(String prop) throws IllegalAccessException {
        String[] splitStr = prop.split("\\.");
        ModHandler foundHandler = SkyclientConfig.INSTANCE.configHandlers.get(splitStr[0]);
        if (foundHandler == null) {
            throw new IllegalArgumentException("Could not find handler for id " + splitStr[0]);
        }
        return foundHandler.getConfigProperty(splitStr[1]);
    }

    /**
     * Search the handlers and set the config value for the correct mod
     * @param prop The property to set, must be in format "configPrefix.property"
     * @param value The value to set it to
     * @throws IllegalAccessException if the field is unable to be set
     */
    public static void setConfigProp(String prop, Object value) throws IllegalAccessException {
        String[] splitStr = prop.split("\\.");
        ModHandler foundHandler = SkyclientConfig.INSTANCE.configHandlers.get(splitStr[0]);
        if (foundHandler == null) {
            throw new IllegalArgumentException("Could not find handler for id " + splitStr[0]);
        }
        foundHandler.setConfigProperty(splitStr[1], value);
    }
}
