package Adapter.Club;

import View.club.InfoClubApp;
import use_case.club.InfoUsecase.InfoClubOutputBoundary;
import use_case.club.InfoUsecase.InfoOutputData;

import javax.swing.*;

public class InfoClubPresenter implements InfoClubOutputBoundary {
    final InfoClubApp view;
    public InfoClubPresenter(InfoClubApp view) {
        this.view = view;
    }

    public void prepareFailedView(String message) {
        JOptionPane.showMessageDialog(view, message);
    }
    public void prepareInfoWindow(InfoOutputData infoOutputData) {
        view.nameLabel.setText("Club Name: " + infoOutputData.clubName);
        view.leaderLabel.setText("Leader Name: " + infoOutputData.getLeaderName());
        view.leaderEmailLabel.setText("Contact: " + infoOutputData.getLeaderEmail());
        view.descriptionField.setText(infoOutputData.getDescription());

        for (String member : infoOutputData.getMembers()) {
            view.membersListModel.addElement(member);
        }

    }

}
