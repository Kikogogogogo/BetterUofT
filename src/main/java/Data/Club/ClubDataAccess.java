package Data.Club;
import Entity.Club.Club;

import java.util.List;

public interface ClubDataAccess {
    void save(Club club);
    List<Club> getClubs();
    void joinClub(String name, int id);
    void deleteClub(String name);
    void modifyDescription(String clubName, String description);

}
