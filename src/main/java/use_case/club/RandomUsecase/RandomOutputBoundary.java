package use_case.club.RandomUsecase;

import Entity.Club;

public interface RandomOutputBoundary {
    public void prepareRandomClubResult(String name, String leader, String description, boolean joinable);
    public void prepareFailView(String message);
}
