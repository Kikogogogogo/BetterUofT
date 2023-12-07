package App;

import View.LostAndFound.ReportApplication;
import View.club.ClubApp;
import View.food.FoodApp;

import View.postandreply.ChatWithHuman.MessageBoardApp;
import View.trade.TradeView;
import java.net.URI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinalApp extends JFrame {


    public FinalApp() {
        setTitle("Final App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 400); 
        setLocationRelativeTo(null);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 2, 10, 10)); 
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel imageLabel = loadImage();
        if (imageLabel != null) {
            add(imageLabel, BorderLayout.NORTH);
        }


        JButton postAndReplyButton = createButton("Post and Reply", this::openPostAndReply);
        JButton clubButton = createButton("Club", this::openClub);
        JButton foodButton = createButton("Food", this::openFood);
        JButton tradeButton = createButton("Trading", this::openTrading);
        JButton lafButton = createButton("Lost and Found", this::openLAF);
        JButton closeButton = createButton("Close Program", e -> closeProgram());

        closeButton.setBackground(Color.LIGHT_GRAY);
        closeButton.setForeground(Color.black);

        buttonPanel.add(postAndReplyButton);
        buttonPanel.add(clubButton);
        buttonPanel.add(foodButton);
        buttonPanel.add(tradeButton);
        buttonPanel.add(lafButton);
        buttonPanel.add(closeButton);

        add(buttonPanel, BorderLayout.CENTER);

    }

    private JLabel loadImage() {
        try {
            ImageIcon imageIcon = new ImageIcon("logo.png");
            Image image = imageIcon.getImage().getScaledInstance((int) (this.getWidth() * 0.9), 175, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(image));

            imageLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    openWebpage("https://github.com/Kikogogogogo/BetterUofT");
                }
            });

            return imageLabel;
        } catch (Exception e) {
            System.err.println("error");
            return null;
        }
    }

    private void openWebpage(String urlString) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(urlString));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void closeProgram() {

        dispose();
    }


    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        return button;
    }



    private void openTrading(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            TradeView tradeView = new TradeView();
            tradeView.setVisible(true);

            dispose();
        });
    }

    private void openPostAndReply(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            MessageBoardApp messageBoardApp = new MessageBoardApp();
            messageBoardApp.setVisible(true);

            dispose();
        });
    }

    private void openClub(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            ClubApp clubApp = new ClubApp();
            clubApp.setVisible(true);

            dispose();
        });
    }
  
    private void openFood(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            FoodApp foodApp = new FoodApp();
            foodApp.setVisible(true);

            dispose();

        });
    }

    private void openLAF(ActionEvent event) {
        SwingUtilities.invokeLater(() -> {
            ReportApplication reportApp = new ReportApplication();
            reportApp.setVisible(true);

            dispose();
        });
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FinalApp finalApp = new FinalApp();
            finalApp.setVisible(true);
        });
    }
}
