package View.club;

import use_case.club.CreateOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateClubApp extends JFrame {
    private CreateOutputBoundary createClubPresenter;
    public JTextField nameField;
    public JTextField leaderField;
    public JTextField descriptionField;
    public JCheckBox publicCheckBox;
    public JButton submitButton;
    public JButton cancelButton;
    public CreateClubApp() {
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
        mainPanel.add(publicCheckBox);

        submitButton = new JButton("Submit");

        mainPanel.add(submitButton);

        cancelButton = new JButton("Cancel");
        mainPanel.add(cancelButton);

        add(mainPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        CreateClubApp createClubApp = new CreateClubApp();
        createClubApp.setVisible(true);
    }
}
