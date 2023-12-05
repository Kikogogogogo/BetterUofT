package use_case.food;

import Data.CsvFoodRepo;
import Entity.Food;

import java.util.ArrayList;

import View.food.FoodApp;
import use_case.food.QuickSort;

public class SortUsecase {
    private static ArrayList<Food> foodItems = new ArrayList<>();
    private FoodApp foodapp;

    public SortUsecase(FoodApp foodapp) {
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
