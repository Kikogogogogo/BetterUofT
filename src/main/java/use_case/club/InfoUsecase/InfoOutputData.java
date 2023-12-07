package use_case.club.InfoUsecase;

import java.util.List;

public class InfoOutputData {
    public String clubName;
    public String leaderName;
    public String leaderEmail;
    public List<String> members;
    public String description;

    public InfoOutputData(String clubName, String leaderName, String leaderEmail, List<String> members, String description) {
        this.clubName = clubName;
        this.leaderName = leaderName;
        this.leaderEmail = leaderEmail;
        this.members = members;
        this.description = description;
    }

    public String getClubName() {
        return clubName;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public String getLeaderEmail() {
        return leaderEmail;
    }

    public List<String> getMembers() {
        return members;
    }

    public String getDescription() {
        return description;
    }

}
