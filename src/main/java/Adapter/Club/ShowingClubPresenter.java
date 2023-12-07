package Adapter.Club;

import Entity.Club;
import View.club.ClubApp;
import use_case.club.ShowingUsecase.ShowingInputData;
import use_case.club.ShowingUsecase.ShowingOutputBoundary;

public class ShowingClubPresenter implements ShowingOutputBoundary {
    final ClubApp view;
    public ShowingClubPresenter(ClubApp view) {
        this.view = view;
    }

    public void showAllClubs(ShowingInputData showingInputData) {

        view.clubListModel.removeAllElements();
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
