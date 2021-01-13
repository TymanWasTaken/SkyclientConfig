package com.tyman.skyclientconfig.confighandlers;

import club.sk1er.patcher.Patcher;
import club.sk1er.patcher.config.PatcherConfig;

import club.sk1er.vigilance.data.Property;

import java.lang.reflect.Field;
import java.util.HashMap;

public class PatcherHandler extends ModHandler {

    private final HashMap<String, Field> configFields = new HashMap<>();

    public PatcherHandler() {
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
        return configFields.get(prop).get(null);
    }
}
