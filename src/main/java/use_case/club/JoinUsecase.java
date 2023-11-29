package use_case.club;

import Adapter.Club.JoinClubPresenter;
import Data.ClubDataAccess;

public class JoinUsecase implements JoinInputBoundary{

    private ClubDataAccess clubDataAccess;
    private JoinOutputBoundary joinPresenter;

    public JoinUsecase(ClubDataAccess clubDataAccess, JoinOutputBoundary joinPresenter) {
        this.clubDataAccess = clubDataAccess;
        this.joinPresenter = joinPresenter;
    }

    public void showClubInfo(JoinInputData joinInputData) {
        joinPresenter.showClubName(joinInputData);
    }
}
