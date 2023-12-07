package Adapter.PostandReply;
import Adapter.ViewManagerModel;
import use_case.postandreply.ChatwithAI.GetResponseOutputBoundary;
import use_case.postandreply.ChatwithAI.GetResponseOutputData;

public class ChatwithAIPresenter implements GetResponseOutputBoundary {
    private final ChatwithAIViewModel chatwithAIViewMode;
    private ViewManagerModel viewManagerModel;
    public ChatwithAIPresenter(ViewManagerModel viewManagerModel, ChatwithAIViewModel chatwithAIViewMode) {
        this.chatwithAIViewMode = chatwithAIViewMode;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessView(GetResponseOutputData outputdata) {
        if (outputdata.SuccessorNot()) {
            String messageToShow = outputdata.GetAnswer() + "\n" + outputdata.getTellyoudogshitifitssuccess();
            chatwithAIViewMode.updateViewWithSuccess(messageToShow);
        } else {
            prepareFailView("AI response unsuccessful");
        }
    }
    public void getResponsefromAI(GetResponseOutputData getResponseOutputData){
        prepareSuccessView(getResponseOutputData);
    }

    @Override
    public void prepareFailView(String error) {
        chatwithAIViewMode.updateViewWithError(error);
    }
}
