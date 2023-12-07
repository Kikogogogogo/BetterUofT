package View.postandreply;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import View.postandreply.ChatWithAI.ChatwithAIMain;

import View.postandreply.ChatWithHuman.MessageBoardApp;

public class ChooseModeView {

    private JFrame frame;

    public ChooseModeView() {
        frame = new JFrame("Choose Mode");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridBagLayout()); // Set GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Added some padding


        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 14));
        UIManager.put("Button.foreground", new Color(25, 25, 112)); // Dark blue color


        JButton chatWithAIButton = new JButton("Chat with AI");
        JButton chatWithPeopleButton = new JButton("Chat with People");


        chatWithAIButton.addActionListener((ActionEvent e) -> {

            ChatwithAIMain chatwithAIMain = new ChatwithAIMain();
            chatwithAIMain.setVisible(true);
        });

        chatWithPeopleButton.addActionListener((ActionEvent e) -> {
            MessageBoardApp messageBoardApp = new MessageBoardApp();
            messageBoardApp.setVisible(true);
        });

        // Adding buttons to the frame using GridBagConstraints
        frame.add(chatWithAIButton, gbc);
        frame.add(chatWithPeopleButton, gbc);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChooseModeView chooseModeView = new ChooseModeView();
            chooseModeView.setVisible(true);
        });
    }
}
