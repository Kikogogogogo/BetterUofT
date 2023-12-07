package club;

import Adapter.Club.CreateClubController;
import Adapter.Club.CreateClubPresenter;
import Adapter.Club.ShowingClubPresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Data.UserDataAccess;
import Data.UserDataAcessObject;
import View.club.ClubApp;
import View.club.CreateClubApp;
import org.junit.Test;
import use_case.club.*;

public class TestCreateUsecase {
    @Test
    public void testCreateUsecase() {
        ClubDataAccess clubDataAccess = new ClubDataAccessObject("clubs.csv");
        UserDataAccess userDataAccess = new UserDataAcessObject("users.csv");
        ClubApp clubApp = new ClubApp();
        ShowingOutputBoundary showingPresenter = new ShowingClubPresenter(clubApp);
        ShowingClubInputBoundary showingUsecase = new ShowingUsecase(clubDataAccess, showingPresenter);
        CreateClubApp createClubApp = new CreateClubApp(showingUsecase);
        CreateOutputBoundary createPresenter = new CreateClubPresenter(createClubApp);
        CreateInputBoundary createUsecase = new CreateUsecase(clubDataAccess, userDataAccess, createPresenter);
        CreateClubController createClubController = new CreateClubController(createUsecase, showingUsecase);

        createClubController.execute("TestClub", "A club for testing", false, "Leo");
        createClubController.execute("TestClub", "A club for testing", false, "Leo");
        createClubController.execute("AnotherTest", "A club for testing", false, "123");
        createClubController.correctDescription("Random description");
    }
}
