package View.club;

import Adapter.Club.ModifyClubController;
import Adapter.Club.ModifyClubPresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Data.UserDataAccess;
import Data.UserDataAcessObject;
import use_case.club.ModifyClubUsecase;
import use_case.club.ModifyInputBoundary;
import use_case.club.ModifyOutputBoundary;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyClubApp extends JFrame {
    private final ClubDataAccess clubDataAccess;
    private final UserDataAccess userDataAccess;
    private final ModifyInputBoundary modifyUsecase;
    private final ModifyOutputBoundary modifyPresenter;
    private final ModifyClubController modifyController;
    public JTextField usernameTextField;
    public JTextField passwordTextField;
    public JList<String> clubList;
    public DefaultListModel<String> clubListModel;
    public JTextArea descriptionTextArea;
    public JCheckBox joinableCheckBox;
    public ModifyClubApp() {
        clubDataAccess = new ClubDataAccessObject("clubs.csv");
        userDataAccess = new UserDataAcessObject("users.csv");

        modifyPresenter = new ModifyClubPresenter(this);
        modifyUsecase = new ModifyClubUsecase(clubDataAccess, userDataAccess, modifyPresenter);
        modifyController = new ModifyClubController(modifyUsecase);

        setTitle("Club Modification");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Username and Password
        JPanel credentialsPanel = new JPanel(new GridLayout(2, 2));
        credentialsPanel.add(new JLabel("Username:"));
        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(200, 25));
        credentialsPanel.add(usernameTextField);
        credentialsPanel.add(new JLabel("Password:"));
        passwordTextField = new JTextField();
        passwordTextField.setPreferredSize(new Dimension(200, 25));
        credentialsPanel.add(passwordTextField);

        // Club List
        clubListModel = new DefaultListModel<>();

        clubList = new JList<>(clubListModel);
        JScrollPane clubListScrollPane = new JScrollPane(clubList);
        clubListScrollPane.setPreferredSize(new Dimension(400, 200));
        descriptionTextArea = new JTextArea();
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionTextArea);
        descriptionScrollPane.setPreferredSize(new Dimension(400, 200));
        JButton getClubButton = new JButton("Search");
        JButton modifyDescriptionButton = new JButton("Modify Description");
        joinableCheckBox = new JCheckBox("Joinable");
        JButton deleteClubButton = new JButton("Delete Club");
        JButton cancelButton = new JButton("Cancel");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(credentialsPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(getClubButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(clubListScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(descriptionScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(joinableCheckBox, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(modifyDescriptionButton);
        buttonPanel.add(deleteClubButton);
        buttonPanel.add(cancelButton);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
        pack();

        getClubButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyController.setAllClubs(usernameTextField.getText(), passwordTextField.getText());
            }
        });
        deleteClubButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyController.deleteClub(clubList.getSelectedValue());
            }
        });
        modifyDescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyController.modifyDescription(clubList.getSelectedValue(), descriptionTextArea.getText());
            }
        });
        clubList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                modifyController.presentDescription(clubList.getSelectedValue());
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

    }

    public static void main(String[] args) {
        ModifyClubApp modifyClubApp = new ModifyClubApp();
        modifyClubApp.setVisible(true);
    }
}
