package PostandReplyTest;
import Adapter.PostandReply.ChatwithAIState;
import Adapter.PostandReply.ChatwithAIViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import static org.junit.jupiter.api.Assertions.*;

public class ChatwithAIViewModelTest {
    private ChatwithAIViewModel viewModel;
    private PropertyChangeEvent lastEvent;

    private class TestPropertyChangeListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            lastEvent = evt;
        }
    }

    @BeforeEach
    public void setUp() {
        viewModel = new ChatwithAIViewModel();
        viewModel.addPropertyChangeListener(new TestPropertyChangeListener());
    }

    @Test
    public void testUpdateViewWithSuccess() {
        String successMessage = "Success message";
        viewModel.updateViewWithSuccess(successMessage);

        assertEquals(successMessage, viewModel.getState().getContent(), "The content should match the success message");
        assertNotNull(lastEvent, "A property change event should have been fired");
        assertEquals("response", lastEvent.getPropertyName(), "The property change event should be for 'response'");
        assertEquals(successMessage, lastEvent.getNewValue(), "The new value of the event should be the success message");
    }

    @Test
    public void testUpdateViewWithError() {
        String errorMessage = "Error message";
        viewModel.updateViewWithError(errorMessage);

        assertEquals(errorMessage, viewModel.getState().getContentError(), "The content error should match the error message");
        assertNotNull(lastEvent, "A property change event should have been fired");
        assertEquals("error", lastEvent.getPropertyName(), "The property change event should be for 'error'");
        assertEquals(errorMessage, lastEvent.getNewValue(), "The new value of the event should be the error message");
    }

    @Test
    public void testSetState() {
        ChatwithAIState newState = new ChatwithAIState();
        newState.setUser("User");
        viewModel.setState(newState);

        assertEquals("User", viewModel.getState().getUser(), "The state's user should be 'User'");
    }
}
