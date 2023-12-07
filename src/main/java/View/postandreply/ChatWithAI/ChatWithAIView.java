package View.postandreply.ChatWithAI;

import Adapter.PostandReply.ChatwithAIController;
import Adapter.PostandReply.ChatwithAIViewModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChatWithAIView extends JPanel implements ActionListener {

    private final JTextField messageInputField = new JTextField(100);
    private final JButton sendMessageButton = new JButton("Send");
    private final JTextArea conversationArea = new JTextArea(16, 100);

    private final ChatwithAIController aiController;
    private final ChatwithAIViewModel aiViewModel;

    public ChatWithAIView(ChatwithAIViewModel viewModel, ChatwithAIController controller) {
        this.aiViewModel = viewModel;
        this.aiController = controller;


        this.aiViewModel.addPropertyChangeListener(evt -> {
            switch (evt.getPropertyName()) {
                case "response":

                    conversationArea.append("AI: " + evt.getNewValue().toString() + "\n");
                    break;
                case "error":

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

                conversationArea.append("You: " + userInput + "\n");


                aiController.SendMessage("user", userInput);


                messageInputField.setText("");
            }
        }
    }
}
