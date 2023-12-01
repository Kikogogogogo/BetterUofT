package Adapter.Club;

import Entity.Club;
import View.club.ClubApp;
import use_case.club.RandomOutputBoundary;

import javax.swing.*;
import java.awt.*;

public class RandomClubPresenter implements RandomOutputBoundary {
    private final ClubApp view;
    public RandomClubPresenter(ClubApp view) {
        this.view = view;
    }
    @Override
    public void prepareRandomClubResult(String name, String leader, String description) {
        JFrame infoWindow = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        JTextArea descriptionField = new JTextArea();
        descriptionField.setText(description);
        descriptionField.setEditable(false);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Club Name: " + name), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Leader Name: " + leader), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(descriptionField, gbc);

        infoWindow.add(mainPanel);
        infoWindow.pack();
        infoWindow.setVisible(true);
    }
}
