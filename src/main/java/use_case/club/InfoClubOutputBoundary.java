package use_case.club;

public interface InfoClubOutputBoundary {
    public void prepareFailedView(String message);
    public void prepareInfoWindow(InfoOutputData infoOutputData);
}
