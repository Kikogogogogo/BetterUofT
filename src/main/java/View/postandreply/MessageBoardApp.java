package View.postandreply;
import Entity.Post;
import javax.swing.*;
import java.awt.*;
import Adapter.ShowingAdapter;
import Adapter.PostingAdapter;
import Adapter.ReplyingAdapter;
import Data.ReplyRepo;
import Data.CsvPostRepo;
import Data.PostRepo;
import Data.CsvReplyRepo;

import use_case.postandreply.PostUsecase;
import use_case.postandreply.ReplyUsecase;



public class MessageBoardApp extends JFrame {
    private JPanel postsPanel;
    private JScrollPane postsScrollPane;
    private ShowingAdapter showingAdapter;
    private PostingAdapter postingAdapter;
    private ReplyingAdapter replyingAdapter;
    private ReplyPanel replyPanel;

    public MessageBoardApp() {
        // Initialize repositories
        PostRepo postRepo = new CsvPostRepo("posts.csv");
        ReplyRepo replyRepo = new CsvReplyRepo("replies.csv");

        // Initialize use cases
        PostUsecase postUsecase = new PostUsecase(postRepo);
        ReplyUsecase replyUsecase = new ReplyUsecase(replyRepo);

        // Initialize adapters
        this.postingAdapter = new PostingAdapter(postUsecase);
        this.replyingAdapter = new ReplyingAdapter(replyUsecase);
        this.showingAdapter = new ShowingAdapter(postUsecase, replyUsecase);

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
        PostPanel postPanel = new PostPanel(postingAdapter, this::refreshPosts);
        this.replyPanel = new ReplyPanel(replyingAdapter);

        // Add components to the JFrame
        add(postPanel, BorderLayout.NORTH);
        add(postsScrollPane, BorderLayout.CENTER);
        add(replyPanel, BorderLayout.SOUTH);

        // Refresh the posts display initially
        refreshPosts();
    }

    private void refreshPosts() {
        postsPanel.removeAll();
        java.util.List<Post> posts = showingAdapter.getAllPosts();
        for (Post post : posts) {
            PostComponent postComponent = new PostComponent(post, showingAdapter);
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

