package Entity;

import entity.User;

import java.util.ArrayList;

public class Club {
    String name;
    String description;
    int id;
    Boolean joinable;
    ArrayList<Integer> users;

    public Club(String name, String description, int id, Boolean joinable, ArrayList<Integer> users) {
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

    public int getId() {
        return id;
    }

    public Boolean getJoinable() {
        return joinable;
    }

    public ArrayList<Integer> getUsers() {
        return users;
    }

    public void setJoinable(Boolean joinable) {
        this.joinable = joinable;
    }

    public void join(int user) {
        users.add(user);
    }

    public void leave(int user) {
        users.remove(user);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) { this.description = description; }

    public boolean joined(int user) {
        return users.contains(user);
    }

}
