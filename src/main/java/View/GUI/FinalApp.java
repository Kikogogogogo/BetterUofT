package View.GUI;

import View.LostAndFound.ReportApplication;
import View.club.ClubApp;
import View.food.FoodApp;

import View.postandreply.ChooseModeGUI;
import View.postandreply.MessageBoardApp;
import View.trade.TradeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Objects;

public class FinalApp extends JFrame {
    private ImageIcon image1;
    private  JLabel label1;

    public FinalApp() {
        setTitle("Final App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400, 400);
        setLocationRelativeTo(null);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton postAndReplyButton = createButton("Post and Reply", this::openPostAndReply);
        JButton clubButton = createButton("Club", this::openClub);
        JButton foodButton = createButton("Food", this::openFood);
        JButton tradeButton = createButton("Trading", this::openTrading);
        JButton lafButton = createButton("Lost and Found", this::openLAF);

        loadAndSetImage();


        buttonPanel.add(postAndReplyButton);
        buttonPanel.add(clubButton);
        buttonPanel.add(foodButton);
        buttonPanel.add(tradeButton);
        buttonPanel.add(lafButton);

        add(buttonPanel, BorderLayout.CENTER);
    }


    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        return button;
    } //dd


    private void loadAndSetImage() {
        URL imageUrl = getClass().getClassLoader().getResource("UofT-Sc-logo.jpg");
        if (imageUrl != null) {
            image1 = new ImageIcon(imageUrl);
            label1 = new JLabel(image1);
            add(label1, BorderLayout.NORTH);
        } else {
            System.err.println("error");
        }
    }



    private void openTrading(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            TradeView tradeView = new TradeView();
            tradeView.setVisible(true);
        });
    }
    private void openPostAndReply(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            ChooseModeGUI chooseMode = new ChooseModeGUI();
            chooseMode.setVisible(true);
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

    private void openLAF(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            ReportApplication reportApp = new ReportApplication();
            reportApp.setVisible(true);
        });
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FinalApp finalApp = new FinalApp();
            finalApp.setVisible(true);
        });
    }
}
