package use_case.club.JoinUsecase;

import java.util.List;

public class JoinInputData {
    private String clubName;
    private String leader;
    private List<String> members;
    private String userName;
    private String password;

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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
