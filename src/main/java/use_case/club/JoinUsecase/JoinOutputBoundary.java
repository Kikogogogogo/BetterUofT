package use_case.club.JoinUsecase;

public interface JoinOutputBoundary {
    public void showClubInfo(JoinInputData joinInputData);
    public void prepareFailView(String message);
    public void prepareSuccessView(String message);
}
