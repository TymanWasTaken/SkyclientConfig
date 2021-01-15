package com.tyman.skyclientconfig.confighandlers;

import club.sk1er.patcher.Patcher;
import club.sk1er.patcher.config.PatcherConfig;

import club.sk1er.vigilance.data.Property;

import java.lang.reflect.Field;
import java.util.HashMap;

public class PatcherHandler extends ModHandler {

    public final HashMap<String, Field> configFields = new HashMap<>();

    public void init() {
        PatcherConfig config = Patcher.instance.getPatcherConfig();
        Class<? extends PatcherConfig> clazz = config.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.isAnnotationPresent(Property.class)) {
                    configFields.put(field.getName(), field);
                }
            } catch (Exception e) {
                System.out.println("Unable to load field PatcherConfig." + field.getName() + " with reflection.");
            }
        }
    }

    public String getModid() {
        return "patcher";
    }
    public Object getConfigProperty(String prop) throws IllegalAccessException {
        Field field = configFields.get(prop);
        if (field != null) {
            return field.get(null);
        } else {
            throw new IllegalArgumentException("Could not find patcher config field");
        }
    }
    public void setConfigProperty(String prop, Object value) throws ClassCastException, IllegalAccessException {
        Field field = configFields.get(prop);
        if (field != null) {
            field.set(null, field.getType().cast(value));
        } else {
            throw new IllegalArgumentException("Could not find patcher config field");
        }
    }
}
