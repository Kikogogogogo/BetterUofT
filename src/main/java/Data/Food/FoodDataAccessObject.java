package Data.Food;


import Entity.Food.Food;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FoodDataAccessObject implements FoodDataAccess {
    public String name;
    public String location;
    public String description;
    public String id;
    public String rating;
    public String price;
    private final String path;

    public FoodDataAccessObject(String path) {
        this.path = path;
    }

    @Override
    public void save(Food food) {
        name = food.getName();
        location = food.getLocation();
        description = food.getDescription();
        id = food.getId();
        rating = food.getRatings();
        price = food.getPrices();

        String lines = name + ", " + location + ", " + description + ", " + id + ", " + rating + ", " + price + "\n";
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Food> getFoods() {
        return null;
    }

    @Override
    public Object getAll() {
        return null;
    }
}
