package use_case.club.InfoUsecase;

import Data.ClubDataAccess;
import Data.UserDataAccess;
import Entity.Club;

import java.util.ArrayList;
import java.util.List;

public class InfoClubUsecase implements InfoClubInputBoundary{
    private final ClubDataAccess clubDataAccess;
    private final UserDataAccess userDataAccess;
    private final InfoClubOutputBoundary infoClubPresenter;

    public InfoClubUsecase(ClubDataAccess clubDataAccess, UserDataAccess userDataAccess, InfoClubOutputBoundary infoClubPresenter) {
        this.clubDataAccess = clubDataAccess;
        this.userDataAccess = userDataAccess;
        this.infoClubPresenter = infoClubPresenter;
    }

    public void showInfo(String clubName) {
        String leader = "", email = "", description = "";
        List<String> members = new ArrayList<>();
        List<Club> clubs =  clubDataAccess.getClubs();
        for (Club c : clubs) {
            if (c.getName().equals(clubName)) {
                leader = userDataAccess.getUserNameFromID(c.getLeader());
                email = userDataAccess.getUserEmailFromID(c.getLeader());
                description = c.getDescription();
                for (int member : c.getUsers()) {
                    members.add(userDataAccess.getUserNameFromID(member));
                }
            }
        }
        infoClubPresenter.prepareInfoWindow(new InfoOutputData(clubName, leader, email, members, description));
    }
}
