package Adapter.Food;

import Data.CsvFoodRepo;
import Entity.Food;
import use_case.food.FoodInputBoundary;
import use_case.food.ShowingFoodInputBoundary;

import javax.swing.*;
import java.util.ArrayList;

public class AddFoodController {
    private final FoodInputBoundary foodInputBoundary;
    private final ShowingFoodInputBoundary showingFoodInputBoundary;
    private static ArrayList<Food> foodItems = new ArrayList<>();

    public AddFoodController(FoodInputBoundary foodInputBoundary, ShowingFoodInputBoundary showingFoodInputBoundary) {
        this.foodInputBoundary = foodInputBoundary;
        this.showingFoodInputBoundary = showingFoodInputBoundary;
    }

    public void execute(String name, String location, String description, String id, String rating, String price) {
        Food food = check(name);
        if (food != null) {
            System.out.println(food.getRating());
            System.out.println(food.getCount());
            System.out.println(Double.parseDouble(rating));
            System.out.println(food.getRating() + Double.parseDouble(rating));
            System.out.println((food.getRating() + Double.parseDouble(rating)) / food.getCount());
            double newRating = (food.getRating() + Double.parseDouble(rating)) / food.getCount();
            double newPrice = (food.getPrice() + Double.parseDouble(price)) / food.getCount();
            delete(name);
            foodInputBoundary.createFood(name, location, description, id, Double.toString(newRating), Double.toString(newPrice));
            return;
        }
        foodInputBoundary.createFood(name, location, description, id, rating, price);
        showingFoodInputBoundary.showAllFoods();
    }

    public Food check(String name) {
        foodItems = CsvFoodRepo.getAllFoods();
        for (Food food : foodItems) {
            if (food.getName().equals(name)) {
                food.increaseCount();
                return food;
            }
        }
        return null;

    }

    public void delete(String name) {
        foodItems = CsvFoodRepo.getAllFoods();
        for (Food food : foodItems) {
            if (food.getName().equals(name)) {
                foodItems.remove(food);
                break;
            }
        }
        CsvFoodRepo.emptyFoodFile();
        CsvFoodRepo.saveAllFoods(foodItems);
        showingFoodInputBoundary.showAllFoods();
    }


}