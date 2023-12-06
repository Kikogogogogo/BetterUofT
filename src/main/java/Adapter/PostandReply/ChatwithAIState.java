package Adapter.PostandReply;

public class ChatwithAIState {
    private String user = "";
    private String userError = null;
    private String content = "";
    private String contentError = null;
    public ChatwithAIState(ChatwithAIState copy){
        user = copy.user;
        userError = copy.userError;
        content = copy.content;
        contentError = copy.contentError;

    }
    public ChatwithAIState(){}
    public String getUser(){return user;}
    public String getUserError() {
        return userError;
    }
    public String getContent() {
        return content;
    }

    public String getContentError() {
        return contentError;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUserError(String userError) {
        this.userError = userError;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContentError(String contentError) {
        this.contentError = contentError;
    }
}
