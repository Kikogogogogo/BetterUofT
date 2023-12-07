package club;

import Adapter.Club.InfoClubPresenter;
import Data.Club.ClubDataAccess;
import Data.Club.ClubDataAccessObject;
import Data.Club.UserDataAccess;
import Data.Club.UserDataAcessObject;
import View.club.InfoClubApp;
import org.junit.Test;
import use_case.club.InfoUsecase.InfoClubOutputBoundary;
import use_case.club.InfoUsecase.InfoClubUsecase;
import use_case.club.InfoUsecase.InfoClubInputBoundary;

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
