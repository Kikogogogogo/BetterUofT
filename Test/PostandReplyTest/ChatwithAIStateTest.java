package PostandReplyTest;

import Adapter.PostandReply.ChatwithAIState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChatwithAIStateTest {

    @Test
    public void testGetterSetter() {
        ChatwithAIState state = new ChatwithAIState();

        state.setUser("TestUser");
        assertEquals("TestUser", state.getUser(), "The user should be 'TestUser'");

        state.setUserError("User Error");
        assertEquals("User Error", state.getUserError(), "The user error should be 'User Error'");

        state.setContent("TestContent");
        assertEquals("TestContent", state.getContent(), "The content should be 'TestContent'");

        state.setContentError("Content Error");
        assertEquals("Content Error", state.getContentError(), "The content error should be 'Content Error'");
    }

    @Test
    public void testCopyConstructor() {
        ChatwithAIState originalState = new ChatwithAIState();
        originalState.setUser("OriginalUser");
        originalState.setUserError("Original User Error");
        originalState.setContent("OriginalContent");
        originalState.setContentError("Original Content Error");

        ChatwithAIState copiedState = new ChatwithAIState(originalState);

        assertEquals(originalState.getUser(), copiedState.getUser(), "The copied user should match the original");
        assertEquals(originalState.getUserError(), copiedState.getUserError(), "The copied user error should match the original");
        assertEquals(originalState.getContent(), copiedState.getContent(), "The copied content should match the original");
        assertEquals(originalState.getContentError(), copiedState.getContentError(), "The copied content error should match the original");
    }
}
