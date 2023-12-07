package PostandReplyTest;

import use_case.postandreply.ChatwithAI.GetResponseInputBoundary;
import use_case.postandreply.ChatwithAI.GetResponseInputData;

class GetResponseInputBoundaryStub implements GetResponseInputBoundary {
    private GetResponseInputData lastInputData;

    @Override
    public void SendMessage(GetResponseInputData getResponseInputData) {
        lastInputData = getResponseInputData;
    }

    public GetResponseInputData getLastInputData() {
        return lastInputData;
    }
}
