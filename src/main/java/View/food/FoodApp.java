package View.food;

import Adapter.Food.AddFoodPresenter;
import Adapter.Food.ShowingFoodPresenter;
import Data.CsvFoodRepo;
import Data.FoodDataAccess;
import Data.FoodDataAccessObject;
import Entity.Food;
import use_case.food.FoodShowingUsecase;
import use_case.food.ShowingFoodInputBoundary;
import use_case.food.ShowingFoodOutputBoundary;
import use_case.food.SortUsecase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FoodApp extends JFrame {

    private ArrayList<Food> foodItems = new ArrayList<>();
    private static ShowingFoodInputBoundary showingUsecase;
    private final ShowingFoodOutputBoundary showingFoodPresenter;

    public FoodApp() {
        FoodDataAccess FoodDataAccess = new FoodDataAccessObject("food.csv");
        showingFoodPresenter = new ShowingFoodPresenter(this);
        showingUsecase = new FoodShowingUsecase(FoodDataAccess, showingFoodPresenter);
        setTitle("Food");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Left panel for buttons like Add and Sort
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        JButton addButton = new JButton("Add");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.addActionListener(this::openAdd);

        JButton sortButton = new JButton("Sort");
        sortButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        sortButton.addActionListener(this::sortFoodItems); // Implement sorting logic in sortFoodItems method
        controlPanel.add(addButton);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Space between buttons
        controlPanel.add(sortButton);

        // Right panel for listing the food items
        JPanel foodListPanel = new JPanel();
        foodListPanel.setLayout(new GridBagLayout()); // Use GridBagLayout for more control
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add a JScrollPane to allow scrolling of food panels
        JScrollPane scrollPane = new JScrollPane(foodListPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        CsvFoodRepo csvFoodRepo = new CsvFoodRepo("food.csv");
        foodItems = csvFoodRepo.getAllFoods();

        // Populate the container panel with food panels
        for (Food food : foodItems) {
            JPanel foodPanel = createFoodPanel(food);
            foodListPanel.add(foodPanel, gbc);
        }

        // Filler component for extra space
        Component filler = Box.createVerticalGlue();
        foodListPanel.add(filler, gbc);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, controlPanel, scrollPane);
        splitPane.setDividerLocation(150);

        add(splitPane, BorderLayout.CENTER); // Add the split pane to the frame

        setSize(800, 600);
        setLocationRelativeTo(null); // Center on screen


    }

    private JPanel createFoodPanel(Food food) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        int panelWidth = 400;
        int panelHeight = 100;
        Dimension panelSize = new Dimension(panelWidth, panelHeight);
        panel.setPreferredSize(panelSize);
        panel.setMinimumSize(panelSize);

        JLabel nameLabel = new JLabel("Name: " + food.getName());
        JLabel ratingLabel = new JLabel("Rating: " + food.getAverageRating() + " stars");
        JLabel priceLabel = new JLabel("Price: $" + food.getAveragePrice());

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
        detailsDialog.add(new JLabel("Rating: " + food.getAverageRating() + " stars"));
        detailsDialog.add(new JLabel("Price: $" + food.getAveragePrice()));
        detailsDialog.add(new JLabel("Location: " + food.getLocation()));
        System.out.println(food.getDescriptionList());
        detailsDialog.add(new JLabel("Description: " ));
        for (String description : food.getDescriptionList()) {
            System.out.println(description + "nn");
            detailsDialog.add(new JLabel(description));
        }

        detailsDialog.setSize(300, 200);

        detailsDialog.setLocationRelativeTo(this);
        detailsDialog.setVisible(true);
    }

    private void sortFoodItems(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            SortUsecase sortFood = new SortUsecase(this);
            sortFood.sortFood();
        });
    }


    private void openAdd(ActionEvent event){
        SwingUtilities.invokeLater(() -> {
            AddFood addFood = new AddFood(showingUsecase);
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
