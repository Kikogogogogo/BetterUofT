package Adapter.Club;

import use_case.club.ModifyClubUsecase;
import use_case.club.ModifyInputBoundary;

public class ModifyClubController {
    private final ModifyInputBoundary modifyClubUsecase;
    public ModifyClubController(ModifyInputBoundary modifyClubUsecase) {
        this.modifyClubUsecase = modifyClubUsecase;
    }

    public void setAllClubs(String name, String password) {
        modifyClubUsecase.getClubsFromLeader(name, password);
    }
    public void deleteClub(String name) {
        modifyClubUsecase.deleteClub(name);
    }

}
