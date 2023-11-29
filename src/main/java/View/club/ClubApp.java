package View.club;

import Adapter.Club.JoinClubPresenter;
import Adapter.Club.ShowingClubPresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Entity.Club;
import use_case.club.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClubApp extends JFrame {
    private JPanel panel;
    private final ShowingClubInputBoundary showingUsecase;
    private final ShowingOutputBoundary showingClubPresenter;
    public JList<String> clubList;
    public DefaultListModel<String> clubListModel;
    public JTextArea descriptionTextField;
    public JCheckBox joinableCheckBox;

    public ClubApp() {

        ClubDataAccess clubDataAccess = new ClubDataAccessObject("clubs.csv");

        showingClubPresenter = new ShowingClubPresenter(this);

        showingUsecase = new ShowingUsecase(clubDataAccess, showingClubPresenter);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Clubs");
        setSize(800, 600);
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        clubListModel = new DefaultListModel<>();

        clubList = new JList<>(clubListModel);
        clubList.setFont(new Font("serif", Font.PLAIN, 18));
        JScrollPane listScrollPane = new JScrollPane(clubList);

        showingUsecase.showAllClubs();

        JButton createClubButton = new JButton("Create Club");
        JButton joinClubButton = new JButton("Join Club");
        descriptionTextField = new JTextArea();
        joinableCheckBox = new JCheckBox("Joinable");

        JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextField);
        descriptionScrollPane.setPreferredSize(new Dimension(300, 100));
        joinableCheckBox.setEnabled(false);
        descriptionTextField.setEditable(false);
        descriptionTextField.setFont(new Font("serif", Font.PLAIN, 18));


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
        add(descriptionScrollPane, gbc);

        gbc.gridy = 3;
        add(joinableCheckBox, gbc);

        createClubButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateClubApp createClubApp = new CreateClubApp(showingUsecase);
                createClubApp.setVisible(true);
            }
        });

        joinClubButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JoinClubApp joinClubApp = new JoinClubApp(new JoinInputData(clubList.getSelectedValue(), "A"));
                joinClubApp.setVisible(true);
            }
        });

        clubList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                showingUsecase.showClubDescription(clubList.getSelectedIndex());
                showingUsecase.showClubJoinable(clubList.getSelectedIndex());
            }
        });
    }

    public static void main(String[] args) {
        ClubApp app = new ClubApp();
        app.setVisible(true);
    }
}
