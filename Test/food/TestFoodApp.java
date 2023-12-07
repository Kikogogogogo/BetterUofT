package View.food;
import Entity.Food.Food;

import Entity.Food.Food;
import org.apache.commons.codec.binary.BaseNCodec;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFoodApp {

    private FoodApp foodApp;
    UUID uuid1 = UUID.randomUUID();
    Food food = new Food("KFC", "123 ave", "bad",
            uuid1.toString(), "2", "30", 1, "[bad]");


    @BeforeEach
    public void setUp() {
        foodApp = new FoodApp();
    }

    @Test
    public void testFoodAppInitialization() {
        assertNotNull(foodApp);
        assertEquals("Food", foodApp.getTitle());
        assertEquals(800, foodApp.getSize().width);
        assertEquals(600, foodApp.getSize().height);
    }

    @Test
    public void testCreateFoodPanel() {
        JPanel panel = foodApp.createFoodPanel(food);
        assertNotNull(panel);
    }

    @Test
    public void testSortFoodItems() {
        foodApp.sortFoodItems(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
    }

    @Test
    public void testOpenAdd() {
        foodApp.openAdd(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
    }

    @Test
    public void testopenFoodDetails() {
        foodApp.openFoodDetails(food);
    }
}
