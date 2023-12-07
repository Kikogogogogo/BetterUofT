package use_case.club.RandomUsecase;

public interface RandomOutputBoundary {
    public void prepareRandomClubResult(String name, String leader, String description, boolean joinable);
    public void prepareFailView(String message);
}
