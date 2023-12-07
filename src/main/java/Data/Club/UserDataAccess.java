package Data.Club;

import Entity.Club.User;

import java.util.List;

public interface UserDataAccess {
    public void save(User user);
    public List<User> getUsers();
    public String getUserNameFromID(int id);
    public int getUserIDFromName(String userName);
    public String getUserEmailFromID(int id);
    public int checkUserPassword(String username, String password);
}
