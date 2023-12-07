package PostandReplyTest;

import org.junit.jupiter.api.Test;
import use_case.postandreply.ChatwithAI.GetResponseOutputData;

import static org.junit.jupiter.api.Assertions.*;

public class GetResponseOutputDataTest {

    @Test
    public void testGetResponseOutputData() {
        // Setup
        boolean expectedSuccess = true;
        String expectedAIAnswer = "Test Answer";
        String expectedTellyoudogshitifitssuccess = "Success Message";

        // Action
        GetResponseOutputData outputData = new GetResponseOutputData(expectedSuccess, expectedAIAnswer, expectedTellyoudogshitifitssuccess);

        // Assertion
        assertEquals(expectedSuccess, outputData.SuccessorNot(), "The success value should match the expected value.");
        assertEquals(expectedAIAnswer, outputData.GetAnswer(), "The AI answer should match the expected value.");
        assertEquals(expectedTellyoudogshitifitssuccess, outputData.getTellyoudogshitifitssuccess(), "The additional message should match the expected value.");
    }
}
