package com.tyman.skyclientconfig.confighandlers;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class DSMHandler extends ModHandler {
    @Override
    public String getModid() {
        return "Danker's Skyblock Mod";
    }

    @Override
    public String getConfigPrefix() {
        return "dsm";
    }

    @Override
    public void init() {
        throw new NotImplementedException();
    }

    @Override
    public Object getConfigProperty(String property) {
        return null;
    }

    @Override
    public void setConfigProperty(String prop, Object value) {

    }
}
