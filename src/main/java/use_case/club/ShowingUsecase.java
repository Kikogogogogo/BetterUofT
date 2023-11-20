package use_case.club;

import Adapter.Club.ShowingClubPresenter;
import Data.ClubDataAccess;
import Entity.Club;

import java.util.ArrayList;
import java.util.List;

public class ShowingUsecase {
    private ClubDataAccess clubDataAccess;
    private ShowingOutputBoundary showingClubPresenter;

    public ShowingUsecase(ClubDataAccess clubDataAccess, ShowingOutputBoundary showingClubPresenter) {
        this.clubDataAccess = clubDataAccess;
        this.showingClubPresenter = showingClubPresenter;
    }

    public List<Club> getAllClubs() {
        return clubDataAccess.getClubs();
    }

    public void showClubDescription(int selection) {
        List<Club> clubs = clubDataAccess.getClubs();

        ShowingInputData inputData = new ShowingInputData(selection, clubs);
        showingClubPresenter.showClubDescription(inputData);
    }

    public void showAllClubs() {
        List<Club> clubs = clubDataAccess.getClubs();

        ShowingInputData inputData = new ShowingInputData(0, clubs);
        showingClubPresenter.showAllClubs(inputData);
    }
}
