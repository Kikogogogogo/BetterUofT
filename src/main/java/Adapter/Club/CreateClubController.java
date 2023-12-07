package Adapter.Club;

import use_case.club.CreateUsecase.CreateInputBoundary;
import use_case.club.ShowingUsecase.ShowingClubInputBoundary;

public class CreateClubController {
    private final CreateInputBoundary createUsecase;
    private final ShowingClubInputBoundary showingUsecase;

    public CreateClubController(CreateInputBoundary createUsecase, ShowingClubInputBoundary showingUsecase) {
        this.createUsecase = createUsecase;
        this.showingUsecase = showingUsecase;
    }

    public void correctDescription(String originalDescription) {
        createUsecase.correctDescription(originalDescription);
    }
    public void execute(String name, String description, boolean joinable, String leader) {
        if (createUsecase.createClub(name, description, joinable, leader)) {
            showingUsecase.showAllClubs();
        }
    }
}
