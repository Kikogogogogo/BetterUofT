package View.club;

import Adapter.Club.*;
import App.FinalApp;
import Data.Club.ClubDataAccess;
import Data.Club.ClubDataAccessObject;
import Data.Club.UserDataAccess;
import Data.Club.UserDataAcessObject;
import use_case.club.JoinUsecase.JoinInputData;
import use_case.club.ShowingUsecase.ShowingClubInputBoundary;
import use_case.club.ShowingUsecase.ShowingOutputBoundary;
import use_case.club.ShowingUsecase.ShowingUsecase;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClubApp extends JFrame {
    private JPanel panel;
    private final ShowingClubInputBoundary showingUsecase;
    private final ShowingOutputBoundary showingClubPresenter;
    private final ShowingClubController showingClubController;
    public JList<String> clubList;
    public DefaultListModel<String> clubListModel;
    public JTextArea descriptionTextField;
    public JCheckBox joinableCheckBox;

    public ClubApp() {

        ClubDataAccess clubDataAccess = new ClubDataAccessObject("clubs.csv");
        UserDataAccess userDataAccess = new UserDataAcessObject("users.csv");

        showingClubPresenter = new ShowingClubPresenter(this);
        showingUsecase = new ShowingUsecase(clubDataAccess, showingClubPresenter);
        showingClubController = new ShowingClubController(showingUsecase);

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

        showingClubController.showAllClubs();

        JButton createClubButton = new JButton("Create Club");
        JButton joinClubButton = new JButton("Join Club");
        JButton showInfoButton = new JButton("Show Club Information");
        JButton modifyButton = new JButton("Modify club information (for leaders)");
        JButton randomButton = new JButton("Not sure what to join? Get a random club!");
        JButton backButton = new JButton("Back to main page");
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

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weighty = 0.0;
        add(showInfoButton, gbc);

        gbc.gridx = 1;
        add(modifyButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        add(randomButton, gbc);

        gbc.gridx = 1;
        add(backButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(descriptionScrollPane, gbc);

        gbc.gridy = 5;
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
                if (!joinableCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(panel, "The club is not joinable!");
                    return;
                }
                JoinClubApp joinClubApp = new JoinClubApp(new JoinInputData(clubList.getSelectedValue()));
                joinClubApp.setVisible(true);
            }
        });

        showInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clubList.getSelectedValue() == null)
                    JOptionPane.showMessageDialog(panel, "You have not selected any club!");
                else {
                    InfoClubApp infoClubApp = new InfoClubApp(clubDataAccess, userDataAccess, clubList.getSelectedValue());
                    infoClubApp.setVisible(true);
                }
            }
        });

        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomClubApp randomClubApp = new RandomClubApp(clubDataAccess, userDataAccess);
                randomClubApp.setVisible(true);
            }
        });

        clubList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                showingClubController.showDescription(clubList.getSelectedIndex());
                showingClubController.showJoinbale(clubList.getSelectedIndex());
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyClubApp modifyClubApp = new ModifyClubApp();
                modifyClubApp.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    FinalApp finalApp = new FinalApp();
                    finalApp.setVisible(true);
                });
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        ClubApp app = new ClubApp();
        app.setVisible(true);
    }
}
