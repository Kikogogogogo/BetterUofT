package View.postandreply.ChatWithAI;

import Adapter.PostandReply.ChatwithAIController;
import Adapter.PostandReply.ChatwithAIViewModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChatWithAIView extends JPanel implements ActionListener {

    private final JTextField messageInputField = new JTextField(15);
    private final JButton sendMessageButton = new JButton("Send");
    private final JTextArea conversationArea = new JTextArea(20, 30);

    private final ChatwithAIController aiController;
    private final ChatwithAIViewModel aiViewModel;

    public ChatWithAIView(ChatwithAIViewModel viewModel, ChatwithAIController controller) {
        this.aiViewModel = viewModel;
        this.aiController = controller;

        // Set up the listener for changes in the ViewModel
        this.aiViewModel.addPropertyChangeListener(evt -> {
            switch (evt.getPropertyName()) {
                case "response":
                    // Append the AI response to the conversation area
                    conversationArea.append("AI: " + evt.getNewValue().toString() + "\n");
                    break;
                case "error":
                    // Handle error, display error message
                    JOptionPane.showMessageDialog(this, evt.getNewValue().toString(), "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        });

        JScrollPane scrollPane = new JScrollPane(conversationArea);
        conversationArea.setEditable(false);

        sendMessageButton.addActionListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(scrollPane);
        add(messageInputField);
        add(sendMessageButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendMessageButton) {
            String userInput = messageInputField.getText();
            if (!userInput.isEmpty()) {
                // Display user's message in the conversation area
                conversationArea.append("You: " + userInput + "\n");

                // Send the message to the AI controller
                aiController.SendMessage("user", userInput);

                // Clear the input field
                messageInputField.setText("");
            }
        }
    }
}
