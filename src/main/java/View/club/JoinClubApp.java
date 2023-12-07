package View.club;

import Adapter.Club.JoinClubController;
import Adapter.Club.JoinClubPresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Data.UserDataAccess;
import Data.UserDataAcessObject;
import use_case.club.JoinUsecase.JoinInputBoundary;
import use_case.club.JoinUsecase.JoinInputData;
import use_case.club.JoinUsecase.JoinOutputBoundary;
import use_case.club.JoinUsecase.JoinUsecase;

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
        nameField = new JTextField(30);
        passwordField = new JPasswordField(30);
        nameField.setPreferredSize(new Dimension(1000, 30));
        passwordField.setPreferredSize(new Dimension(1000, 30));
        memberScrollPane.setPreferredSize(new Dimension(300, 300));

        joinButton = new JButton("Join");
        cancelButton = new JButton("Cancel");
        joinButton.setPreferredSize(new Dimension(200, 30));
        cancelButton.setPreferredSize(new Dimension(200, 30));

        joinController.showClubInfo(joinInputData);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(clubNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(leaderLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(membersLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(memberScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(new JLabel("Name: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(new JLabel("Password: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(passwordField, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(joinButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
        pack();

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
