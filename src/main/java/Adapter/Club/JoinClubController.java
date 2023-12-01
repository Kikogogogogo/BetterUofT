package Adapter.Club;

import use_case.club.JoinInputBoundary;
import use_case.club.JoinInputData;
import use_case.club.JoinUsecase;

public class JoinClubController {
    private JoinInputBoundary joinUsecase;
    public JoinClubController(JoinInputBoundary joinUsecase) {
        this.joinUsecase = joinUsecase;
    }

    public void showClubInfo(JoinInputData joinInputData) {
        joinUsecase.showClubInfo(joinInputData);
    }

    public void execute(JoinInputData joinInputData) {
        joinUsecase.joinClub(joinInputData);
    }
}
