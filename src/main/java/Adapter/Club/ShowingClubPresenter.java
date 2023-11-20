package Adapter.Club;

import Entity.Club;
import View.GUI.FinalApp;
import View.club.ClubApp;
import use_case.club.ShowingInputData;
import use_case.club.ShowingOutputBoundary;
import use_case.club.ShowingUsecase;

import java.util.List;

public class ShowingClubPresenter implements ShowingOutputBoundary {
    final ClubApp view;
    public ShowingClubPresenter(ClubApp view) {
        this.view = view;
    }

    public void showAllClubs(ShowingInputData showingInputData) {

        for (Club c : showingInputData.getClubs()) {
            view.clubListModel.addElement(c.getName());
        }
    }

    @Override
    public void showClubDescription(ShowingInputData showingInputData) {
        int index = showingInputData.getSelection();
        view.descriptionTextField.setText(showingInputData.getClubs().get(index).getDescription());
    }

    @Override
    public void showClubJoinable(ShowingInputData showingInputData) {
        int index = showingInputData.getSelection();
        view.joinableCheckBox.setSelected(showingInputData.getClubs().get(index).getJoinable());
    }


}
