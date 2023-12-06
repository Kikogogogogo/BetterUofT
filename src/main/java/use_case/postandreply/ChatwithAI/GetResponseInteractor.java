package use_case.postandreply.ChatwithAI;
import Entity.Message.Message;
import Entity.Message.MessageFactory;

public class GetResponseInteractor implements GetResponseInputBoundary{
    final ChatgptDataAccessInterface chatgptDataAccessObject;
    final GetResponseOutputBoundary getResponseOutputBoundary;
    final MessageFactory messageFactory;

    public GetResponseInteractor(ChatgptDataAccessInterface chatgptDataAccessObject, GetResponseOutputBoundary getResponsePresenter, MessageFactory messageFactory) {
        this.chatgptDataAccessObject = chatgptDataAccessObject;
        this.getResponseOutputBoundary = getResponsePresenter;
        this.messageFactory = messageFactory;
    }

    @Override
    public void SendMessage(GetResponseInputData getResponseInputData) {
        Message message1 = messageFactory.create(getResponseInputData.getUser(), getResponseInputData.getContent());
        String model  = "gpt-3.5-turbo";
        String response = chatgptDataAccessObject.GetResponse(model, message1);

        if (response == null) {
            getResponseOutputBoundary.prepareFailView("Responsse did not get successfully");
        }
        else {
            GetResponseOutputData getResponseOutputData = new GetResponseOutputData(true,
                    response, "Message send successfully");
            getResponseOutputBoundary.prepareSuccessView(getResponseOutputData);

        }
    }
}
