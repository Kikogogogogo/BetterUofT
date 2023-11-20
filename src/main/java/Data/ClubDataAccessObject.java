package Data;

import Entity.Club;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ClubDataAccessObject implements ClubDataAccess{
    private String csvFilePath;
    public ClubDataAccessObject(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    @Override
    public void save(Club club) {
        StringBuilder userString = new StringBuilder();

        for (int user : club.getUsers()) {
            userString.append(user).append(",");
        }
        int joinable = club.getJoinable() ? 1 : 0;
        String line = String.format("%s,%s,%s,%s,%s\n",
                club.getName(), club.getDescription(), club.getId(),
                joinable, userString);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath, true))) {;
            writer.write(line);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<Club> getClubs() {
        List<Club> clubs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine();
            String line;
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                boolean joinable = (Integer.parseInt(values[3]) == 1);

                ArrayList<Integer> members = new ArrayList<>();
                for (int i = 4; i < values.length ; i++) {
                    members.add(Integer.parseInt(values[i]));
                }
                Club club = new Club(values[0], values[1], Integer.parseInt(values[2]), joinable, members);
                clubs.add(club);
            }
        }
        catch (IOException e) {

        }
        return clubs;
    }

}
