package use_case.postandreply.ChatwithAI;

import Entity.Message;

public interface ChatgptDataAccessInterface {
    String GetResponse(String model, Message message);
}
