package Data;

import Entity.Club;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashSet;
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
        String line = String.format("%s,%s,%s,%s,%s,%s\n",
                club.getName(), club.getDescription(), club.getId(),
                joinable, club.getLeader(),userString);

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
                int leader = Integer.parseInt(values[4]);
                for (int i = 5; i < values.length ; i++) {
                    members.add(Integer.parseInt(values[i]));
                }
                Club club = new Club(values[0], values[1], Integer.parseInt(values[2]), joinable, members,leader);
                clubs.add(club);
            }
        }
        catch (IOException e) {

        }
        return clubs;
    }

    @Override
    public void joinClub(String name, int id) {
        StringBuilder temp = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            temp.append(br.readLine() + "\n");
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(name)) {
                    StringBuilder students = new StringBuilder();
                    for (int i = 4; i < values.length; i ++) {
                        students.append("," + values[i]);
                    }
                    students.append("," + id);
                    temp.append(String.format("%s,%s,%s,%s%s\n", name, values[1],
                            values[2], values[3], students));
                }
                else
                    temp.append(line + "\n");
            }
        } catch (IOException e) {}

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            bw.write(temp.toString());
        } catch (IOException e) {}
    }

    @Override
    public void deleteClub(String name) {
        StringBuilder temp = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            temp.append(br.readLine() + "\n");
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (!values[0].equals(name)) {
                    temp.append(line + "\n");
                }
            }
        } catch (IOException e) {}

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            bw.write(temp.toString());
        } catch (IOException e) {}
    }

    @Override
    public void modifyDescription(String clubName, String description) {
        StringBuilder temp = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            temp.append(br.readLine() + "\n");
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[0].equals(clubName)) {
                    StringBuilder students = new StringBuilder();
                    for (int i = 4; i < values.length; i ++) {
                        students.append("," + values[i] );
                    }
                    temp.append(String.format("%s,%s,%s,%s%s\n", clubName, description,
                            values[2], values[3], students));
                }
                else
                    temp.append(line + "\n");
            }
        } catch (IOException e) {}

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {
            bw.write(temp.toString());
        } catch (IOException e) {}
    }

    public static void main(String[] args) {
        ClubDataAccess clubDataAccess = new ClubDataAccessObject("clubs.csv");
        clubDataAccess.modifyDescription("Book Club", "Another description changed");
    }
}
