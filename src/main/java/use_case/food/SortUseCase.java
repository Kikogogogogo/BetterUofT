package use_case.food;

import Data.Food.CsvFoodRepo;

import java.util.ArrayList;

import Entity.Food.Food;
import View.food.FoodApp;
import use_case.food.QuickSort;

public class SortUseCase {
    private static ArrayList<Food> foodItems = new ArrayList<>();
    private FoodApp foodapp;

    public SortUseCase(FoodApp foodapp) {
        this.foodapp = foodapp;
    }

    public void sortFood() {
        CsvFoodRepo csvFoodRepo = new CsvFoodRepo("food.csv");
        foodItems = csvFoodRepo.getAllFoods();
        QuickSort quickSort = new QuickSort(foodItems, 0, foodItems.size() - 1);
        foodItems = quickSort.run();
        CsvFoodRepo.emptyFoodFile();
        CsvFoodRepo.saveAllFoods(foodItems);
        foodapp.dispose();
        FoodApp foodApp = new FoodApp();
        foodApp.setVisible(true);
    }

}
