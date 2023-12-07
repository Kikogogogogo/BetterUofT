package food;


import Entity.Food.Food;
import org.junit.jupiter.api.Test;
import use_case.food.AddFoodOutputData;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TestAddFoodOutputData {

    UUID uuid1 = UUID.randomUUID();
    Food a = new Food("KFC", "123 ave", "bad",
            uuid1.toString(), "2", "30", 1, "[bad]");

    @Test
    void testAddFoodOutputData() {
        AddFoodOutputData outputData = new AddFoodOutputData(a);


        assertEquals("KFC", outputData.getName());
        assertEquals("30.0", outputData.getPrice());
        assertEquals("bad", outputData.getDescription());
        assertEquals("2.0", outputData.getRating());
        assertEquals("123 ave", outputData.getLocation());
    }


}
