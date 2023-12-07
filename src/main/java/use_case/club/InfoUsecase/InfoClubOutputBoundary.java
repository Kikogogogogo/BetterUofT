package use_case.club.InfoUsecase;

public interface InfoClubOutputBoundary {
    public void prepareFailedView(String message);
    public void prepareInfoWindow(InfoOutputData infoOutputData);
}
