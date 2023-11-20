package Adapter.Club;

import Entity.Club;
import use_case.club.CreateUsecase;

import java.util.ArrayList;

public class CreatingClubAdapter {
    private CreateUsecase createUsecase;

    public CreatingClubAdapter(CreateUsecase createUsecase) {
        this.createUsecase = createUsecase;
    }

    public void createClub(String name, String description, int id, Boolean joinable, ArrayList<Integer> users) {
        createUsecase.createClub(name, description, id, users);
    }
}
