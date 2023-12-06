package Adapter.PostandReply;

import Adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChatwithAIViewModel extends ViewModel {
    public final String TITLE_LABEL = "Chat with AI smarter than uoft students";
    public final String MESSAGE_LABEL = "Message";
    public static final String SEND_LABEL = "Send";
    private ChatwithAIState state = new ChatwithAIState();
    public void setState(ChatwithAIState state) {
        this.state = state;
    }

    public ChatwithAIViewModel() {
        super("chat with AI");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ChatwithAIState getState() {
        return state;
    }

    public void updateViewWithSuccess(String messageToShow) {
        this.state.setContent(messageToShow);
        support.firePropertyChange("response", null, messageToShow);
    }
    public void updateViewWithError(String errorMessage) {

        this.state.setContentError(errorMessage);
        support.firePropertyChange("error", null, errorMessage);
    }

}
