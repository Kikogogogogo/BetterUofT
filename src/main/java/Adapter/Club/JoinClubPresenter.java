package Adapter.Club;

import View.club.JoinClubApp;
import use_case.club.JoinInputData;
import use_case.club.JoinOutputBoundary;

public class JoinClubPresenter implements JoinOutputBoundary {
    private JoinClubApp view;

    public JoinClubPresenter(JoinClubApp view) {
        this.view = view;
    }

    public void showClubName(JoinInputData joinInputData) {
        view.clubNameLabel.setText("Club name: " + joinInputData.getClubName());
        view.leaderLabel.setText("Club leader: " + joinInputData.getLeader());
    }
}
