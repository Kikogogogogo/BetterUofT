package Data.Food;

import Entity.Food.Food;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class CsvFoodRepo implements FoodRepo {
    private static Path path;


    public CsvFoodRepo(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public void save(Food food) {
        String name = food.getName();
        String location = food.getLocation();
        String description = food.getDescription();
        String id = food.getId();
        String rating = String.valueOf(food.getRating());
        String price = String.valueOf(food.getPrice());
        String comments = food.getComments();
        int count = food.getCount();
        String lines = name + "," + location + "," + description + "," + id + "," + rating + "," + price
                + ", " + count + "," + comments + "\n";
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            writer.write(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Food> getAllFoods() {
        ArrayList<Food> foodItems = new ArrayList<>();
        if (!Files.exists(path)) {
            return foodItems;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length >= 8) {
                    String name = parts[0];
                    String location = parts[1];
                    String description = parts[2];
                    String id = parts[3];
                    String rating = parts[4];
                    String price = parts[5];
                    int count = Integer.parseInt(parts[6].substring(1));
                    int pos1 = line.indexOf("[");
                    int pos2 = line.indexOf("]");

                    String comments = line.substring(pos1, pos2 + 1);

                    Food food = new Food(name, location, description, id, rating, price, count, comments);
                    foodItems.add(food);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foodItems;
    }

    public static void emptyFoodFile() {
        try {
            PrintWriter writer = new PrintWriter(path.toString());
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveAllFoods(ArrayList<Food> foodItems) {
        for (Food food : foodItems) {
            String name = food.getName();
            String location = food.getLocation();
            String description = food.getDescription();
            String id = food.getId();
            String rating = food.getRatings();
            String price = food.getPrices();
            int count = food.getCount();
            String comments = food.getComments();
            String lines = name + "," + location + "," + description + "," + id
                    + "," + rating + "," + price + ", " + count + "," + comments + "\n";
            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
                writer.write(lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteFood(String name) {
        ArrayList<Food> foodItems = getAllFoods();
        for (Food food : foodItems) {
            if (food.getName().equals(name)) {
                foodItems.remove(food);
                break;
            }
        }
        emptyFoodFile();
        saveAllFoods(foodItems);
    }
}

