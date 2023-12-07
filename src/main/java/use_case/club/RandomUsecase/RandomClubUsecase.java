package use_case.club.RandomUsecase;

import Data.ClubDataAccess;
import Data.UserDataAccess;
import Entity.Club;
import View.club.JoinClubApp;
import use_case.club.JoinUsecase.JoinInputData;

import java.util.List;
import java.util.Random;

public class RandomClubUsecase implements RandomInputBoundary{
    private final ClubDataAccess clubDataAccess;
    private final UserDataAccess userDataAccess;
    private final RandomOutputBoundary randomPresenter;
    private Club randomClub;

    public RandomClubUsecase(ClubDataAccess clubDataAccess, UserDataAccess userDataAccess, RandomOutputBoundary randomPresenter){
        this.clubDataAccess = clubDataAccess;
        this.randomPresenter = randomPresenter;
        this.userDataAccess = userDataAccess;
    }

    public void getRandomClub() {
        List<Club> clubs = clubDataAccess.getClubs();
        Random rand = new Random();
        randomClub = clubs.get(rand.nextInt(clubs.size()));
        randomPresenter.prepareRandomClubResult(randomClub.getName(),
                userDataAccess.getUserNameFromID(randomClub.getLeader()), randomClub.getDescription(),
                randomClub.getJoinable());
    }

    public void joinRandomClub() {
        if (!randomClub.getJoinable()) {
            randomPresenter.prepareFailView("This club is not joinable!");
        }
        else {
            JoinClubApp joinClubApp = new JoinClubApp(new JoinInputData(randomClub.getName()));
            joinClubApp.setVisible(true);
        }
    }
}
