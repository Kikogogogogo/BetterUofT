package View.club;

import Adapter.Club.ShowingClubPresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Entity.Club;
import use_case.club.ShowingInputData;
import use_case.club.ShowingOutputBoundary;
import use_case.club.ShowingUsecase;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClubApp extends JFrame {
    private JPanel panel;
    private ShowingOutputBoundary showingClubPresenter;
    public JList<String> clubList;
    public DefaultListModel<String> clubListModel;
    public JTextField descriptionTextField;
    public JCheckBox joinableCheckBox;

    public ClubApp() {

        ClubDataAccess clubDataAccess = new ClubDataAccessObject("clubs.csv");

        showingClubPresenter = new ShowingClubPresenter(this);

        ShowingUsecase showingUsecase = new ShowingUsecase(clubDataAccess, showingClubPresenter);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Clubs");
        setSize(800, 600);
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        clubListModel = new DefaultListModel<>();

        clubList = new JList<>(clubListModel);
        JScrollPane listScrollPane = new JScrollPane(clubList);

        showingUsecase.showAllClubs();

        JButton createClubButton = new JButton("Create Club");
        JButton joinClubButton = new JButton("Join Club");
        descriptionTextField = new JTextField();
        joinableCheckBox = new JCheckBox("Joinable");

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

        createClubButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        clubList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                showingUsecase.showClubDescription(clubList.getSelectedIndex());
            }
        });
    }

    public static void main(String[] args) {
        ClubApp app = new ClubApp();
        app.setVisible(true);
    }
}