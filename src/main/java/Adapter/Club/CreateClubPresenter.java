package Adapter.Club;

import View.club.CreateClubApp;
import use_case.club.CreateOutputData;
import use_case.club.CreateOutputBoundary;

import javax.swing.*;

public class CreateClubPresenter implements CreateOutputBoundary {
    final CreateClubApp view;
    public CreateClubPresenter(CreateClubApp view) {
        this.view = view;
    }
    public void prepareSuccessView(CreateOutputData createOutputData) {
        JDialog d = new JDialog(view, createOutputData.getMessage());
        d.setVisible(true);
    }
}
