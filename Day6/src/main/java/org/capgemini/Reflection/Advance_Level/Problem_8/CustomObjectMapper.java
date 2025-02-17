package org.capgemini.Reflection.Advance_Level.Problem_8;

import java.lang.reflect.Field;
import java.util.Map;

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the given class
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Iterate over each property in the map
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    // Get the field from the class
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true); // Make the field accessible

                    // Convert value to the correct type
                    Object convertedValue = convertType(field.getType(), fieldValue);

                    // Set the field value
                    field.set(instance, convertedValue);

                } catch (NoSuchFieldException | IllegalArgumentException e) {
                    System.out.println("Skipping field: " + fieldName + " (Not Found or Incompatible Type)");
                }
            }
            return instance;

        } catch (Exception e) {
            throw new RuntimeException("Failed to map object: " + e.getMessage(), e);
        }
    }

    // Helper method to convert values to the correct type
    private static Object convertType(Class<?> targetType, Object value) {
        if (value == null) {
            return null;
        }
        if (targetType.isAssignableFrom(value.getClass())) {
            return value;
        }
        if (targetType == int.class || targetType == Integer.class) {
            return Integer.parseInt(value.toString());
        }
        if (targetType == double.class || targetType == Double.class) {
            return Double.parseDouble(value.toString());
        }
        if (targetType == boolean.class || targetType == Boolean.class) {
            return Boolean.parseBoolean(value.toString());
        }
        if (targetType == String.class) {
            return value.toString();
        }
        throw new IllegalArgumentException("Unsupported type conversion: " + targetType.getName());
    }
}

