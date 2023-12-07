import Data.PostandReply.ChatgptDataAccessObject;
import Entity.Message.Message;
public class TestChat {

    public static void main(String[] args) {
        TestChat result = new TestChat("user", "Who won the world series in 2020?");
        System.out.println(result);
    }
    public TestChat(String role, String content) {
        Message message = new Message(role, content);
        String model = "gpt-3.5-turbo";
        String response = new ChatgptDataAccessObject().GetResponse(model, message);
        System.out.println(response);

    };
}
