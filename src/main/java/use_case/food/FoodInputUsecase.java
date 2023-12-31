package use_case.food;


import Data.Food.FoodDataAccess;
import Entity.Food.Food;

public class FoodInputUsecase implements FoodInputBoundary{

    private final FoodDataAccess foodDataAccess;
    private final ShowingFoodOutputBoundary foodOutputBoundary;

    public FoodInputUsecase(FoodDataAccess foodDataAccess, ShowingFoodOutputBoundary foodOutputBoundary) {
        this.foodDataAccess = foodDataAccess;
        this.foodOutputBoundary = foodOutputBoundary;
    }

    @Override
    public void createFood(String name, String location, String description, String id, String rating, String price) {
        foodDataAccess.save(new Food(name, location, description, id, rating, price, 1));
    }
}
