package Data;

import Entity.Food;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFoodRepo implements FoodRepo {
    private Path path;

    public CsvFoodRepo(String path) {
        this.path = Paths.get(path);
    }

    public void save(Food food) {
        String name = food.getName();
        String location = food.getLocation();
        String description = food.getDescription();
        String id = food.getId();
        int rating = food.getRating();
        int price = food.getPrice();
        String line = String.format("%s,%s,%s,%s,%d,%d\n", name, location, description, id, rating, price);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Food> getAllFoods() {
        List<Food> foods = new ArrayList<>();
        if (!Files.exists(path)) {
            return foods;
        }

        return foods;
    }
}
