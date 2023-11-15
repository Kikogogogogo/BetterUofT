package Adapter;

import Entity.Club;
import use_case.club.ShowingUsecase;

import java.util.List;

public class ShowingClubAdapter {
    private ShowingUsecase showingUsecase;

    public ShowingClubAdapter(ShowingUsecase showingUsecase) {
        this.showingUsecase = showingUsecase;
    }

    public List<Club> getAllClubs() {
        return showingUsecase.getAllClubs();
    }

}
