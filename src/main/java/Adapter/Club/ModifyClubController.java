package Adapter.Club;

import use_case.club.ModifyClubUsecase;
import use_case.club.ModifyInputBoundary;

public class ModifyClubController {
    private final ModifyInputBoundary modifyClubUsecase;
    public ModifyClubController(ModifyInputBoundary modifyClubUsecase) {
        this.modifyClubUsecase = modifyClubUsecase;
    }

    public  void presentDescription(String clubName) {
        modifyClubUsecase.presentDescription(clubName);
    }
    public void setAllClubs(String name, String password) {
        modifyClubUsecase.getClubsFromLeader(name, password);
    }
    public void deleteClub(String name) {
        modifyClubUsecase.deleteClub(name);
    }
    public void modifyDescription(String clubName, String description) {
        modifyClubUsecase.modifyDescription(clubName, description);
    }

}
