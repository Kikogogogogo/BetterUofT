package use_case.postandreply.ChatwithAI;

public class GetResponseInputData {
   final private String user;
   final private String content;
    public GetResponseInputData(String user, String content) {
        this.user = user;
        this.content = content;
    }
    public String getUser() { return this.user; }
    public String getContent() { return this.content; }
}