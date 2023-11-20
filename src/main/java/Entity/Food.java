package Entity;

public class Food {
    private String name;
    private String location;
    private String description;
    private String id;
    private double rating;
    private String price;

<<<<<<< HEAD:src/main/java/Entity/Restaurant.java
    public Restaurant(String name, String location, String description, String id, int rating, String price) {
=======
    public Food(String name, String location, String description, String id, int rating, int price) {
>>>>>>> main:src/main/java/Entity/Food.java
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
        return rating;
    }

    public String getPrice() {
        return price;
    }
}
