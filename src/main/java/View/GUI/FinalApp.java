package View.GUI;

import View.club.ClubApp;
import View.food.FoodApp;

import View.postandreply.MessageBoardApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FinalApp extends JFrame {

    public FinalApp() {
        setTitle("Final App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));
        JButton postAndReplyButton = new JButton("Post and Reply");
        postAndReplyButton.addActionListener(this::openPostAndReply);

        JButton clubButton = new JButton("Club");
        clubButton.addActionListener(this::openClub);

        JButton foodButton = new JButton("Food");
        foodButton.addActionListener(this::openFood);
        JButton weatherButton = new JButton("Weather");


        add(postAndReplyButton);
        add(clubButton);
        add(foodButton);
        add(weatherButton);
    }

    private void openPostAndReply(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            MessageBoardApp messageBoardApp = new MessageBoardApp();
            messageBoardApp.setVisible(true);
        });
    }

    private void openClub(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            ClubApp clubApp = new ClubApp();
            clubApp.setVisible(true);
        });
    }
  
    private void openFood(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            FoodApp foodApp = new FoodApp();
            foodApp.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FinalApp finalApp = new FinalApp();
            finalApp.setVisible(true);
        });
    }
}
