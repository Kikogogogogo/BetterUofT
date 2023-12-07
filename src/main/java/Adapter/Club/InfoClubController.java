package Adapter.Club;

import use_case.club.InfoUsecase.InfoClubInputBoundary;

public class InfoClubController {
    private final InfoClubInputBoundary infoUsecase;

    public InfoClubController(InfoClubInputBoundary infoUsecase) {
        this.infoUsecase = infoUsecase;
    }

    public void execute(String clubName) {

        infoUsecase.showInfo(clubName);
    }
}
