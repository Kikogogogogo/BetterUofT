package food;


import View.food.AddFood;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.food.ShowingFoodInputBoundary;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddFood {

    private AddFood addFood;

    @BeforeEach
    public void setUp() {
        // Initialize the AddFood instance before each test
        // Assuming foodInputBoundary is a mock or stub as needed
        ShowingFoodInputBoundary foodInputBoundary = null;
        addFood = new AddFood(foodInputBoundary);
    }

    @Test
    public void testAddFoodInitialization() {
        assertNotNull(addFood);
        // Add more assertions to test the initial state of the AddFood window
    }

    @Test
    public void testValidInput() {
        addFood.foodNameField.setText("Test Restaurant");
        addFood.foodPriceField.setText("10.0");
        addFood.foodratingField.setText("4.5");
        addFood.foodDescriptionField.setText("Delicious food");
        addFood.foodlocationFeild.setText("123 Test Street");

        // Trigger the actionPerformed method as if the user clicked the button
        addFood.openFood(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        // Assertions to check the expected behavior after valid inputs are given
        // This might include checking if a new food item was correctly added or if the window is disposed
    }

    @Test
    public void testInvalidPriceInput() {
        addFood.foodNameField.setText("Test Restaurant");
        addFood.foodPriceField.setText("invalid_price");
        addFood.foodratingField.setText("4.5");
        addFood.foodDescriptionField.setText("Delicious food");
        addFood.foodlocationFeild.setText("123 Test Street");

        // Trigger the actionPerformed method
        addFood.openFood(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        // Assertions to check if the proper error message is shown or the appropriate action is taken
    }

    @Test
    public void testInvalidRatingInput() {
        // Similar to testInvalidPriceInput, but test for invalid rating
    }

    // Other test methods as necessary
}
