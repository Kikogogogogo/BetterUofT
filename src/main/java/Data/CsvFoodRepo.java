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

    @Override
    public void save(Food food) {
        String name = food.getName();
        String location = food.getLocation();
        String description = food.getDescription();
        String id = food.getId();
        String rating = food.getRatings();
        String price = food.getPrices();
        String lines = name + ", " + location + ", " + description + ", " + id + ", " + rating + ", " + price + "\n";
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Food> getAllFoods() {
        ArrayList<Food> foodItems = new ArrayList<>();
        if (!Files.exists(path)) {
            return foodItems;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length >= 6) {
                    String name = parts[0];
                    String location = parts[4];
                    String description = parts[2];
                    String id = parts[3];
                    String rating = parts[1];
                    String price = parts[5];
                    Food food = new Food(name, location, description, id, rating, price);
                    foodItems.add(food);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foodItems;
    }
}

