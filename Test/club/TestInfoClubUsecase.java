package club;

import Adapter.Club.InfoClubPresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Data.UserDataAccess;
import Data.UserDataAcessObject;
import View.club.InfoClubApp;
import org.junit.Test;
import use_case.club.InfoClubInputBoundary;
import use_case.club.InfoClubOutputBoundary;
import use_case.club.InfoClubUsecase;

public class TestInfoClubUsecase {
    @Test
    public void testInfoUsecase() {
        ClubDataAccess clubDataAccess = new ClubDataAccessObject("clubs.csv");
        UserDataAccess userDataAccess = new UserDataAcessObject("users.csv");
        InfoClubApp infoClubApp = new InfoClubApp(clubDataAccess, userDataAccess, "Music Club");
        InfoClubOutputBoundary infoPresenter = new InfoClubPresenter(infoClubApp);
        InfoClubInputBoundary infoUsecase = new InfoClubUsecase(clubDataAccess, userDataAccess, infoPresenter);
        infoUsecase.showInfo("Music Club");
    }
}
