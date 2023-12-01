package Adapter.Club;

import View.club.ClubApp;
import use_case.club.InfoClubOutputBoundary;
import use_case.club.InfoClubUsecase;
import use_case.club.InfoOutputData;

import javax.swing.*;

public class InfoClubPresenter implements InfoClubOutputBoundary {
    final ClubApp view;
    public InfoClubPresenter(ClubApp view) {
        this.view = view;
    }

    public void prepareInfoWindow(InfoOutputData infoOutputData) {
        JFrame infoWindow = new JFrame();
    }

}
