package use_case.club;

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

    public void modifyDescription(String clubName, String description) {
        clubDataAccess.modifyDescription(clubName, description);
        modifyPresenter.prepareSuccessView("The description is modified!");
    }

    @Override
    public void deleteClub(String name) {
        clubDataAccess.deleteClub(name);
        modifyPresenter.prepareSuccessView("The club is deleted!");
    }
}
