package use_case.club.CreateUsecase;

import API.AutoCorrect;
import API.ClubAutoCorrect;
import Data.Club.ClubDataAccess;
import Data.Club.UserDataAccess;
import Entity.Club.Club;
import Entity.Club.User;

import java.util.ArrayList;
import java.util.List;

public class CreateUsecase implements CreateInputBoundary{
    private final ClubDataAccess clubDataAccess;
    private final UserDataAccess userDataAccess;
    private final CreateOutputBoundary createClubPresenter;

    public CreateUsecase(ClubDataAccess clubDataAccess, UserDataAccess userDataAccess, CreateOutputBoundary createClubPresenter) {
        this.clubDataAccess = clubDataAccess;
        this.userDataAccess = userDataAccess;
        this.createClubPresenter = createClubPresenter;
    }

    @Override
    public void correctDescription(String description) {
        AutoCorrect autoCorrect = new ClubAutoCorrect();
        createClubPresenter.modifyDescription(autoCorrect.getCorrectedText(description));
    }

    public boolean createClub(String name, String description, boolean joinable, String leaderName) {
        List<Club> clubs = clubDataAccess.getClubs();
        List<User> users = userDataAccess.getUsers();
        int id = -1;
        for (Club c : clubs) {
            if (id < c.getId())
                id = c.getId();
            if (name.equals(c.getName())){
                createClubPresenter.prepareFailView(new CreateOutputData("There is already a club with this name, please try again!"));
                return false;
            }
        }
        int leaderID = userDataAccess.getUserIDFromName(leaderName);
        if (leaderID == -1) {
            createClubPresenter.prepareFailView(new CreateOutputData("The user does not exist!"));
            return false;
        }
        Club club = new Club(name, description, id + 1, joinable, new ArrayList<>(), leaderID);
        clubDataAccess.save(club);
        createClubPresenter.prepareSuccessView(new CreateOutputData("The club is successfully created!"));
        return true;
    }
}
