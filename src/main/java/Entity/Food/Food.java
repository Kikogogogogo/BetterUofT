package Entity.Food;

import java.util.ArrayList;
import java.util.Arrays;

public class Food implements Cloneable{
    private String name;
    private String location;
    private String description;
    private String id;
    private String rating;
    private String price;
    private int count = 0;
    private ArrayList<String> descriptionList = new ArrayList<>();

    public Food(String name, String location, String description, String id,
                String rating, String price, int count, String comments) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.id = id;
        this.rating = rating;
        this.price = price;
        this.count += count;
        String trimmedInput = comments.substring(1, comments.length() - 1).trim();

        // Split the string by commas and convert to an ArrayList
        this.descriptionList = new ArrayList<>(Arrays.asList(trimmedInput.split("\\s*,\\s*")));

    }

    public Food(String name, String location, String description, String id, String rating, String price,
                int count) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.id = id;
        this.rating = rating;
        this.price = price;
        this.count += count;
    }

    public Food(String name, int rating, int price) {
        this.name = name;
        this.rating = String.valueOf(rating);
        this.price = String.valueOf(price);

    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id;
    }

    public double getRating() {
        return Double.parseDouble(this.rating);
    }

    public String getRatings() {
        return this.rating;
    }

    public double getPrice() {
        return Double.parseDouble(this.price);
    }

    public String getPrices() {
        return this.price;
    }

    public int getCount() {
        return this.count;
    }

    public void increaseCount() {
        this.count = this.count + 1;
    }

    public void addDescription(String description) {
        this.descriptionList.add(description);
    }

    public ArrayList<String> getDescriptionList() {
        return this.descriptionList;
    }

    public  String getAverageRating() {
        double averageRating = Double.parseDouble(this.rating) / this.count;
        return String.valueOf(averageRating);
    }

    public String getAveragePrice() {
        double averagePrice = Double.parseDouble(this.price) / this.count;
        return String.valueOf(averagePrice);
    }

    public void increaseRating(double rating) {
        double newrating = Double.parseDouble(this.rating) + rating;
        this.rating = String.valueOf(newrating);
    }

    public void increasePrice(double price) {
        double newprice = Double.parseDouble(this.price) + price;
        this.price = String.valueOf(newprice);
    }

    public String getComments() {
        return this.descriptionList.toString();
    }

    public Food clone() {
        try {
            return (Food) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

}
