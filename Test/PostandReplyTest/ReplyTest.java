package PostandReplyTest;

import Entity.PostandReply.Reply;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReplyTest {

    @Test
    void testReplyConstructor() {
        Reply reply = new Reply("1", "10", "Test message");
        assertAll("Ensure the Reply constructor sets values correctly",
                () -> assertEquals("1", reply.getId(), "ID should be '1'"),
                () -> assertEquals("10", reply.getPostId(), "Post ID should be '10'"),
                () -> assertEquals("Test message", reply.getMessage(), "Message should be 'Test message'")
        );
    }

    @Test
    void testSetAndGetId() {
        Reply reply = new Reply("1", "10", "Test message");
        reply.setId("2");
        assertEquals("2", reply.getId(), "setId should set the ID correctly");
    }

    @Test
    void testSetAndGetPostId() {
        Reply reply = new Reply("1", "10", "Test message");
        reply.setPostId("20");
        assertEquals("20", reply.getPostId(), "setPostId should set the Post ID correctly");
    }

    @Test
    void testSetAndGetMessage() {
        Reply reply = new Reply("1", "10", "Initial message");
        reply.setMessage("Updated message");
        assertEquals("Updated message", reply.getMessage(), "setMessage should set the message correctly");
    }

    @Test
    void testToString() {
        Reply reply = new Reply("1", "10", "Test message");
        String expectedString = "Reply ID: 1 | Post ID: 10 | Content: Test message";
        assertEquals(expectedString, reply.toString(), "toString should return the correct string representation");
    }
}
