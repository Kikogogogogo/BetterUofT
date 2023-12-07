package PostandReplyTest;

import Entity.PostandReply.Message;
import use_case.postandreply.ChatwithAI.ChatgptDataAccessInterface;

class ChatgptDataAccessStub implements ChatgptDataAccessInterface {
    private String predefinedResponse;

    public void setPredefinedResponse(String predefinedResponse) {
        this.predefinedResponse = predefinedResponse;
    }

    @Override
    public String GetResponse(String model, Message message) {
        return predefinedResponse;
    }
}
