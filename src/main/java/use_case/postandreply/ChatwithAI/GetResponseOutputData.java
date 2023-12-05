package use_case.postandreply.ChatwithAI;

public class GetResponseOutputData {
    private final boolean success;
    private final String AIanswer;
    private final String tellyoudogshitifitssuccess;


    public GetResponseOutputData(boolean success, String answer, String tellyoudogshitifitssuccess) {
        this.success = success;
        AIanswer = answer;
        this.tellyoudogshitifitssuccess = tellyoudogshitifitssuccess;
    }
    public boolean SuccessorNot(){return success;}
    public String GetAnswer(){return this.AIanswer;}

    public String getTellyoudogshitifitssuccess() {
        return tellyoudogshitifitssuccess;
    }
}
