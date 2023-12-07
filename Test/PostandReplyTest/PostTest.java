package PostandReplyTest;

import Entity.PostandReply.Post;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    void testPostConstructor() {
        Post post = new Post("1", "Test message");
        assertAll("Ensure the Post constructor sets values correctly",
                () -> assertEquals("1", post.getId(), "ID should be '1'"),
                () -> assertEquals("Test message", post.getMessage(), "Message should be 'Test message'")
        );
    }

    @Test
    void testSetAndGetId() {
        Post post = new Post("1", "Test message");
        post.setId("2");
        assertEquals("2", post.getId(), "setId should set the ID correctly");
    }

    @Test
    void testSetAndGetMessage() {
        Post post = new Post("1", "Initial message");
        post.setMessage("Updated message");
        assertEquals("Updated message", post.getMessage(), "setMessage should set the message correctly");
    }

    @Test
    void testToString() {
        Post post = new Post("1", "Test message");
        String expectedString = "Post ID: 1 | Content: Test message";
        assertEquals(expectedString, post.toString(), "toString should return the correct string representation");
    }
}
