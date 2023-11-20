package use_case.club;

import Entity.Club;

import java.util.List;

public interface ShowingOutputBoundary {
    public void showAllClubs(ShowingInputData showingInputData);
    public void showClubDescription(ShowingInputData showingInputData);

}
