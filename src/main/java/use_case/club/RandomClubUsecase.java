package use_case.club;

import Adapter.Club.InfoClubPresenter;
import Data.ClubDataAccess;
import Entity.Club;

import java.util.List;
import java.util.Random;

public class RandomClubUsecase implements RandomInputBoundary{
    private final ClubDataAccess clubDataAccess;
    private final RandomOutputBoundary randomPresenter;

    public RandomClubUsecase(ClubDataAccess clubDataAccess, RandomOutputBoundary infoPresenter){
        this.clubDataAccess = clubDataAccess;
        this.randomPresenter = infoPresenter;
    }

    public void getRandomClub() {
        List<Club> clubs = clubDataAccess.getClubs();
        Random rand = new Random();
        Club randomClub = clubs.get(rand.nextInt(clubs.size()));
        randomPresenter.prepareRandomClubResult(randomClub);
    }
}
