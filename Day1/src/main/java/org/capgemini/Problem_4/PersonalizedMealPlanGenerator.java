package org.capgemini.Problem_4;

import java.util.ArrayList;
import java.util.List;

// Define the MealPlan interface
interface MealPlan {
    String getMealDetails();
}

// Subclasses representing specific meal plans
class VegetarianMeal implements MealPlan {
    private String mainDish;
    private int calories;

    public VegetarianMeal(String mainDish, int calories) {
        this.mainDish = mainDish;
        this.calories = calories;
    }

    @Override
    public String getMealDetails() {
        return "Vegetarian Meal - Main Dish: " + mainDish + ", Calories: " + calories;
    }
}

class VeganMeal implements MealPlan {
    private String mainDish;
    private boolean glutenFree;

    public VeganMeal(String mainDish, boolean glutenFree) {
        this.mainDish = mainDish;
        this.glutenFree = glutenFree;
    }

    @Override
    public String getMealDetails() {
        return "Vegan Meal - Main Dish: " + mainDish + ", Gluten-Free: " + glutenFree;
    }
}

class KetoMeal implements MealPlan {
    private String mainDish;
    private int proteinContent;

    public KetoMeal(String mainDish, int proteinContent) {
        this.mainDish = mainDish;
        this.proteinContent = proteinContent;
    }

    @Override
    public String getMealDetails() {
        return "Keto Meal - Main Dish: " + mainDish + ", Protein: " + proteinContent + "g";
    }
}

class HighProteinMeal implements MealPlan {
    private String mainDish;
    private int proteinContent;
    private int calories;

    public HighProteinMeal(String mainDish, int proteinContent, int calories) {
        this.mainDish = mainDish;
        this.proteinContent = proteinContent;
        this.calories = calories;
    }

    @Override
    public String getMealDetails() {
        return "High-Protein Meal - Main Dish: " + mainDish + ", Protein: " + proteinContent + "g, Calories: " + calories;
    }
}

// Generic Meal class
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    @Override
    public String toString() {
        return mealPlan.getMealDetails();
    }
}

// Meal Plan Generator utility class
class MealPlanGenerator {
    // Generic method to generate a personalized meal plan
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        System.out.println("Validating meal plan...");
        // Add any validation logic here (e.g., check for dietary restrictions)
        System.out.println("Meal plan is valid!");
        return new Meal<>(mealPlan);
    }

    // Method to print a list of meal plans using wildcards
    public static void printMealPlans(List<? extends MealPlan> mealPlans) {
        for (MealPlan meal : mealPlans) {
            System.out.println(meal.getMealDetails());
        }
    }
}

// Main class to demonstrate the functionality
public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        // Create specific meal plans
        VegetarianMeal vegetarianMeal = new VegetarianMeal("Grilled Tofu Salad", 400);
        VeganMeal veganMeal = new VeganMeal("Quinoa Bowl", true);
        KetoMeal ketoMeal = new KetoMeal("Baked Salmon", 40);
        HighProteinMeal highProteinMeal = new HighProteinMeal("Chicken Breast", 50, 600);

        // Generate personalized meal plans
        Meal<VegetarianMeal> vegetarianMealPlan = MealPlanGenerator.generateMealPlan(vegetarianMeal);
        Meal<VeganMeal> veganMealPlan = MealPlanGenerator.generateMealPlan(veganMeal);
        Meal<KetoMeal> ketoMealPlan = MealPlanGenerator.generateMealPlan(ketoMeal);
        Meal<HighProteinMeal> highProteinMealPlan = MealPlanGenerator.generateMealPlan(highProteinMeal);

        // Print generated meal plans
        System.out.println("\nGenerated Meal Plans:");
        System.out.println(vegetarianMealPlan);
        System.out.println(veganMealPlan);
        System.out.println(ketoMealPlan);
        System.out.println(highProteinMealPlan);

        // Create a list of meal plans and print them using wildcards
        List<MealPlan> mealPlans = new ArrayList<>();
        mealPlans.add(vegetarianMeal);
        mealPlans.add(veganMeal);
        mealPlans.add(ketoMeal);
        mealPlans.add(highProteinMeal);

        System.out.println("\nMeal Plans List:");
        MealPlanGenerator.printMealPlans(mealPlans);
    }
}
