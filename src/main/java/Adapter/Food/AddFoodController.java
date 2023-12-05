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

    CsvFoodRepo csvFoodRepo = new CsvFoodRepo("food.csv");

    public AddFoodController(FoodInputBoundary foodInputBoundary, ShowingFoodInputBoundary showingFoodInputBoundary) {
        this.foodInputBoundary = foodInputBoundary;
        this.showingFoodInputBoundary = showingFoodInputBoundary;
    }

//    public void execute(String name, String location, String description,
//                        String id, String rating, String price) {
//        Food food = check(name, price, rating);
//        CsvFoodRepo a = new CsvFoodRepo("food.csv");
//        if (food != null) {
//            food.addDescription(description);
//            return;
//        } else {
//
//            a.save(new Food(name, location, description, id, rating, price, 1));
//        }
//        showingFoodInputBoundary.showAllFoods();
//    }
//
//    public Food check(String name, String price, String rating) {
//        foodItems = CsvFoodRepo.getAllFoods();
//        for (Food food : foodItems) {
//            if (food.getName().equals(name)) {
//                double newRating = food.getRating() + Double.parseDouble(rating);
//                double newPrice = food.getPrice() + Double.parseDouble(price);
//                food.increaseRating(newRating);
//                food.increasePrice(newPrice);
//                System.out.println(food.getCount() + "bac");
//                food.increaseCount();
//                System.out.println(food.getCount());
//                CsvFoodRepo.deleteFood(food.getName());
//                CsvFoodRepo.saveAllFoods(foodItems);
//                return food;
//            }
//        }
//        return null;
//
//    }


    public void execute(String name, String location, String description,
                        String id, String rating, String price) {
        Food food = check(name);
        if (food == null){
            Food newfood = new Food(name, location, description, id, rating, price, 1);
            csvFoodRepo.save(newfood);
        } else {
            Food temp = food.clone();
            csvFoodRepo.deleteFood(food.getName());
            temp.increaseCount();
            temp.increaseRating(Double.parseDouble(rating));
            temp.increasePrice(Double.parseDouble(price));
            csvFoodRepo.save(temp);
        }
    }

    public Food check(String name){
        ArrayList<Food> exist = CsvFoodRepo.getAllFoods();
        for (Food food : exist) {
            if (food.getName().equals(name)) {
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
