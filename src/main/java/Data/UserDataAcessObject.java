package Data;

import Entity.Club;
import entity.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDataAcessObject implements UserDataAccess {
    private String csvFilePath;

    public UserDataAcessObject(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }
    @Override
    public void save(User user) {

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

            }
        }
        catch (IOException e) {

        }
        return users;
    }
}
