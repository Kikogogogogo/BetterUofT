package App;

import Adapter.PostandReply.ChatwithAIController;
import Adapter.PostandReply.ChatwithAIPresenter;
import Adapter.PostandReply.ChatwithAIViewModel;
import Adapter.ViewManagerModel;
import Entity.Message.Message;
import Entity.Message.MessageFactory;
import use_case.postandreply.ChatwithAI.ChatgptDataAccessInterface;
import use_case.postandreply.ChatwithAI.GetResponseInputBoundary;
import use_case.postandreply.ChatwithAI.GetResponseInteractor;
import use_case.postandreply.ChatwithAI.GetResponseOutputBoundary;
import Data.PostandReply.ChatgptDataAccessObject;
import View.postandreply.ChatWithAI.ChatWithAIView;

public class ChatWithAIUseCaseFactory {

    /**
     * Prevent instantiation.
     */
    private ChatWithAIUseCaseFactory() {
    }

    public static ChatWithAIView create(
            ViewManagerModel viewManagerModel,
            ChatwithAIViewModel chatwithAIViewModel,
            ChatgptDataAccessInterface chatgptDataAccessObject
    ) {

        ChatwithAIController chatWithAIController = createChatWithAIController(chatgptDataAccessObject, chatwithAIViewModel,
                viewManagerModel);
        return new ChatWithAIView(chatwithAIViewModel, chatWithAIController);
    }

    public static ChatwithAIController createChatWithAIController(ChatgptDataAccessInterface chatgptDataAccessObject,
                                                                  ChatwithAIViewModel chatwithAIViewModel,
                                                                  ViewManagerModel viewManagerModel){

        GetResponseOutputBoundary getResponseOutputBoundary =
                new ChatwithAIPresenter(viewManagerModel, chatwithAIViewModel);
        GetResponseInputBoundary getResponseInputBoundary =
                new GetResponseInteractor(chatgptDataAccessObject, getResponseOutputBoundary,
                new MessageFactory());
        return new ChatwithAIController(getResponseInputBoundary);
    }
}

