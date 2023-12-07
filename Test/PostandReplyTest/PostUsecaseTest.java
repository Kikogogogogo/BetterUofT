package PostandReplyTest;

import Entity.PostandReply.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.postandreply.ChatWithHuman.PostUsecase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PostUsecaseTest {
    private PostRepoAccessStub postRepoAccessStub;
    private PostUsecase postUsecase;

    @BeforeEach
    public void setUp() {
        postRepoAccessStub = new PostRepoAccessStub();
        postUsecase = new PostUsecase(postRepoAccessStub);
    }

    @Test
    public void testCreatePost() {
        postUsecase.createPost("Test message");
        List<Post> posts = postUsecase.getAllPosts();
        assertEquals(1, posts.size(), "There should be one post.");
        assertEquals("Test message", posts.get(0).getMessage(), "The message should match.");
    }

    @Test
    public void testGetAllPosts() {
        postUsecase.createPost("First message");
        postUsecase.createPost("Second message");
        List<Post> posts = postUsecase.getAllPosts();
        assertEquals(2, posts.size(), "There should be two posts.");
    }
}
