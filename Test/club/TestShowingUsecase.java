package club;

import Adapter.Club.ShowingClubController;
import Adapter.Club.ShowingClubPresenter;
import Data.Club.ClubDataAccess;
import Data.Club.ClubDataAccessObject;
import View.club.ClubApp;
import org.junit.Test;
import use_case.club.ShowingUsecase.ShowingClubInputBoundary;
import use_case.club.ShowingUsecase.ShowingOutputBoundary;
import use_case.club.ShowingUsecase.ShowingUsecase;


public class TestShowingUsecase {
    @Test
    public void testShowingUsecase() {
        ClubDataAccess clubDataAccess = new ClubDataAccessObject("clubs.csv");
        ClubApp clubApp = new ClubApp();
        ShowingOutputBoundary showingPresenter = new ShowingClubPresenter(clubApp);
        ShowingClubInputBoundary showingUsecase = new ShowingUsecase(clubDataAccess, showingPresenter);
        ShowingClubController showingClubController = new ShowingClubController(showingUsecase);
        showingClubController.showAllClubs();
        showingClubController.showDescription(1);
        showingClubController.showJoinbale(1);
    }
}
