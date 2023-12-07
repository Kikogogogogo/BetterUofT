package View.postandreply.ChatWithHuman;
import Entity.Post;
import javax.swing.*;
import java.awt.*;
import Adapter.PostandReply.PostandReplyPrensenter;
import Adapter.PostandReply.PostController;
import Adapter.PostandReply.ReplyController;
import Data.PostandReply.ReplyRepoAccess;
import Data.PostandReply.CsvPostRepoAccessObject;
import Data.PostandReply.PostRepoAccess;
import Data.PostandReply.CsvReplyRepoAccessObject;

import use_case.postandreply.ChatWithHuman.PostUsecase;
import use_case.postandreply.ChatWithHuman.ReplyUsecase;



public class MessageBoardApp extends JFrame {
    private JPanel postsPanel;
    private JScrollPane postsScrollPane;
    private PostandReplyPrensenter postandReplyPrensenter;
    private PostController postController;
    private ReplyController replyController;
    private ReplyPanel replyPanel;

    public MessageBoardApp() {
        // Initialize repositories
        PostRepoAccess postRepoAccess = new CsvPostRepoAccessObject("posts.csv");
        ReplyRepoAccess replyRepoAccess = new CsvReplyRepoAccessObject("replies.csv");

        // Initialize use cases
        PostUsecase postUsecase = new PostUsecase(postRepoAccess);
        ReplyUsecase replyUsecase = new ReplyUsecase(replyRepoAccess);

        // Initialize adapters
        this.postController = new PostController(postUsecase);
        this.replyController = new ReplyController(replyUsecase);
        this.postandReplyPrensenter = new PostandReplyPrensenter(postUsecase, replyUsecase);

        // Set up the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("General Discussion");
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Set up the posts panel
        postsPanel = new JPanel();
        postsPanel.setLayout(new BoxLayout(postsPanel, BoxLayout.Y_AXIS));
        postsScrollPane = new JScrollPane(postsPanel);

        // Create the PostPanel and ReplyPanel
        PostPanel postPanel = new PostPanel(postController, this::refreshPosts);
        this.replyPanel = new ReplyPanel(replyController);

        // Add components to the JFrame
        add(postPanel, BorderLayout.NORTH);
        add(postsScrollPane, BorderLayout.CENTER);
        add(replyPanel, BorderLayout.SOUTH);

        // Refresh the posts display initially
        refreshPosts();
    }

    private void refreshPosts() {
        postsPanel.removeAll();
        java.util.List<Post> posts = postandReplyPrensenter.getAllPosts();
        for (Post post : posts) {
            PostComponent postComponent = new PostComponent(post, postandReplyPrensenter);
            postComponent.showRepliesButton.addActionListener(e -> replyPanel.setPostToReply(post));
            postsPanel.add(postComponent);
            postsPanel.add(Box.createVerticalStrut(5)); // Spacer between posts
        }
        postsPanel.revalidate();
        postsPanel.repaint();
        postsScrollPane.getVerticalScrollBar().setValue(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MessageBoardApp app = new MessageBoardApp();
            app.setVisible(true);
        });
    }
}

