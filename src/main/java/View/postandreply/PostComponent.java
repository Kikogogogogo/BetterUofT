package View.postandreply;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Entity.Reply;


import Entity.Post;

import Adapter.PostandReply.PostandReplyPrensenter;


public class PostComponent extends JPanel {
    private Post post;
    private PostandReplyPrensenter postandReplyPrensenter;
    JButton showRepliesButton;
    private JList<Reply> replyList;
    private DefaultListModel<Reply> replyListModel;
    private boolean repliesVisible = false;

    public PostComponent(Post post, PostandReplyPrensenter postandReplyPrensenter) {
        this.post = post;
        this.postandReplyPrensenter = postandReplyPrensenter;
        setLayout(new BorderLayout());

        JLabel postLabel = new JLabel("ID: " + post.getId() + " | Content: " + post.getMessage());
        add(postLabel, BorderLayout.NORTH);

        replyListModel = new DefaultListModel<>();
        replyList = new JList<>(replyListModel);
        replyList.setVisible(false); // Initially hidden

        showRepliesButton = new JButton("Show Replies");
        showRepliesButton.addActionListener(e -> toggleRepliesVisibility());

        add(showRepliesButton, BorderLayout.SOUTH);
        add(new JScrollPane(replyList), BorderLayout.CENTER);
    }

    private void toggleRepliesVisibility() {
        if (!repliesVisible) {
            List<Reply> replies = postandReplyPrensenter.getRepliesForPost(post.getId());
            replyListModel.removeAllElements();
            for (Reply reply : replies) {
                replyListModel.addElement(reply);
            }
        }
        repliesVisible = !repliesVisible;
        replyList.setVisible(repliesVisible);
        showRepliesButton.setText(repliesVisible ? "Hide Replies" : "Show Replies");
        revalidate();
        repaint();
    }
}
