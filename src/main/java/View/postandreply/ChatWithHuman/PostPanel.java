package View.postandreply.ChatWithHuman;

import Adapter.PostandReply.PostController;

import javax.swing.*;
import java.awt.*;

public class PostPanel extends JPanel {
    private JTextArea postTextArea;
    private JButton postButton;
    private PostController postController;
    private Runnable refreshPostsCallback;

    public PostPanel(PostController postController, Runnable refreshPostsCallback) {
        this.postController = postController;
        this.refreshPostsCallback = refreshPostsCallback;
        createUI();
    }

    private void createUI() {
        setLayout(new BorderLayout());
        postTextArea = new JTextArea(4, 20);
        postButton = new JButton("Post");

        postButton.addActionListener(e -> {
            String message = postTextArea.getText().trim();
            if (!message.isEmpty()) {
                postController.createPost(message);
                postTextArea.setText(""); // Clear the text area after posting
                if (refreshPostsCallback != null) {
                    refreshPostsCallback.run(); // Refresh the posts display
                }
            }
        });

        add(new JScrollPane(postTextArea), BorderLayout.CENTER);
        add(postButton, BorderLayout.EAST);
    }
}
