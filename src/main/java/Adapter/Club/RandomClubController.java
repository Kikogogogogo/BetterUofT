package Adapter.Club;

import use_case.club.RandomInputBoundary;

public class RandomClubController {
    private final RandomInputBoundary randomUsecase;

    public RandomClubController(RandomInputBoundary randomUsecase) {
        this.randomUsecase = randomUsecase;
    }

    public void execute() {
        randomUsecase.getRandomClub();;
    }
}
