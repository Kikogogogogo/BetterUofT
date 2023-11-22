package Adapter.Club;

import use_case.club.CreateInputBoundary;

import java.util.ArrayList;

public class CreateClubController {
    private final CreateInputBoundary createUsecase;

    public CreateClubController(CreateInputBoundary createUsecase) {
        this.createUsecase = createUsecase;
    }

    public void execute(String name, String description, boolean joinable) {
        createUsecase.createClub(name, description, joinable);
    }
}
