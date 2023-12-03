package Data;
import Entity.Club;

import java.util.List;

public interface ClubDataAccess {
    void save(Club club);
    List<Club> getClubs();
    void deleteClub(String name);
    void modifyDescription(String clubName, String description);
}
