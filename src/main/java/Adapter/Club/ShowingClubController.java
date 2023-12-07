package Adapter.Club;

import use_case.club.ShowingUsecase.ShowingClubInputBoundary;

public class ShowingClubController {
    private final ShowingClubInputBoundary showingUsecase;
    public ShowingClubController(ShowingClubInputBoundary showingUsecase) {
        this.showingUsecase = showingUsecase;
    }
    public void showAllClubs() {
        showingUsecase.showAllClubs();
    }

    public void showDescription(int selection) {
        showingUsecase.showClubDescription(selection);
    }

    public void showJoinbale(int selection) {
        showingUsecase.showClubJoinable(selection);
    }
}
