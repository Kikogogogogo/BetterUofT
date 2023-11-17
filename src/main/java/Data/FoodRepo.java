package Data;
import Entity.Restaurant;
import java.util.List;

public interface FoodRepo {
    void save(Restaurant food);
    List<Restaurant> getAllFoods();
}