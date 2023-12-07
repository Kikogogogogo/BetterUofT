package PostandReplyTest;

import Adapter.PostandReply.ChatwithAIController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.postandreply.ChatwithAI.GetResponseInputData;

import static org.junit.jupiter.api.Assertions.*;

public class ChatwithAIControllerTest {
    private GetResponseInputBoundaryStub inputBoundaryStub;
    private ChatwithAIController controller;

    @BeforeEach
    public void setUp() {
        inputBoundaryStub = new GetResponseInputBoundaryStub();
        controller = new ChatwithAIController(inputBoundaryStub);
    }

    @Test
    public void testSendMessage() {
        String user = "testUser";
        String content = "Hello, AI!";

        controller.SendMessage(user, content);

        GetResponseInputData inputData = inputBoundaryStub.getLastInputData();
        assertNotNull(inputData, "Input data should not be null");
        assertEquals(user, inputData.getUser(), "The user should match the input");
        assertEquals(content, inputData.getContent(), "The content should match the input");
    }
}
