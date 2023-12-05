package use_case.club;

import java.util.ArrayList;

public interface CreateInputBoundary {
    public void correctDescription(String description);
    public boolean createClub(String name, String description, boolean joinable, String leader);
}
