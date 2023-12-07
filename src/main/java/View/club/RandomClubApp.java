package View.club;

import Adapter.Club.RandomClubPresenter;
import Data.ClubDataAccess;
import Data.UserDataAccess;
import use_case.club.RandomUsecase.RandomClubUsecase;
import use_case.club.RandomUsecase.RandomInputBoundary;
import use_case.club.RandomUsecase.RandomOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomClubApp extends JFrame {
    private final RandomOutputBoundary randomPresenter;
    private final RandomInputBoundary randomUsecase;
    public JLabel clubLabel;
    public JLabel leaderLabel;
    public JLabel joinabelLabel;
    public JTextArea descriptionField;
    public JButton joinButton;
    public RandomClubApp(ClubDataAccess clubDataAccess, UserDataAccess userDataAccess) {
        setTitle("Random Club");
        randomPresenter = new RandomClubPresenter(this);
        randomUsecase = new RandomClubUsecase(clubDataAccess, userDataAccess, randomPresenter);

        clubLabel = new JLabel();
        leaderLabel = new JLabel();
        joinabelLabel = new JLabel();
        descriptionField = new JTextArea();
        descriptionField.setEditable(false);

        randomUsecase.getRandomClub();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        joinButton = new JButton("Join Now!");

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(clubLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(leaderLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        mainPanel.add(joinabelLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        mainPanel.add(descriptionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        mainPanel.add(joinButton, gbc);

        add(mainPanel);
        pack();

        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomUsecase.joinRandomClub();
            }
        });
    }
}
