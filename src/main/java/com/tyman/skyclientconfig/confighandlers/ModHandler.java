package com.tyman.skyclientconfig.confighandlers;

public abstract class ModHandler {

    public abstract String getModid();
    public abstract Object getConfigProperty(String property) throws IllegalAccessException;
}
