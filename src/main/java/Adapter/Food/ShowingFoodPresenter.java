package Adapter.Food;

import View.food.FoodApp;
import use_case.food.ShowingFoodOutputBoundary;

public class ShowingFoodPresenter implements ShowingFoodOutputBoundary {
    final FoodApp view;
    public ShowingFoodPresenter(FoodApp view) {
        this.view = view;
    }

    @Override
    public void showAllFoods() {

    }
}
