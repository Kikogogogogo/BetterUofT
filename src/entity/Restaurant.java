package entity;

public class Restaurant {
    private String name;
    private String location;
    private String description;
    private String id;
    private int rating;
    private int price;

    public Restaurant(String name, String location, String description, String id, int rating, int price) {
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

    public int getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }
}
