package Data;

import java.util.List;
import Entity.Food;

public interface FoodDataAccess {
    void save(Food food);


    List<Food> getFoods();

    Object getAll();
}
