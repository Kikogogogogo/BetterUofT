package Adapter.Food;

import View.food.AddFood;
import use_case.food.AddFoodOutputBoundary;
import use_case.food.AddFoodOutputData;
import use_case.food.ShowingFoodOutputBoundary;

import javax.swing.*;

public class AddFoodPresenter implements AddFoodOutputBoundary, ShowingFoodOutputBoundary {
    final AddFood view;
    public AddFoodPresenter(AddFood view) {
        this.view = view;
    }

    @Override
    public void prepareSuccessView(AddFoodOutputData addFoodOutputData) {
        JOptionPane.showMessageDialog(null, "Restaurant added successfully");

    }

    @Override
    public void showAllFoods(Object all) {

    }
}


