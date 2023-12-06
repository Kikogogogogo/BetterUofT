package View.postandreply.ChatWithAI;
import Data.PostandReply.ChatgptDataAccessObject;
import Entity.Message.Message;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AIHelper extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private ChatgptDataAccessObject chatgptDao;

    public AIHelper() {
        createUI();
        chatgptDao = new ChatgptDataAccessObject();
    }

    private void createUI() {
        setTitle("AI Helper");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea));

        inputField = new JTextField();
        sendButton = new JButton("Send");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText();
                if (!userInput.isEmpty()) {
                    // Assume 'user' role for simplicity
                    Message userMessage = new Message("user", userInput);
                    String response = chatgptDao.GetResponse("your-model", userMessage);
                    chatArea.append("User: " + userInput + "\n");
                    chatArea.append("AI: " + response + "\n");
                    inputField.setText("");
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.add(inputField);
        inputPanel.add(sendButton);

        add(inputPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AIHelper().setVisible(true);
            }
        });
    }
}
