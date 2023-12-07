package Adapter.Club;

import View.club.RandomClubApp;
import use_case.club.RandomUsecase.RandomOutputBoundary;

import javax.swing.*;

public class RandomClubPresenter implements RandomOutputBoundary {
    private final RandomClubApp view;
    public RandomClubPresenter(RandomClubApp view) {
        this.view = view;
    }
    @Override
    public void prepareRandomClubResult(String name, String leader, String description, boolean joinable) {
        view.clubLabel.setText("Club Name: " + name);
        view.leaderLabel.setText("Leader: " + leader);
        view.joinabelLabel.setText("Joinable: " + (joinable ? "Yes" : "No"));
        view.descriptionField.setText(description);
    }

    @Override
    public void prepareFailView(String message) {
        JOptionPane.showMessageDialog(view, message);
    }

}
