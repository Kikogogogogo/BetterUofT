package use_case.trade;

public class TradeOutputData {
    private boolean success;
    private String message;
    private String itemId;
    private String tradeId; // If there's an identifier for the trade

    // You can include more fields depending on what information
    // you want to pass to the presenter and eventually to the view.

    public TradeOutputData(boolean success, String message) {
        this.success = success;
        this.message = message;

    }

    // Getters
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTradeId() {
        return tradeId;
    }

}
