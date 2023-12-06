package use_case.postandreply.ChatwithAI;

public interface GetResponseOutputBoundary {

    void prepareSuccessView(GetResponseOutputData outputdata);
    void prepareFailView(String error);
}
