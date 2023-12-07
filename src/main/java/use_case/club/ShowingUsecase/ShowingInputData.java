package use_case.club.ShowingUsecase;

import java.util.List;
import Entity.Club;

public class ShowingInputData {
    final private int selection;
    final private List<Club> clubs;
    public ShowingInputData(int selection, List<Club> clubs) {
        this.selection = selection;
        this.clubs = clubs;
    }

    public int getSelection() {
        return selection;
    }

    public List<Club> getClubs() {
        return clubs;
    }

}
