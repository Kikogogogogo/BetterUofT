package Data;

import Entity.User;

import java.util.List;

public interface UserDataAccess {
    public void save(User user);
    public List<User> getUsers();
    public String getUserNameFromID(int id);
    public int getUserIDFromName(String userName);
}
