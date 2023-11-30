package View.club;

import Adapter.Club.JoinClubController;
import Adapter.Club.JoinClubPresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Data.UserDataAccess;
import Data.UserDataAcessObject;
import use_case.club.JoinInputBoundary;
import use_case.club.JoinInputData;
import use_case.club.JoinOutputBoundary;
import use_case.club.JoinUsecase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinClubApp extends JFrame {
    private final ClubDataAccess clubDataAccess;
    private final UserDataAccess userDataAccess;
    private final JoinInputBoundary joinUsecase;
    private final JoinOutputBoundary joinPresenter;
    private final JoinClubController joinController;
    public JLabel clubNameLabel, leaderLabel, membersLabel;
    public JList<String> membersList;
    public DefaultListModel<String> membersListModel;
    public JTextField nameField, passwordField;
    public JButton joinButton, cancelButton;
    public JoinClubApp(JoinInputData joinInputData) {
        this.clubDataAccess = new ClubDataAccessObject("clubs.csv");
        this.userDataAccess = new UserDataAcessObject("users.csv");
        this.joinPresenter = new JoinClubPresenter(this);
        this.joinUsecase = new JoinUsecase(clubDataAccess, userDataAccess, joinPresenter);
        this.joinController = new JoinClubController(joinUsecase);

        setTitle("Join Club");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        clubNameLabel = new JLabel();
        leaderLabel = new JLabel();
        membersLabel = new JLabel("Members:");
        membersListModel = new DefaultListModel<>();
        membersList = new JList<>(membersListModel);
        JScrollPane memberScrollPane = new JScrollPane(membersList);
        nameField = new JTextField(15);
        passwordField = new JPasswordField(15);
//        nameField.setPreferredSize(new Dimension(300, 35));
//        passwordField.setPreferredSize(new Dimension(300, 35));
//        memberScrollPane.setPreferredSize(new Dimension(300, 500));

        joinButton = new JButton("Join");
        cancelButton = new JButton("Cancel");

        joinController.showClubInfo(joinInputData);

        // Set layout manager
        setLayout(new GridLayout(6, 2, 5, 5));

        // Add components to the frame
        add(clubNameLabel);
        add(new JLabel());

        add(leaderLabel);
        add(new JLabel());

        add(membersLabel);
        add(memberScrollPane);

        add(new JLabel("Your Name:"));
        add(nameField);

        add(new JLabel("Your Password:"));
        add(passwordField);

        add(joinButton);
        add(cancelButton);

        pack();

//        setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
////        gbc.insets = new Insets(5, 5, 5, 5);
//
//        // Add components to the frame
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        add(clubNameLabel, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        add(leaderLabel, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        add(membersLabel, gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        add(new JLabel("Name: "), gbc);
//
//        gbc.gridx = 0;
//        gbc.gridy = 4;
//        add(new JLabel("Password:"), gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 2;
//        gbc.fill = GridBagConstraints.BOTH;
//        add(memberScrollPane, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 3;
//
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        add(nameField, gbc);
//
//        gbc.gridx = 1;
//        gbc.gridy = 4;
//        add(passwordField, gbc);
//
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.add(joinButton);
//        buttonPanel.add(cancelButton);
//        gbc.gridx = 0;
//        gbc.gridy = 5;
//        gbc.gridwidth = 2;
//        add(buttonPanel, gbc);
//
//        pack();

        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                joinInputData.setUserName(nameField.getText());
                joinInputData.setPassword(passwordField.getText());
                joinController.execute(joinInputData);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }


}
