package use_case.postandreply.ChatwithAI;

import Entity.PostandReply.Message;

public interface ChatgptDataAccessInterface {
    String GetResponse(String model, Message message);
}
