package PostandReplyTest;

import Entity.PostandReply.Reply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.postandreply.ChatWithHuman.ReplyUsecase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReplyUsecaseTest {
    private ReplyRepoAccessStub replyRepoAccessStub;
    private ReplyUsecase replyUsecase;

    @BeforeEach
    public void setUp() {
        replyRepoAccessStub = new ReplyRepoAccessStub();
        replyUsecase = new ReplyUsecase(replyRepoAccessStub);
    }

    @Test
    public void testCreateReply() {
        String postId = "post1";
        replyUsecase.createReply(postId, "Reply message");
        List<Reply> replies = replyUsecase.getRepliesForPost(postId);
        assertEquals(1, replies.size(), "There should be one reply.");
        assertEquals("Reply message", replies.get(0).getMessage(), "The message should match.");
    }

    @Test
    public void testGetRepliesForPost() {
        String postId = "post1";
        replyUsecase.createReply(postId, "First reply");
        replyUsecase.createReply(postId, "Second reply");
        List<Reply> replies = replyUsecase.getRepliesForPost(postId);
        assertEquals(2, replies.size(), "There should be two replies.");
    }
}
