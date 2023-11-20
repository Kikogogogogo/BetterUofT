package use_case.club;

import Data.ClubDataAccess;
import Entity.Club;

import java.util.ArrayList;

public class CreateUsecase {
    private final ClubDataAccess clubDataAccess;

    public CreateUsecase(ClubDataAccess clubDataAccess) {
        this.clubDataAccess = clubDataAccess;
    }

    public void createClub(String name, String description, int id, ArrayList<Integer> users) {
        Club club = new Club(name, description, id, true, users);
        clubDataAccess.save(club);
    }
}
