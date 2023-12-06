package Entity.Message;

public class MessageFactory {

    public Message create(String role, String content){
        return new Message(role, content);
    }
}
