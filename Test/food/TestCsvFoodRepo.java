package food;

import Entity.Food.Food;
import Data.Food.CsvFoodRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TestCsvFoodRepo {

    UUID uuid1 = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();
    UUID uuid3 = UUID.randomUUID();
    Food a = new Food("KFC", "123 ave", "bad",
            uuid1.toString(), "2", "30", 1, "[bad]");
    Food b = new Food("Subway", "11 st", "good",
            uuid2.toString(), "3", "15", 1, "[good]");
    Food c = new Food("Pizza Hot", "abc plaza", "not bad",
            uuid3.toString(), "4", "10", 1, "[not bad]");
    private CsvFoodRepo csvFoodRepo;
    private Path testFilePath;

    @BeforeEach
    void setUp() throws IOException {
        testFilePath = Files.createTempFile("test", ".csv");
        csvFoodRepo = new CsvFoodRepo(testFilePath.toString());
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(testFilePath);
    }

    @Test
    void getAllFoodsWithValidData() throws IOException {
        csvFoodRepo.save(a);
        csvFoodRepo.save(b);
        csvFoodRepo.save(c);

        List<Food> foods = csvFoodRepo.getAllFoods();
        assertEquals(3, foods.size());
    }

    @Test
    void getAllFoodsWithEmptyFile() throws IOException {
        // Leave the test CSV file empty

        List<Food> foods = csvFoodRepo.getAllFoods();
        assertTrue(foods.isEmpty());
    }

    @Test
    void getAllFoodsWithInvalidData() throws IOException {
        // Write invalid data to the test CSV file
        Files.writeString(testFilePath, "invalid data");

        List<Food> foods = csvFoodRepo.getAllFoods();
        assertTrue(foods.isEmpty());
    }

    @Test
    void testSaveAllFoods() throws IOException {
        ArrayList<Food> foodItems = new ArrayList<>();
        foodItems.add(a);
        foodItems.add(b);
        csvFoodRepo.emptyFoodFile();
        csvFoodRepo.saveAllFoods(foodItems);
        List<Food> foods = csvFoodRepo.getAllFoods();
        assertEquals(2, foods.size());
    }

    @Test
    void testEmptyFoodFile() throws IOException {
        csvFoodRepo.save(a);
        csvFoodRepo.save(b);
        csvFoodRepo.save(c);
        csvFoodRepo.emptyFoodFile();
        List<Food> foods = csvFoodRepo.getAllFoods();
        assertTrue(foods.isEmpty());
    }

    @Test
    void testDeleteFood() throws IOException {
        csvFoodRepo.save(a);
        csvFoodRepo.save(b);
        csvFoodRepo.save(c);
        csvFoodRepo.deleteFood("KFC");
        List<Food> foods = csvFoodRepo.getAllFoods();
        assertEquals(2, foods.size());
    }
}