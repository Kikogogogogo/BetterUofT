package Adapter.PostandReply;
import use_case.postandreply.ChatwithAI.GetResponseInputBoundary;
import use_case.postandreply.ChatwithAI.GetResponseInputData;
import use_case.postandreply.ChatwithAI.GetResponseInteractor;

public class ChatwithAIController {
    final GetResponseInputBoundary GetResponseInteractor;

    public ChatwithAIController(GetResponseInputBoundary getResponseInteractor) {
        this.GetResponseInteractor = getResponseInteractor;
    }
    public void SendMessage(String user, String content){
        GetResponseInputData getResponseInputData = new GetResponseInputData(user, content);
        GetResponseInteractor.SendMessage(getResponseInputData);
    }
}
