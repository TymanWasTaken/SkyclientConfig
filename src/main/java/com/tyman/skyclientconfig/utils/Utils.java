package com.tyman.skyclientconfig.utils;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    /**
     * Creates a HashMap object with the values given and returns it
     * @param values A list of arrays, the first value being the key
     *               and the second the value
     * @return The created HashMap
     */
    public static Map<String, String> createMap(String[] ...values) {
        Map<String,String> map = new HashMap<>();
        for (String[] value : values) {
            map.put(value[0], value[1]);
        }
        return map;
    }
}
