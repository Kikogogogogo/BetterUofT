package use_case.postandreply.ChatwithAI;

import Entity.Message.Message;

public interface ChatgptDataAccessInterface {
    String GetResponse(String model, Message message);
}
