package com.tyman.skyclientconfig.confighandlers;

import me.Danker.handlers.ConfigHandler;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Property;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DSMHandler extends ModHandler {

    public Object parseProp(Property prop) {
        Object value = null;
        switch (prop.getType()) {
            case STRING:
            case MOD_ID: {
                value = prop.getString();
                break;
            }
            case INTEGER: {
                value = prop.getInt();
                break;
            }
            case BOOLEAN: {
                value = prop.getBoolean();
                break;
            }
            case DOUBLE: {
                value = prop.getDouble();
                break;
            }
            case COLOR: {
                throw new IllegalArgumentException("Unable to do colors in dsm handler :/");
            }
        }
        return value;
    }

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
        // pass, not needed for dsm
    }

    @Override
    public Object getConfigProperty(String property) {
        List<String> split = Arrays.asList(property.split("\\."));
        if (split.size() != 2) {
            throw new IllegalArgumentException("DSM config should take one category a property.");
        }
        Property prop = ConfigHandler.config.get(split.get(0), split.get(1), (String) null);
        if (prop == null) {
            throw new IllegalArgumentException("Could not find config value");
        }
        return parseProp(prop);
    }

    @Override
    public void setConfigProperty(String prop, Object value) {
        // not made yet
    }
}
