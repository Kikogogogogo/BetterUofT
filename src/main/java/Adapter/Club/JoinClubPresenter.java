package Adapter.Club;

import View.club.JoinClubApp;
import use_case.club.JoinUsecase.JoinInputData;
import use_case.club.JoinUsecase.JoinOutputBoundary;

import javax.swing.*;

public class JoinClubPresenter implements JoinOutputBoundary {
    private JoinClubApp view;

    public JoinClubPresenter(JoinClubApp view) {
        this.view = view;
    }

    public void showClubInfo(JoinInputData joinInputData) {
        view.clubNameLabel.setText("Club name: " + joinInputData.getClubName());
        view.leaderLabel.setText("Club leader: " + joinInputData.getLeader());
        for (String m : joinInputData.getMembers())
            view.membersListModel.addElement(m);
    }

    @Override
    public void prepareFailView(String message) {
        JOptionPane.showMessageDialog(view, message);
    }

    @Override
    public void prepareSuccessView(String message) {
        JOptionPane.showMessageDialog(view, message);
        view.setVisible(false);
    }
}
