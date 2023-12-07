package Data.Food;

import java.util.List;
import Entity.Food.Food;

public interface FoodDataAccess {
    void save(Food food);


    List<Food> getFoods();

    Object getAll();
}
