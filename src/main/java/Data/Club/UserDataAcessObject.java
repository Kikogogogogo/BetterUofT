package Data.Club;

import Entity.Club.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDataAcessObject implements UserDataAccess {
    private String csvFilePath;

    public UserDataAcessObject(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }
    @Override
    public void save(User user) {
        String line = String.format("%s,%s,%s,%s,%s,%s\n", user.getUsername(),
        user.getPassword(), user.getId(), user.getEmail(), user.getMajor(), user.getYearJoined());


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true))) {;
            writer.write(line);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine();
            String line;
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                User u = new User(values[0], values[1], Integer.parseInt(values[2]), values[3], values[4], values[5]);
                users.add(u);
            }
        }
        catch (IOException e) {

        }
        return users;
    }

    @Override
    public String getUserNameFromID(int id) {
        List<User> users = getUsers();
        for (User u : users) {
            if (id == u.getId())
                return u.getUsername();
        }
        return null;
    }

    @Override
    public int getUserIDFromName(String userName) {
        List<User> users = getUsers();
        for (User u : users) {
            if (userName.equals(u.getUsername()))
                return u.getId();
        }
        return -1;
    }

    @Override
    public String getUserEmailFromID(int id) {
        List<User> users = getUsers();
        for (User u : users) {
            if (id == u.getId())
                return u.getEmail();
        }
        return null;
    }

    @Override
    public int checkUserPassword(String usename, String password) {
        List<User> users = getUsers();
        for (User u : users) {
            if (u.getUsername().equals(usename)) {
                if (u.getPassword().equals(password)) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        }
        return -2;
    }


}
