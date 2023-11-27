package Adapter.Club;

import use_case.club.CreateInputBoundary;
import use_case.club.ShowingClubInputBoundary;

import java.util.ArrayList;

public class CreateClubController {
    private final CreateInputBoundary createUsecase;
    private final ShowingClubInputBoundary showingUsecase;

    public CreateClubController(CreateInputBoundary createUsecase, ShowingClubInputBoundary showingUsecase) {
        this.createUsecase = createUsecase;
        this.showingUsecase = showingUsecase;
    }

    public void execute(String name, String description, boolean joinable, String leader) {
        createUsecase.createClub(name, description, joinable, leader);
        showingUsecase.showAllClubs();
    }
}
