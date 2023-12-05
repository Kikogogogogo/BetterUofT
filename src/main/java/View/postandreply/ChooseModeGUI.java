package View.postandreply;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseModeGUI {

    private JFrame frame;

    public ChooseModeGUI() {
        frame = new JFrame("Choose Mode");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridBagLayout()); // Set GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Creating buttons
        JButton anonymousButton = new JButton("Anonymous");

        // Adding action listeners for the buttons
        anonymousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open MessageBoardApp (assuming this is another class you have)
                MessageBoardApp messageBoardApp = new MessageBoardApp();
                messageBoardApp.setVisible(true);
            }
        });



        // Adding buttons to the frame using GridBagConstraints
        frame.add(anonymousButton, gbc);

    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChooseModeGUI chooseModeGUI = new ChooseModeGUI();
            chooseModeGUI.setVisible(true);
        });
    }
}
