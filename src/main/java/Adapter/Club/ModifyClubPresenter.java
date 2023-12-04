package Adapter.Club;

import View.club.ModifyClubApp;
import use_case.club.JoinUsecase;
import use_case.club.ModifyOutputBoundary;

import javax.swing.*;
import java.util.List;

public class ModifyClubPresenter implements ModifyOutputBoundary {
    private final ModifyClubApp view;

    public ModifyClubPresenter(ModifyClubApp view) {
        this.view = view;
    }

    @Override
    public void setClubList(List<String> clubNames) {
        view.clubListModel.removeAllElements();
        view.clubListModel.addAll(clubNames);
    }

    @Override
    public void prepareSuccessView(String message) {
        JOptionPane.showMessageDialog(view, message);
    }

    @Override
    public void prepareFailView(String message) {
        JOptionPane.showMessageDialog(view, message);
    }
}
