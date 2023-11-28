package Entity;

public class Food {
    private String name;
    private String location;
    private String description;
    private String id;
    private String rating;
    private String price;
    private int count = 1;

    public Food(String name, String location, String description, String id, String rating, String price) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.id = id;
        this.rating = rating;
        this.price = price;
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
        this.count = count + 1;
    }
}
