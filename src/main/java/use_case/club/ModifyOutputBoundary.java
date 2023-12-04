package use_case.club;

import java.util.List;

public interface ModifyOutputBoundary {
    public void setClubList(List<String> clubNames);
    public void prepareSuccessView(String message);
    public void prepareFailView(String message);
}
