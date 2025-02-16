package org.capgemini.Reflection.Advance_Level.Problem_9;

import java.lang.reflect.Field;
import java.util.StringJoiner;

class JsonConverter {
    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }

        Class<?> clazz = obj.getClass();
        StringJoiner json = new StringJoiner(", ", "{", "}");

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true); // Allow access to private fields
            try {
                Object value = field.get(obj);
                json.add("\"" + field.getName() + "\": " + formatValue(value));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    // Helper method to format values as JSON-like representation
    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "\"" + value + "\"";
        }
        return value.toString(); // Handles numbers, booleans, etc.
    }
}

