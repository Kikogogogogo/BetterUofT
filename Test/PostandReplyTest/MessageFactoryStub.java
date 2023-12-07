package PostandReplyTest;

import Entity.PostandReply.Message;
import Entity.PostandReply.MessageFactory;

class MessageFactoryStub  {

    public Message create(String user, String content) {
        return new Message(user, content);
    }
}
