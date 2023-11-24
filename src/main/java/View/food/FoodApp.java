package View.food;

import Entity.Food;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FoodApp extends JFrame {
    // Assume this is an array of your Food items
    Food a = new Food("a", "a", "a", "a", "a", "a");
    Food b = new Food("b", "b", "b", "b", "b", "b");
    Food c = new Food("c", "c", "c", "c", "c", "c");
    private Food[] foodItems = { a, b, c};

    public FoodApp() {
        setTitle("Food");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(this::openAdd);
        add(addButton);

        String[] choices = {"Name", "Price", "Rating"};
        JComboBox<String> cb = new JComboBox<>(choices);
        cb.setMaximumSize(cb.getPreferredSize());
        add(cb);

        // Container panel with vertical BoxLayout to hold all food panels
        JPanel foodContainerPanel = new JPanel();
        foodContainerPanel.setLayout(new BoxLayout(foodContainerPanel, BoxLayout.Y_AXIS));

        // Add a JScrollPane to allow scrolling of food panels
        JScrollPane scrollPane = new JScrollPane(foodContainerPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Populate the container panel with food panels
        for (Food food : foodItems) {
            JPanel foodPanel = createFoodPanel(food);
            foodContainerPanel.add(foodPanel);
        }

        add(scrollPane); // Add the scroll pane to the frame
    }

    private JPanel createFoodPanel(Food food) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel nameLabel = new JLabel("Name: " + food.getName());
        JLabel ratingLabel = new JLabel("Rating: " + food.getRatings() + " stars");
        JLabel priceLabel = new JLabel("Price: $" + food.getPrices());

        JButton detailsButton = new JButton("Details");
        detailsButton.addActionListener(e -> openFoodDetails(food));

        panel.add(nameLabel);
        panel.add(ratingLabel);
        panel.add(priceLabel);
        panel.add(detailsButton);

        return panel;
    }

    private void openFoodDetails(Food food) {
        JDialog detailsDialog = new JDialog(this, "Food Details", true);
        detailsDialog.setLayout(new BoxLayout(detailsDialog.getContentPane(), BoxLayout.Y_AXIS));
        detailsDialog.add(new JLabel("Name: " + food.getName()));
        detailsDialog.add(new JLabel("Rating: " + food.getRatings() + " stars"));
        detailsDialog.add(new JLabel("Price: $" + food.getPrices()));
        detailsDialog.add(new JLabel("Location: " + food.getLocation()));
        detailsDialog.add(new JLabel("Description: " + food.getDescription()));


        // Add more details as needed

        detailsDialog.pack();
        detailsDialog.setLocationRelativeTo(this); // Center the dialog relative to the main frame
        detailsDialog.setVisible(true);
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
