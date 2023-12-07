package PostandReplyTest;

import org.junit.jupiter.api.Test;
import use_case.postandreply.ChatwithAI.GetResponseInputData;

import static org.junit.jupiter.api.Assertions.*;

public class GetResponseInputDataTest {

    @Test
    public void testUserAndContent() {
        // Setup
        String expectedUser = "testUser";
        String expectedContent = "Hello, world!";

        // Action
        GetResponseInputData data = new GetResponseInputData(expectedUser, expectedContent);

        // Assertion
        assertEquals(expectedUser, data.getUser(), "The user should match the expected value.");
        assertEquals(expectedContent, data.getContent(), "The content should match the expected value.");
    }
}
