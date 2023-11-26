package View.club;

import Adapter.Club.CreateClubController;
import Adapter.Club.CreateClubPresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
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
    private final CreateClubController createClubController;
    public JTextField nameField;
    public JTextField leaderField;
    public JTextField descriptionField;
    public JCheckBox publicCheckBox;
    public JButton submitButton;
    public JButton cancelButton;
    public CreateClubApp(ShowingClubInputBoundary showingUsecase) {
        clubDataAccess = new ClubDataAccessObject("clubs.csv");
        createClubPresenter = new CreateClubPresenter(this);
        createClubUsecase = new CreateUsecase(clubDataAccess, createClubPresenter);
        createClubController = new CreateClubController(createClubUsecase, showingUsecase);

        setTitle("Create Club");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 10, 10));

        mainPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        mainPanel.add(nameField);

        mainPanel.add(new JLabel("Leader:"));
        leaderField = new JTextField();
        mainPanel.add(leaderField);

        mainPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField();
        mainPanel.add(descriptionField);

        mainPanel.add(new JLabel("Public:"));
        publicCheckBox = new JCheckBox();
        publicCheckBox.setSelected(true);
        mainPanel.add(publicCheckBox);

        submitButton = new JButton("Submit");

        mainPanel.add(submitButton);

        cancelButton = new JButton("Cancel");
        mainPanel.add(cancelButton);

        add(mainPanel);

        setLocationRelativeTo(null);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createClubController.execute(nameField.getText(), descriptionField.getText(), publicCheckBox.isSelected());
            }
        });
    }

    public static void main(String[] args) {
    }

}
