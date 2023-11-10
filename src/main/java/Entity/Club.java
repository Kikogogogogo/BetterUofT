package entity;

import java.util.ArrayList;

public class Club {
    String name;
    String description;
    String id;
    Boolean joinable;
    ArrayList<String> users;

    public Club(String name, String description, String id, Boolean joinable, ArrayList<String> users) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.joinable = joinable;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public Boolean getJoinable() {
        return joinable;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setJoinable(Boolean joinable) {
        this.joinable = joinable;
    }

    public void join(String user) {
        users.add(user);
    }

    public void leave(String user) {
        users.remove(user);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) { this.description = description; }

    public boolean joined(String user) {
        return users.contains(user);
    }

}
