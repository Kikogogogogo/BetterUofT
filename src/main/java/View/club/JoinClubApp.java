package View.club;

import Adapter.Club.JoinClubController;
import Adapter.Club.JoinClubPresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
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
    private final JoinInputBoundary joinUsecase;
    private final JoinOutputBoundary joinPresenter;
    private final JoinClubController joinController;
    public JLabel clubNameLabel, leaderLabel, membersLabel;
    public JList<String> membersList;
    public JTextField nameField, passwordField;
    public JButton joinButton, cancelButton;
    public JoinClubApp(JoinInputData joinInputData) {
        this.clubDataAccess = new ClubDataAccessObject("clubs.csv");
        this.joinPresenter = new JoinClubPresenter(this);
        this.joinUsecase = new JoinUsecase(clubDataAccess, joinPresenter);
        this.joinController = new JoinClubController(joinUsecase);

        setTitle("Join Club");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.setSize(600, 600);
        clubNameLabel = new JLabel();
        leaderLabel = new JLabel();
        membersLabel = new JLabel("Members:");
        membersList = new JList<>(new String[]{"Member1", "Member2", "Member3"});
        nameField = new JTextField(15);
        passwordField = new JPasswordField(15);

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
        add(new JScrollPane(membersList));

        add(new JLabel("Your Name:"));
        add(nameField);

        add(new JLabel("Your Password:"));
        add(passwordField);

        add(joinButton);
        add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }


}
