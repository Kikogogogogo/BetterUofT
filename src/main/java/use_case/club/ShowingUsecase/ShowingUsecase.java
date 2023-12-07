package use_case.club.ShowingUsecase;

import Data.ClubDataAccess;
import Entity.Club;

import java.util.List;

public class ShowingUsecase implements ShowingClubInputBoundary{
    private ClubDataAccess clubDataAccess;
    private ShowingOutputBoundary showingClubPresenter;

    public ShowingUsecase(ClubDataAccess clubDataAccess, ShowingOutputBoundary showingClubPresenter) {
        this.clubDataAccess = clubDataAccess;
        this.showingClubPresenter = showingClubPresenter;
    }

    public void showClubDescription(int selection) {
        List<Club> clubs = clubDataAccess.getClubs();

        ShowingInputData inputData = new ShowingInputData(selection, clubs);
        showingClubPresenter.showClubDescription(inputData);
    }

    public void showClubJoinable(int selection) {
        List<Club> clubs = clubDataAccess.getClubs();

        ShowingInputData inputData = new ShowingInputData(selection, clubs);
        showingClubPresenter.showClubJoinable(inputData);
    }
    public void showAllClubs() {
        List<Club> clubs = clubDataAccess.getClubs();

        ShowingInputData inputData = new ShowingInputData(0, clubs);
        showingClubPresenter.showAllClubs(inputData);
    }
}
