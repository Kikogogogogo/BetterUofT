package View.food;

import javax.swing.*;
import java.awt.event.ActionEvent;

import Data.CsvFoodRepo;
import Entity.Food;

public class AddFood extends JFrame{

    public AddFood(){
        setTitle("Add Food");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel foodName = new JLabel("New restaurant");
        JTextField foodNameField = new JTextField();
        JLabel foodPrice = new JLabel("restaurant Price");
        JTextField foodPriceField = new JTextField();
        JLabel foodDescription = new JLabel("restaurant Description");
        JTextField foodDescriptionField = new JTextField();
        JLabel foodrating = new JLabel("restaurant rating");
        JTextField foodratingField = new JTextField();
        JLabel foodlocation = new JLabel("restaurant address");
        JTextField foodlocationFeild = new JTextField();

        JButton addButton = new JButton("Add");
        add(foodName);
        add(foodNameField);
        add(foodPrice);
        add(foodPriceField);
        add(foodDescription);
        add(foodDescriptionField);
        add(foodlocation);
        add(foodratingField);
        add(foodrating);
        add(foodlocationFeild);
        add(addButton);

        addButton.addActionListener((ActionEvent event) -> {
            String name = foodNameField.getText();
            String price = foodPriceField.getText();
            String description = foodDescriptionField.getText();
            String location = foodlocationFeild.getText();
            String rating = foodratingField.getText();

            Food restaurant = new Food(name, location, description, "id", rating, price);
            CsvFoodRepo csvFoodRepo = new CsvFoodRepo("food.csv");
            csvFoodRepo.save(restaurant);

            JOptionPane.showMessageDialog(this, "Restaurant added successfully");


        });

    }

    private static void openFood(ActionEvent event){
        SwingUtilities.invokeLater(() -> {
            AddFood addFood = new AddFood();
            addFood.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddFood addFood = new AddFood();
            addFood.setVisible(true);
        });
    }
}
