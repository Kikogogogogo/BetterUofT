package View.postandreply.ChatWithAI;

import Adapter.ViewManagerModel;
import Adapter.PostandReply.ChatwithAIViewModel;
import Data.PostandReply.ChatgptDataAccessObject;

import javax.swing.*;



import Adapter.ViewManagerModel;
import Adapter.PostandReply.ChatwithAIViewModel;
import Data.PostandReply.ChatgptDataAccessObject;
import javax.swing.*;

public class ChatwithAIMain {

    private JFrame application;

    public ChatwithAIMain() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        application = new JFrame("Chat with AI");
        application.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ChatwithAIViewModel chatViewModel = new ChatwithAIViewModel();
        ChatgptDataAccessObject dataAccessObject = new ChatgptDataAccessObject();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        ChatWithAIView chatView = ChatWithAIUseCaseFactory.create(viewManagerModel, chatViewModel, dataAccessObject);
        application.getContentPane().add(chatView);

        application.pack();
        application.setLocationRelativeTo(null);
    }

    public void setVisible(boolean visible) {
        application.setVisible(visible);
    }
}

