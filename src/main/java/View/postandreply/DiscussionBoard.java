package View.postandreply;

import javax.swing.*;
import java.awt.*;

public class DiscussionBoard extends JFrame {
    public DiscussionBoard() {
        super("Discussion Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JTextArea discussionTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(discussionTextArea);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

}