package View.club;

import Adapter.Club.InfoClubController;
import Adapter.Club.InfoClubPresenter;
import Data.ClubDataAccess;
import Data.UserDataAccess;
import use_case.club.InfoUsecase.InfoClubInputBoundary;
import use_case.club.InfoUsecase.InfoClubOutputBoundary;
import use_case.club.InfoUsecase.InfoClubUsecase;

import javax.swing.*;
import java.awt.*;

public class InfoClubApp extends JFrame {
    private final InfoClubOutputBoundary infoPresenter;
    private final InfoClubInputBoundary infoUsecase;
    private final InfoClubController infoClubController;
    public JLabel nameLabel;
    public JLabel leaderLabel;
    public JLabel leaderEmailLabel;
    public DefaultListModel membersListModel;
    public JTextArea descriptionField;
    public InfoClubApp(ClubDataAccess clubDataAccess, UserDataAccess userDataAccess, String clubName) {
        infoPresenter = new InfoClubPresenter(this);
        infoUsecase = new InfoClubUsecase(clubDataAccess, userDataAccess, infoPresenter);
        infoClubController = new InfoClubController(infoUsecase);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setTitle("Club Information");

        nameLabel = new JLabel();
        leaderLabel = new JLabel();
        leaderEmailLabel = new JLabel();

        membersListModel = new DefaultListModel();
        JList<String> membersList = new JList(membersListModel);
        JScrollPane memberScrollPane = new JScrollPane(membersList);
        memberScrollPane.setPreferredSize(new Dimension(200, 200));
        descriptionField = new JTextArea();

        descriptionField.setPreferredSize(new Dimension(500, 200));
        descriptionField.setEditable(false);
        infoClubController.execute(clubName);

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(leaderLabel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        mainPanel.add(leaderEmailLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(new JLabel("Memebers: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        mainPanel.add(memberScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 4;
        mainPanel.add(descriptionField, gbc);

        add(mainPanel);
        pack();
    }
}
