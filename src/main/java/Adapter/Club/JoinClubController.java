package Adapter.Club;

import use_case.club.JoinUsecase.JoinInputBoundary;
import use_case.club.JoinUsecase.JoinInputData;

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
