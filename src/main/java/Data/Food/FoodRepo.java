package Data.Food;
import Entity.Food.Food;
import java.util.List;

public interface FoodRepo {
    void save(Food food);

    static List<Food> getAllFoods() {
        return null;
    }
}

