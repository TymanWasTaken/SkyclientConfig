package com.tyman.skyclientconfig.utils;

import com.tyman.skyclientconfig.confighandlers.ModHandler;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    /**
     * Creates a HashMap object with the values given and returns it
     * @param values A list of arrays, the first value being the key
     *               and the second the value
     * @return The created HashMap
     */
    @SuppressWarnings("unchecked")
    public static Map<Class<? extends ModHandler>, String> createHandlerMap(Object[] ...values) {
        Map<Class<? extends ModHandler>,String> map = new HashMap<>();
        for (Object[] value : values) {
            map.put((Class<? extends ModHandler>) value[0], (String) value[1]);
        }
        return map;
    }
}
