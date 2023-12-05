package use_case.club;

import Adapter.Club.JoinClubPresenter;
import Data.ClubDataAccess;
import Data.UserDataAccess;
import Entity.Club;
import Entity.User;

import java.util.ArrayList;
import java.util.List;

public class JoinUsecase implements JoinInputBoundary{

    private ClubDataAccess clubDataAccess;
    private UserDataAccess userDataAccess;
    private JoinOutputBoundary joinPresenter;

    public JoinUsecase(ClubDataAccess clubDataAccess, UserDataAccess userDataAccess, JoinOutputBoundary joinPresenter) {
        this.clubDataAccess = clubDataAccess;
        this.joinPresenter = joinPresenter;
        this.userDataAccess = userDataAccess;
    }

    public void showClubInfo(JoinInputData joinInputData) {
        List<Club> clubs = clubDataAccess.getClubs();
        List<String> members = new ArrayList<>();
        String leader = "";
        for (Club c : clubs) {
            if (c.getName().equals(joinInputData.getClubName())) {
                for (int member : c.getUsers()) {
                    members.add(userDataAccess.getUserNameFromID(member));
                }
                leader = userDataAccess.getUserNameFromID(c.getLeader());
                break;
            }

        }
        joinInputData.setMembers(members);
        joinInputData.setLeader(leader);
        joinPresenter.showClubInfo(joinInputData);
    }

    public void joinClub(JoinInputData joinInputData) {
        int status = userDataAccess.checkUserPassword(joinInputData.getUserName(), joinInputData.getPassword());
        switch (status) {
            case 1: {
                clubDataAccess.joinClub(joinInputData.getClubName(), userDataAccess.getUserIDFromName(joinInputData.getUserName()));
                joinPresenter.prepareSuccessView("You have joined the club " + joinInputData.getClubName());
                return;
            }
            case -1: {
                joinPresenter.prepareFailView("The password is not correct!");
                return;
            }
            case -2: {
                joinPresenter.prepareFailView("The username does not exist!");
            }
        }
    }
}
