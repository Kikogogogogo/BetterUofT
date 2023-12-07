package Adapter.trade;

import use_case.trade.TradeOutputData;

public class TradeViewModel {
    private String statusMessage;
    private boolean operationSuccessful;

    // Additional fields can be added based on what the UI needs to display

    public TradeViewModel(TradeOutputData tradeOutputData) {
        this.statusMessage = tradeOutputData.getMessage();
    }

    // Getters and Setters

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public boolean isOperationSuccessful() {
        return operationSuccessful;
    }

    public void setOperationSuccessful(boolean operationSuccessful) {
        this.operationSuccessful = operationSuccessful;
    }
}


