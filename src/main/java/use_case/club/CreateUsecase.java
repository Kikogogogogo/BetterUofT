package use_case.club;

import Data.ClubDataAccess;
import Data.UserDataAccess;
import Entity.Club;

import java.util.ArrayList;
import java.util.List;

public class CreateUsecase implements CreateInputBoundary{
    private final ClubDataAccess clubDataAccess;
    private final UserDataAccess userDataAccess;
    private final CreateOutputBoundary createClubPresenter;

    public CreateUsecase(ClubDataAccess clubDataAccess, UserDataAccess userDataAccess,CreateOutputBoundary createClubPresenter) {
        this.clubDataAccess = clubDataAccess;
        this.userDataAccess = userDataAccess;
        this.createClubPresenter = createClubPresenter;
    }

    public void createClub(String name, String description, boolean joinable, String leaderName) {
        List<Club> clubs = clubDataAccess.getClubs();
        List<entity.User> users = userDataAccess.getUsers();
        int id = -1;
        for (Club c : clubs) {
            if (id < c.getId())
                id = c.getId();
            if (name.equals(c.getName())){
                createClubPresenter.prepareFailView(new CreateOutputData(false,
                        "There is already a club with this name, please try again!"));
                return;
            }
        }
        int leader;

        Club club = new Club(name, description, id + 1, joinable, new ArrayList<>());
        clubDataAccess.save(club);
        createClubPresenter.prepareSuccessView(new CreateOutputData(true,
                "The club is successfully created!"));
    }
}
