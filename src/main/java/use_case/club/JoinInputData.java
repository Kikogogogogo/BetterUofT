package use_case.club;

import java.util.List;

public class JoinInputData {
    private String clubName;
    private String leader;
    private List<String> members;

    public JoinInputData(String clubName) {
        this.clubName = clubName;
    }

    public String getClubName() {
        return clubName;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }
    public String getLeader() {
        return leader;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public List<String> getMembers() {
        return members;
    }

}
