package View.food;

<<<<<<< HEAD
import javax.swing.*;
import java.awt.event.ActionEvent;

public class FoodApp extends JFrame{
    public FoodApp(){
        setTitle("Food");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JButton sortButton = new JButton("Sort");
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this::openAdd);

        add(sortButton);
        add(addButton);
    }

    private void openAdd(ActionEvent event){
        SwingUtilities.invokeLater(() -> {
            AddFood addFood = new AddFood();
            addFood.setVisible(true);
        });
=======
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
>>>>>>> main
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FoodApp foodApp = new FoodApp();
            foodApp.setVisible(true);
        });
    }
}
