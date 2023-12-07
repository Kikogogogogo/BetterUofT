package club;

import Adapter.Club.JoinClubPresenter;
import Data.Club.ClubDataAccess;
import Data.Club.ClubDataAccessObject;
import Data.Club.UserDataAccess;
import Data.Club.UserDataAcessObject;
import View.club.JoinClubApp;
import org.junit.Test;
import use_case.club.JoinUsecase.JoinInputBoundary;
import use_case.club.JoinUsecase.JoinInputData;
import use_case.club.JoinUsecase.JoinOutputBoundary;
import use_case.club.JoinUsecase.JoinUsecase;

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