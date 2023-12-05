package club;

import Adapter.Club.ModifyClubController;
import Adapter.Club.ModifyClubPresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Data.UserDataAccess;
import Data.UserDataAcessObject;
import View.club.ModifyClubApp;
import org.junit.Test;
import use_case.club.ModifyClubUsecase;
import use_case.club.ModifyInputBoundary;
import use_case.club.ModifyOutputBoundary;

public class TestModifyUsecase {
    @Test
    public void testModifyUsecase() {
        ClubDataAccess clubDataAccess = new ClubDataAccessObject("clubs.csv");
        UserDataAccess userDataAccess = new UserDataAcessObject("users.csv");
        ModifyClubApp modifyClubApp = new ModifyClubApp();
        ModifyOutputBoundary modifyPresenter = new ModifyClubPresenter(modifyClubApp);
        ModifyInputBoundary modifyUsecase = new ModifyClubUsecase(clubDataAccess, userDataAccess, modifyPresenter);
        ModifyClubController modifyClubController = new ModifyClubController(modifyUsecase);


        modifyClubController.modifyDescription("Music Club", "Explore the world of music and learn more.");
        modifyClubController.modifyDescription(null, "123");
        modifyClubController.presentDescription("Music Club");
        modifyUsecase.getClubsFromLeader("Leo", "123456");
        modifyUsecase.getClubsFromLeader("", "123456");
        modifyUsecase.getClubsFromLeader("Leo", "123");

        modifyClubController.deleteClub("TestClub");
        modifyClubController.setAllClubs("Leo", "123456");
    }
}
