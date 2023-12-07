package Entity.Club;

import java.util.ArrayList;

public class Club {
    String name;
    String description;
    int id;
    int leader;
    Boolean joinable;
    ArrayList<Integer> users;

    public Club(String name, String description, int id, Boolean joinable, ArrayList<Integer> users, int leader) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.joinable = joinable;
        this.users = users;
        this.leader = leader;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public Boolean getJoinable() {
        return joinable;
    }

    public ArrayList<Integer> getUsers() {
        return users;
    }

    public int getLeader() {
        return leader;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) { this.description = description; }

}
