package Data;
import Entity.Food;
import java.util.List;

public interface FoodRepo {
    void save(Food food);

    static List<Food> getAllFoods() {
        return null;
    }
}

