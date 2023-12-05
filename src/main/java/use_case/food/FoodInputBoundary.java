package use_case.food;

public interface FoodInputBoundary {
    public void createFood(String name, String location, String description, String id, String rating, String price);
}
