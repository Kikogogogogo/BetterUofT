package PostandReplyTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestChatTest {

    @Test
    public void testWorldSeriesQuery() {
        // Arrange
        String role = "user";
        String content = "Who won the world series in 2020?";
        TestChat chat = new TestChat(role, content);

        // Act
        String response = chat.getResponse();

        // Assert
        String expectedResponse = "The Los Angeles Dodgers won the World Series in 2020.";
        assertEquals(expectedResponse, response, "The response should match the expected World Series winner.");
    }
}
