package com.bridgelabz;

interface MealPlan {
    String getPlanName();
}

class VegetarianMeal implements MealPlan {
    public String getPlanName() { return "Vegetarian Meal Plan"; }
}

class VeganMeal implements MealPlan {
    public String getPlanName() { return "Vegan Meal Plan"; }
}

class KetoMeal implements MealPlan {
    public String getPlanName() { return "Keto Meal Plan"; }
}

class Meal<T extends MealPlan> {
    private T plan;
    Meal(T plan) { this.plan = plan; }

    public void showPlan() {
        System.out.println("Selected: " + plan.getPlanName());
    }
}

class MealPlanner {
    public static <T extends MealPlan> void generatePlan(T plan) {
        System.out.println("Generated plan: " + plan.getPlanName());
    }
}

public class Personalized_MealPlanner {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        vegMeal.showPlan();
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        veganMeal.showPlan();
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        ketoMeal.showPlan();
        System.out.println();
        MealPlanner.generatePlan(new VegetarianMeal());
        MealPlanner.generatePlan(new VeganMeal());
        MealPlanner.generatePlan(new KetoMeal());
        System.out.println("Meal plans generated successfully!");
    }
}