package use_case.club;

import Data.ClubDataAccess;
import Entity.Club;

import java.util.List;

public class ShowingUsecase {
    private ClubDataAccess clubDataAccess;

    public ShowingUsecase(ClubDataAccess clubDataAccess) {
        this.clubDataAccess = clubDataAccess;
    }

    public List<Club> getAllClubs() {
        return clubDataAccess.getClubs();
    }
}
