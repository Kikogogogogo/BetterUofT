package View.food;

import Adapter.Food.AddFoodPresenter;
import Data.CsvFoodRepo;
import Data.FoodDataAccess;
import Data.FoodDataAccessObject;
import Entity.Food;
import Adapter.Food.AddFoodController;
import use_case.food.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class AddFood extends JFrame{

    private final AddFoodController AddFoodController;
    private final FoodInputBoundary FoodInputUsecase;
    private final ShowingFoodOutputBoundary addFoodPresenter;
    private final FoodDataAccess FoodDataAccess;
    public JTextField foodNameField;
    public JTextField foodPriceField;
    public JTextField foodDescriptionField;
    public JTextField foodratingField;
    public JTextField foodlocationFeild;

    public String name;
    public String price;
    public String description;
    public String rating;
    public String location;
    public UUID id = UUID.randomUUID();




    public AddFood(ShowingFoodInputBoundary foodInputBoundary){
        FoodDataAccess = new FoodDataAccessObject("food.csv");
        addFoodPresenter = new AddFoodPresenter(this);
        FoodInputUsecase = new FoodInputUsecase(FoodDataAccess, addFoodPresenter);
        AddFoodController = new AddFoodController(FoodInputUsecase);
        setTitle("Add Food");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel foodName = new JLabel("New restaurant");
        foodNameField = new JTextField();
        add(foodName);
        add(foodNameField);

        JLabel foodPrice = new JLabel("restaurant Price");
        foodPriceField = new JTextField();
        add(foodPrice);
        add(foodPriceField);

        JLabel foodDescription = new JLabel("restaurant Description");
        foodDescriptionField = new JTextField();
        add(foodDescription);
        add(foodDescriptionField);

        JLabel foodrating = new JLabel("restaurant rating");
        foodratingField = new JTextField();
        add(foodrating);
        add(foodratingField);

        JLabel foodlocation = new JLabel("restaurant address");
        foodlocationFeild = new JTextField();
        add(foodlocation);
        add(foodlocationFeild);

        JButton addButton = new JButton("Add");
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = foodNameField.getText();
                price = foodPriceField.getText();
                description = foodDescriptionField.getText();
                rating = foodratingField.getText();
                location = foodlocationFeild.getText();
                AddFoodController.execute(name, location, description, id.toString(), rating, price);
            }
        });

    }
    public static void main(String[] args) {
    }
}
