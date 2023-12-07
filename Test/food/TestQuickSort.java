package food;

import Entity.Food;
import org.junit.Test;
import use_case.food.QuickSort;

import java.util.ArrayList;

public class TestQuickSort {
    @Test
    public void testQuickSort() {
        Food food1 = new Food("1", "1", "1", "1", "1", "1", 1);
        Food food2 = new Food("2", "2", "2", "2", "2", "2", 2);
        Food food3 = new Food("3", "3", "3", "3", "3", "3", 3);
        Food food4 = new Food("4", "4", "4", "4", "4", "4", 4);
        ArrayList<Food> foodItems = new ArrayList<>();
        foodItems.add(food1);
        foodItems.add(food2);
        foodItems.add(food3);
        foodItems.add(food4);
        QuickSort quickSort = new QuickSort(foodItems, 0, foodItems.size() - 1);
        foodItems = quickSort.run();
        assert foodItems.get(0).getRating() == 4;
        assert foodItems.get(1).getRating() == 3;
        assert foodItems.get(2).getRating() == 2;
        assert foodItems.get(3).getRating() == 1;
    }

    @Test
    public void testQuickSortNoItem(){
        ArrayList<Food> foodItems = new ArrayList<>();
        QuickSort quickSort = new QuickSort(foodItems, 0, foodItems.size() - 1);
        foodItems = quickSort.run();
        assert foodItems.size() == 0;
    }

    @Test
    public void testQuickSortOneItem(){
        Food food1 = new Food("1", "1", "1", "1", "1", "1", 1);
        ArrayList<Food> foodItems = new ArrayList<>();
        foodItems.add(food1);
        QuickSort quickSort = new QuickSort(foodItems, 0, foodItems.size() - 1);
        foodItems = quickSort.run();
        assert foodItems.get(0).getRating() == 1;
    }

    @Test
    public void testQuickSortNoChange(){
        Food food1 = new Food("1", "1", "1", "1", "5", "1", 1);
        Food food2 = new Food("2", "2", "2", "2", "4", "2", 2);
        Food food3 = new Food("3", "3", "3", "3", "3", "3", 3);
        Food food4 = new Food("4", "4", "4", "4", "2", "4", 4);
        ArrayList<Food> foodItems = new ArrayList<>();
        foodItems.add(food1);
        foodItems.add(food2);
        foodItems.add(food3);
        foodItems.add(food4);
        QuickSort quickSort = new QuickSort(foodItems, 0, foodItems.size() - 1);
        foodItems = quickSort.run();
        assert foodItems.get(0).getRating() == 5.0;
        assert foodItems.get(1).getRating() == 4.0;
        assert foodItems.get(2).getRating() == 3.0;
        assert foodItems.get(3).getRating() == 2.0;
    }
}
