package View.food;

import Data.CsvFoodRepo;
import Data.FoodRepo;
import Data.PostRepo;

import javax.swing.*;
import java.awt.*;

public class FoodApp {
    public FoodApp() {
        FoodRepo foodRepo = new CsvFoodRepo("food.csv");
        FoodUsecase foodUsecase = new FoodUsecase(foodRepo);
        JFrame frame = new JFrame("Food");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FoodApp foodApp = new FoodApp();
            foodApp.setVisible(true);
        });
    }
}
