package Adapter.Club;

import View.club.InfoClubApp;
import use_case.club.InfoClubInputBoundary;
import use_case.club.InfoOutputData;

public class InfoClubController {
    private final InfoClubInputBoundary infoUsecase;

    public InfoClubController(InfoClubInputBoundary infoUsecase) {
        this.infoUsecase = infoUsecase;
    }

    public void execute(String clubName) {

        infoUsecase.showInfo(clubName);
    }
}
