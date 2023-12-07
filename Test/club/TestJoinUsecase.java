package club;

import Adapter.Club.JoinClubPresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Data.UserDataAccess;
import Data.UserDataAcessObject;
import View.club.JoinClubApp;
import org.junit.Test;
import use_case.club.JoinInputBoundary;
import use_case.club.JoinInputData;
import use_case.club.JoinOutputBoundary;
import use_case.club.JoinUsecase;

public class TestJoinUsecase {

    @Test
    public void testJoinClub() {
        JoinInputData joinInputData = new JoinInputData("Music Club");
        JoinClubApp joinClubApp = new JoinClubApp(joinInputData);
        ClubDataAccess clubDataAccess = new ClubDataAccessObject("clubs.csv");
        UserDataAccess userDataAccess = new UserDataAcessObject("users.csv");
        JoinOutputBoundary joinClubPresenter = new JoinClubPresenter(joinClubApp);
        JoinInputBoundary joinUsecase = new JoinUsecase(clubDataAccess, userDataAccess, joinClubPresenter);
        joinInputData.setUserName("Leo");
        joinInputData.setPassword("123456");
        joinUsecase.joinClub(joinInputData);

        joinInputData.setUserName("Oel");
        joinInputData.setPassword("123456");
        joinUsecase.joinClub(joinInputData);

        joinInputData.setUserName("Leo");
        joinInputData.setPassword("123");
        joinUsecase.joinClub(joinInputData);

    }
}
