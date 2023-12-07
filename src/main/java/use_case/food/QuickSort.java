package use_case.food;

import Entity.Food.Food;

import java.util.ArrayList;

public class QuickSort {

    private ArrayList<Food> foodItems;
    private int begin;
    private int end;

    public QuickSort(ArrayList<Food> foodItems, int begin, int end) {
        this.foodItems = foodItems;
        this.begin = begin;
        this.end = end;
    }

    public ArrayList<Food> run() {
        quickSort(this.begin, this.end);
        return foodItems;
    }

    private void quickSort(int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(begin, end);

            // Recursively sort elements before and after partition
            quickSort(begin, partitionIndex - 1);
            quickSort(partitionIndex + 1, end);
        }
    }

    private int partition(int begin, int end) {
        double pivot = foodItems.get(end).getRating();
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (foodItems.get(j).getRating() >= pivot) {
                i++;

                // Swap foodItems[i] and foodItems[j]
                Food temp = foodItems.get(i);
                foodItems.set(i, foodItems.get(j));
                foodItems.set(j, temp);
            }
        }

        // Swap foodItems[i+1] and foodItems[end] (or pivot)
        Food temp = foodItems.get(i + 1);
        foodItems.set(i + 1, foodItems.get(end));
        foodItems.set(end, temp);

        return i + 1;
    }

    // Main method to test the QuickSort algorithm
    public static void main(String args[]) {
    }
}
