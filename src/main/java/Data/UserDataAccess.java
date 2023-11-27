package Data;

import java.util.List;

public interface UserDataAccess {
    public void save(entity.User user);
    public List<entity.User> getUsers();
    public String getUserNameFromID(int id);
    public int getUserIDFromName(String userName);
}
