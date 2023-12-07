package PostandReplyTest;

import Entity.PostandReply.Message;
import Entity.PostandReply.MessageFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MessageFactoryTest {

    @Test
    void testCreate() {
        MessageFactory messageFactory = new MessageFactory();
        String testRole = "TestRole";
        String testContent = "TestContent";

        Message message = messageFactory.create(testRole, testContent);

        assertAll("Message should have the role and content set by MessageFactory",
                () -> assertEquals(testRole, message.getRole(), "Role should be set correctly by MessageFactory"),
                () -> assertEquals(testContent, message.getContent(), "Content should be set correctly by MessageFactory")
        );
    }
}
