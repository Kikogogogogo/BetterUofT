package View.food;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FoodApp extends JFrame{
    public FoodApp(){
        setTitle("Food");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JButton sortButton = new JButton("Sort");
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this::openAdd);

        add(sortButton);
        add(addButton);
    }

    private void openAdd(ActionEvent event){
        SwingUtilities.invokeLater(() -> {
            AddFood addFood = new AddFood();
            addFood.setVisible(true);
        });
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FoodApp foodApp = new FoodApp();
            foodApp.setVisible(true);
        });
    }
}
