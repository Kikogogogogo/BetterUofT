package View.club;

import Adapter.ShowingClubAdapter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Entity.Club;
import use_case.club.ShowingUsecase;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClubApp extends JFrame {
    private JPanel panel;
    private ShowingClubAdapter showingClubAdapter;

    public ClubApp() {

        ClubDataAccess clubDataAccess = new ClubDataAccessObject("clubs.csv");

        ShowingUsecase showingUsecase = new ShowingUsecase(clubDataAccess);

        showingClubAdapter = new ShowingClubAdapter(showingUsecase);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Clubs");
        setSize(800, 600);
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        DefaultListModel<String> clubListModel = new DefaultListModel<>();

        JList<String> clubList = new JList<>(clubListModel);
        JScrollPane listScrollPane = new JScrollPane(clubList);

        List<Club> clubs = showingClubAdapter.getAllClubs();

        for (Club c : clubs) {
            clubListModel.addElement(c.getName());
        }

//        add(panel, BorderLayout.NORTH);
//        add(clubList, BorderLayout.CENTER);

        JButton createClubButton = new JButton("Create Club");
        JButton joinClubButton = new JButton("Join Club");
        JTextField descriptionTextField = new JTextField();
        JCheckBox joinableCheckBox = new JCheckBox("Joinable");

        joinableCheckBox.setEnabled(false);
        descriptionTextField.setEnabled(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Construct the GUI
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(listScrollPane, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weighty = 0.0;
        add(createClubButton, gbc);

        gbc.gridx = 1;
        add(joinClubButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(descriptionTextField, gbc);

        gbc.gridy = 3;
        add(joinableCheckBox, gbc);
    }

    public static void main(String[] args) {
        ClubApp app = new ClubApp();
        app.setVisible(true);
    }
}
