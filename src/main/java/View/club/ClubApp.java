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

        List<Club> clubs = showingClubAdapter.getAllClubs();

//        JScrollPane clubPanel = new JScrollPane(clubList);
        for (Club c : clubs) {
            clubListModel.addElement(c.getName());
        }

        add(panel, BorderLayout.NORTH);
        add(clubList, BorderLayout.CENTER);
//        add(clubPanel, BorderLayout.CENTER);
//        clubPanel.add(clubList);
    }

    public static void main(String[] args) {
        ClubApp app = new ClubApp();
        app.setVisible(true);
    }
}
