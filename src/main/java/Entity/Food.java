package Entity;

import java.util.ArrayList;

public class Food {
    private String name;
    private String location;
    private String description;
    private String id;
    private String rating;
    private String price;
    private int count = 0;
    private ArrayList<String> descriptionList = new ArrayList<>();

    public Food(String name, String location, String description, String id, String rating, String price, int count) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.id = id;
        this.rating = rating;
        this.price = price;
        this.count += count;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public double getRating() {
        return Double.parseDouble(rating);
    }

    public String getRatings() {
        return rating;
    }

    public double getPrice() {
        return Double.parseDouble(price);
    }

    public String getPrices() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        System.out.println("ncsjndcjs");
        this.count = count + 1;
    }

    public void addDescription(String description) {
        descriptionList.add(description);
    }

    public ArrayList<String> getDescriptionList() {
        return descriptionList;
    }

    public  String getAverageRating() {
        double averageRating = Double.parseDouble(rating) / count;
        return String.valueOf(averageRating);
    }

    public String getAveragePrice() {
        double averagePrice = Double.parseDouble(price) / count;
        return String.valueOf(averagePrice);
    }

    public void increaseRating(double rating) {
        System.out.println("ncsjndcjs");
        this.rating = String.valueOf(rating);
    }

    public void increasePrice(double price) {
        this.price = String.valueOf(price);
    }
}
