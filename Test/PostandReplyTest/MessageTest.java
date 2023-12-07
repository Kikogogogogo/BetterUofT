package PostandReplyTest;
import Entity.PostandReply.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void testMessageConstructor() {
        Message message = new Message("role", "content");
        assertAll("Ensure the Message constructor sets values correctly",
                () -> assertEquals("role", message.getRole(), "Role should be 'role'"),
                () -> assertEquals("content", message.getContent(), "Content should be 'content'")
        );
    }

    @Test
    void testSetAndGetRole() {
        Message message = new Message("initialRole", "content");
        message.setRole("newRole");
        assertEquals("newRole", message.getRole(), "setRole should set the role correctly");
    }

    @Test
    void testSetAndGetContent() {
        Message message = new Message("role", "initialContent");
        message.setContent("newContent");
        assertEquals("newContent", message.getContent(), "setContent should set the content correctly");
    }

    @Test
    void testToString() {
        Message message = new Message("role", "content");
        String expectedString = "Message{role='role', content='content'}";
        assertEquals(expectedString, message.toString(), "toString should return the correct string representation");
    }
}
