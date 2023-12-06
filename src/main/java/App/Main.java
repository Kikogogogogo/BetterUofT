package App;

import Adapter.ViewManagerModel;
import Adapter.PostandReply.ChatwithAIViewModel;
import Data.PostandReply.ChatgptDataAccessObject;
import View.postandreply.ChatWithAI.ChatWithAIView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Set the look and feel to the system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create the main window (JFrame)
        JFrame application = new JFrame("Chat with AI");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Initialize the necessary components for ChatWithAI
        ChatwithAIViewModel chatViewModel = new ChatwithAIViewModel();
        ChatgptDataAccessObject dataAccessObject = new ChatgptDataAccessObject(); // Replace with actual initialization
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        // Create and add the ChatWithAIView to the frame using the factory
        ChatWithAIView chatView = ChatWithAIUseCaseFactory.create(viewManagerModel, chatViewModel, dataAccessObject);
        application.getContentPane().add(chatView);

        // Set the size and location of the frame
        application.pack();
        application.setLocationRelativeTo(null); // Center the window on the screen
        application.setVisible(true);
    }
}
