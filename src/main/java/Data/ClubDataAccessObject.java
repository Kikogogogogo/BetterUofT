package Data;

import Entity.Club;

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
        String line = String.format("%s,%s,%s,%s,%s",
                club.getName(), club.getDescription(), club.getId(),
                club.getJoinable(), club.getUsers());

        try {
            BufferedWriter writer= new BufferedWriter(new FileWriter(csvFilePath));
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
            String line;
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                boolean joinable = (Integer.parseInt(values[3]) == 1);
//                Club club = new Club(values[0], values[1], values[2], joinable, values[4]);
            }
        }
        catch (IOException e) {

        }
    }
}
