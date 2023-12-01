package use_case.club;

import Adapter.Club.JoinClubPresenter;
import Data.ClubDataAccess;

public interface JoinInputBoundary {
    public void showClubInfo(JoinInputData joinInputData);
    public void joinClub(JoinInputData joinInputData);
}
