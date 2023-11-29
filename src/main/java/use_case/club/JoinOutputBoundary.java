package use_case.club;

public interface JoinOutputBoundary {
    public void showClubInfo(JoinInputData joinInputData);
    public void prepareFailView(String message);
    public void prepareSuccessView(String message);
}
