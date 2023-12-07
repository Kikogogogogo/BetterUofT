package PostandReplyTest;

import Data.PostandReply.ChatgptDataAccessObject;
import Entity.PostandReply.Message;

public class TestChat {
    private String response;

    public TestChat(String role, String content) {
        Message message = new Message(role, content);
        String model = "gpt-3.5-turbo";
        this.response = new ChatgptDataAccessObject().GetResponse(model, message);
    }

    public String getResponse() {
        return response;
    }
}
