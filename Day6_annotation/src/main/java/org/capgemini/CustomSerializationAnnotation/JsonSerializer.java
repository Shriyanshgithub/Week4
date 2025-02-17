package org.capgemini.CustomSerializationAnnotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializer {

    public static String serialize(Object obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
        Map<String, String> jsonElements = new HashMap<>();

        for (Field field : objClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name();
                Object value = field.get(obj);
                jsonElements.put(jsonKey, value.toString());
            }
        }

        StringBuilder jsonString = new StringBuilder();
        jsonString.append("{");
        for (Map.Entry<String, String> entry : jsonElements.entrySet()) {
            jsonString.append("\"").append(entry.getKey()).append("\": \"")
                    .append(entry.getValue()).append("\", ");
        }
        // Remove the trailing comma and space
        if (jsonString.length() > 1) {
            jsonString.setLength(jsonString.length() - 2);
        }
        jsonString.append("}");
        return jsonString.toString();
    }
}

