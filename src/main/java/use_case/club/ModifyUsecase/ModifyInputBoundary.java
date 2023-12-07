package use_case.club.ModifyUsecase;

public interface ModifyInputBoundary {
    public void getClubsFromLeader(String userName, String password);
    public void presentDescription(String clubName);
    public void modifyDescription(String clubName, String description);
    public void deleteClub(String name);
}
