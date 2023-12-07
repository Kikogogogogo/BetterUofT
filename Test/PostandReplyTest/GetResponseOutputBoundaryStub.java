package PostandReplyTest;

import use_case.postandreply.ChatwithAI.GetResponseOutputBoundary;
import use_case.postandreply.ChatwithAI.GetResponseOutputData;

class GetResponseOutputBoundaryStub implements GetResponseOutputBoundary {
    private GetResponseOutputData lastOutputData;
    private String lastFailMessage;

    @Override
    public void prepareSuccessView(GetResponseOutputData data) {
        lastOutputData = data;
    }

    @Override
    public void prepareFailView(String message) {
        lastFailMessage = message;
    }

    public GetResponseOutputData getLastOutputData() {
        return lastOutputData;
    }

    public String getLastFailMessage() {
        return lastFailMessage;
    }
}
