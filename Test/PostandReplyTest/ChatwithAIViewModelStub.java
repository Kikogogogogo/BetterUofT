package PostandReplyTest;

class ChatwithAIViewModelStub {
    private String lastSuccessMessage;
    private String lastErrorMessage;

    public void updateViewWithSuccess(String message) {
        lastSuccessMessage = message;
    }

    public void updateViewWithError(String error) {
        lastErrorMessage = error;
    }

    public String getLastSuccessMessage() {
        return lastSuccessMessage;
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}

