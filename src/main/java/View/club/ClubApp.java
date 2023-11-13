package View.club;

import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Entity.Club;

import javax.swing.*;
import java.awt.*;

public class ClubApp extends JFrame {
    private JPanel panel;
    private JScrollPane clubShowPanel;

    public ClubApp() {
        ClubDataAccess clubDataAccess = new ClubDataAccessObject("clubs.csv");

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        clubShowPanel = new JScrollPane();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Clubs");
        setSize(800, 600);
        setLayout(new BorderLayout());

        add(panel, BorderLayout.NORTH);
        add(clubShowPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        ClubApp app = new ClubApp();
        app.setVisible(true);
    }
}
