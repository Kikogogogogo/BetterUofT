package Adapter.Club;

import View.club.CreateClubApp;
import use_case.club.CreateUsecase.CreateOutputData;
import use_case.club.CreateUsecase.CreateOutputBoundary;

import javax.swing.*;

public class CreateClubPresenter implements CreateOutputBoundary {
    final CreateClubApp view;
    public CreateClubPresenter(CreateClubApp view) {
        this.view = view;
    }

    @Override
    public void modifyDescription(String description) {
        view.descriptionField.removeAll();
        view.descriptionField.setText(description);
    }

    public void prepareSuccessView(CreateOutputData createOutputData) {
        JOptionPane.showMessageDialog(view, createOutputData.getMessage());
        view.setVisible(false);
    }

    @Override
    public void prepareFailView(CreateOutputData createOutputData) {
        JOptionPane.showMessageDialog(view, createOutputData.getMessage());
    }
}
