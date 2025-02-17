package org.capgemini.Reflection.Intermediate_Level.Problem_7;


import java.lang.reflect.Field;

class Configuration {
    // Private static field
    private static String API_KEY = "ORIGINAL_KEY";

    // Getter for verification (not needed for Reflection)
    public static String getApiKey() {
        return API_KEY;
    }
}

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            // Get the Class object of Configuration
            Class<?> configClass = Configuration.class;

            // Access the private static field "API_KEY"
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Make the field accessible
            apiKeyField.setAccessible(true);

            // Modify the static field
            apiKeyField.set(null, "NEW_SECRET_KEY");  // 'null' because it's static

            // Print modified value
            System.out.println("Modified API_KEY: " + Configuration.getApiKey());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

