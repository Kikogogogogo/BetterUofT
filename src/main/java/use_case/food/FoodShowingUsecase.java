package use_case.food;

import Data.FoodDataAccess;

public class FoodShowingUsecase implements ShowingFoodInputBoundary{
    private FoodDataAccess foodDataAccess;
    private ShowingFoodOutputBoundary showingFoodPresenter;
    public FoodShowingUsecase(FoodDataAccess foodDataAccess, ShowingFoodOutputBoundary showingFoodPresenter) {
        this.foodDataAccess = foodDataAccess;
        this.showingFoodPresenter = showingFoodPresenter;
    }

    @Override
    public void showAllFoods() {
        showingFoodPresenter.showAllFoods(foodDataAccess.getAll());
    }
}
