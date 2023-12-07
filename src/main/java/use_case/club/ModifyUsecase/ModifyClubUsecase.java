package use_case.club.ModifyUsecase;

import Data.ClubDataAccess;
import Data.UserDataAccess;
import Entity.Club;

import java.util.ArrayList;
import java.util.List;

public class ModifyClubUsecase implements ModifyInputBoundary {
    private final ClubDataAccess clubDataAccess;
    private final UserDataAccess userDataAccess;
    private final ModifyOutputBoundary modifyPresenter;

    public ModifyClubUsecase(ClubDataAccess clubDataAccess, UserDataAccess userDataAccess, ModifyOutputBoundary modifyPresenter) {
        this.clubDataAccess = clubDataAccess;
        this.userDataAccess = userDataAccess;
        this.modifyPresenter = modifyPresenter;
    }

    @Override
    public void getClubsFromLeader(String userName, String password) {
        List<String> clubList = new ArrayList<>();
        switch (userDataAccess.checkUserPassword(userName, password)) {
            case -1: {
                modifyPresenter.prepareFailView("The password is not correct!");
                break;
            }
            case -2: {
                modifyPresenter.prepareFailView("Username does not exist!");
            }
            case 1: {
                for (Club club : clubDataAccess.getClubs()) {
                    if (userName.equals(userDataAccess.getUserNameFromID(club.getLeader()))) {
                        clubList.add(club.getName());
                    }
                }
            }
        }
        modifyPresenter.setClubList(clubList);
    }

    @Override
    public void presentDescription(String clubName) {
        for (Club c : clubDataAccess.getClubs()){
            if (clubName.equals(c.getName()))
                modifyPresenter.setDescription(c.getDescription());
        }
    }

    public void modifyDescription(String clubName, String description) {
        if (clubName == null)
            modifyPresenter.prepareFailView("You have not selected any club!");
        else {
            clubDataAccess.modifyDescription(clubName, description);
            modifyPresenter.prepareSuccessView("The description is modified!");
        }
    }

    @Override
    public void deleteClub(String name) {
        if (modifyPresenter.prepareConfirmView("Are you sure you want to delete this club?") == 0) {
            clubDataAccess.deleteClub(name);
            modifyPresenter.prepareSuccessView("The club is deleted!");
        }
    }
}
