package View.postandreply;


import Entity.Post;
import Adapter.ReplyingAdapter;

import javax.swing.*;
import java.awt.*;

public class ReplyPanel extends JPanel {
    private JTextArea replyTextArea;
    private JButton replyButton;
    private ReplyingAdapter replyingAdapter;
    private String currentPostId;

    public ReplyPanel(ReplyingAdapter replyingAdapter) {
        this.replyingAdapter = replyingAdapter;
        setLayout(new BorderLayout());

        replyTextArea = new JTextArea(4, 20);
        replyButton = new JButton("Send Reply");
        replyButton.setEnabled(false); // Initially disabled until a post is selected

        replyButton.addActionListener(e -> sendReply());

        add(new JScrollPane(replyTextArea), BorderLayout.CENTER);
        add(replyButton, BorderLayout.SOUTH);
    }

    public void setPostToReply(Post post) {
        currentPostId = post.getId();
        replyButton.setEnabled(true); // Enable the button when a post is selected
        replyTextArea.setText(""); // Clear the text area
        replyTextArea.requestFocusInWindow(); // Focus the text area for a new reply
    }

    private void sendReply() {
        String message = replyTextArea.getText().trim();
        if (!message.isEmpty() && currentPostId != null) {
            replyingAdapter.createReply(currentPostId, message);
            replyTextArea.setText(""); // Clear the text area after sending the reply
            replyButton.setEnabled(false); // Disable the button until another post is selected
        }
    }
}
