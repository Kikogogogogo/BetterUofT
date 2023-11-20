package Data;

<<<<<<< HEAD
import Entity.Restaurant;
=======
import Entity.Food;
>>>>>>> main

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFoodRepo implements FoodRepo {
    private Path path;

    public CsvFoodRepo(String path) {
        this.path = Paths.get(path);
    }

<<<<<<< HEAD
    @Override
    public void save(Restaurant food) {
=======
    public void save(Food food) {
>>>>>>> main
        String name = food.getName();
        String location = food.getLocation();
        String description = food.getDescription();
        String id = food.getId();
<<<<<<< HEAD
        double rating = food.getRating();
        String price = food.getPrice();
=======
        int rating = food.getRating();
        int price = food.getPrice();
>>>>>>> main
        String line = String.format("%s,%s,%s,%s,%d,%d\n", name, location, description, id, rating, price);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    public List<Restaurant> getAllFoods() {
        List<Restaurant> foods = new ArrayList<>();
=======
    public List<Food> getAllFoods() {
        List<Food> foods = new ArrayList<>();
>>>>>>> main
        if (!Files.exists(path)) {
            return foods;
        }

        return foods;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> main
