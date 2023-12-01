package Adapter.Club;

import View.club.ClubApp;
import use_case.club.InfoClubOutputBoundary;
import use_case.club.InfoClubUsecase;
import use_case.club.InfoOutputData;

import javax.swing.*;
import java.awt.*;

public class InfoClubPresenter implements InfoClubOutputBoundary {
    final ClubApp view;
    public InfoClubPresenter(ClubApp view) {
        this.view = view;
    }

    public void prepareFailedView(String message) {
        JOptionPane.showMessageDialog(view, message);
    }
    public void prepareInfoWindow(InfoOutputData infoOutputData) {
        JFrame infoWindow = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        infoWindow.setTitle("Club Information");
        DefaultListModel membersListModel = new DefaultListModel();
        JList<String> membersList = new JList(membersListModel);
        JScrollPane memberScrollPane = new JScrollPane(membersList);
        memberScrollPane.setPreferredSize(new Dimension(200, 200));
        JTextArea descriptionField = new JTextArea();
        descriptionField.setText(infoOutputData.getDescription());
        descriptionField.setPreferredSize(new Dimension(300, 200));
        descriptionField.setEditable(false);

        for (String member : infoOutputData.getMembers()) {
            membersListModel.addElement(member);
        }

        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Club Name: " + infoOutputData.getClubName()), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Leader Name: " + infoOutputData.getLeaderName()), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Memebers: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(memberScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        mainPanel.add(descriptionField, gbc);

        infoWindow.add(mainPanel);
        infoWindow.pack();
        infoWindow.setVisible(true);
    }

}
