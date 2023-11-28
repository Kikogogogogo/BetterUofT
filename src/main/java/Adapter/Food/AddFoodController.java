package Adapter.Food;

import use_case.food.FoodInputBoundary;

public class AddFoodController {
    private final FoodInputBoundary foodInputBoundary;

    public AddFoodController(FoodInputBoundary foodInputBoundary) {
        this.foodInputBoundary = foodInputBoundary;
    }

    public void execute(String name, String location, String description, String id, String rating, String price) {
        foodInputBoundary.createFood(name, location, description, id, rating, price);
    }
}
