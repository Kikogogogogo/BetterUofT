package club;

import Adapter.Club.RandomClubController;
import Adapter.Club.RandomClubPresenter;
import Data.Club.ClubDataAccess;
import Data.Club.ClubDataAccessObject;
import Data.Club.UserDataAccess;
import Data.Club.UserDataAcessObject;
import View.club.RandomClubApp;
import org.junit.Test;
import use_case.club.RandomUsecase.RandomClubUsecase;
import use_case.club.RandomUsecase.RandomInputBoundary;
import use_case.club.RandomUsecase.RandomOutputBoundary;

public class TestRandomUsecase {
    @Test
    public void testRandomUsecase() {
        ClubDataAccess clubDataAccess = new ClubDataAccessObject("clubs.csv");
        UserDataAccess userDataAccess = new UserDataAcessObject("users.csv");
        RandomClubApp randomClubApp = new RandomClubApp(clubDataAccess, userDataAccess);
        RandomOutputBoundary randomPresenter = new RandomClubPresenter(randomClubApp);
        RandomInputBoundary randomUsecase = new RandomClubUsecase(clubDataAccess, userDataAccess, randomPresenter);
        RandomClubController randomClubController = new RandomClubController(randomUsecase);

        randomClubController.execute();
        randomUsecase.joinRandomClub();
    }
}
