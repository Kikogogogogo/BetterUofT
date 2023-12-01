package View.club;

import Adapter.Club.CreateClubController;
import Adapter.Club.CreateClubPresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Data.UserDataAccess;
import Data.UserDataAcessObject;
import use_case.club.CreateInputBoundary;
import use_case.club.CreateOutputBoundary;
import use_case.club.CreateUsecase;
import use_case.club.ShowingClubInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateClubApp extends JFrame {
    private final CreateOutputBoundary createClubPresenter;
    private final CreateInputBoundary createClubUsecase;
    private final ClubDataAccess clubDataAccess;
    private final UserDataAccess userDataAccess;
    private final CreateClubController createClubController;
    public JTextField nameField;
    public JTextField leaderField;
    public JTextArea descriptionField;
    public JCheckBox publicCheckBox;
    public JButton correctButton;
    public JButton submitButton;
    public JButton cancelButton;
    public CreateClubApp(ShowingClubInputBoundary showingUsecase) {
        clubDataAccess = new ClubDataAccessObject("clubs.csv");
        userDataAccess = new UserDataAcessObject("users.csv");
        createClubPresenter = new CreateClubPresenter(this);
        createClubUsecase = new CreateUsecase(clubDataAccess, userDataAccess, createClubPresenter);
        createClubController = new CreateClubController(createClubUsecase, showingUsecase);

        setTitle("Create Club");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 30));
        mainPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("Leader:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        leaderField = new JTextField();
        leaderField.setPreferredSize(new Dimension(200, 30));
        mainPanel.add(leaderField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Description:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        descriptionField = new JTextArea();
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionField);
        descriptionScrollPane.setPreferredSize(new Dimension(400, 300));
        mainPanel.add(descriptionScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Public:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        publicCheckBox = new JCheckBox();
        publicCheckBox.setSelected(true);
        mainPanel.add(publicCheckBox, gbc);

        JPanel buttonPanel = new JPanel();

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(200, 35));
//        mainPanel.add(submitButton, gbc);

        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(200, 35));
//        mainPanel.add(cancelButton, gbc);
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        correctButton = new JButton("Correct/Check Description");
        correctButton.setPreferredSize(new Dimension(400, 35));
        mainPanel.add(correctButton, gbc);

        add(mainPanel);
        pack();

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createClubController.execute(nameField.getText(), descriptionField.getText(), publicCheckBox.isSelected(),
                        leaderField.getText());
            }
        });

        correctButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createClubController.correctDescription(descriptionField.getText());
            }
        });
    }

    public static void main(String[] args) {
    }

}
