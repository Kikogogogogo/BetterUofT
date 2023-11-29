package use_case.club;

public class JoinInputData {
    private String clubName;
    private String leader;

    public JoinInputData(String clubName, String leader) {
        this.clubName = clubName;
        this.leader = leader;
    }

    public String getClubName() {
        return clubName;
    }

    public String getLeader() {
        return leader;
    }
}
