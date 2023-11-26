package use_case.club;

import Data.ClubDataAccess;
import Entity.Club;

import java.util.ArrayList;
import java.util.List;

public class CreateUsecase implements CreateInputBoundary{
    private final ClubDataAccess clubDataAccess;
    private final CreateOutputBoundary createClubPresenter;

    public CreateUsecase(ClubDataAccess clubDataAccess, CreateOutputBoundary createClubPresenter) {
        this.clubDataAccess = clubDataAccess;
        this.createClubPresenter = createClubPresenter;
    }

    public void createClub(String name, String description, boolean joinable) {
        List<Club> clubs = clubDataAccess.getClubs();
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
        Club club = new Club(name, description, id + 1, joinable, new ArrayList<>());
        clubDataAccess.save(club);
        createClubPresenter.prepareSuccessView(new CreateOutputData(true,
                "The club is successfully created!"));
    }
}
