package use_case.trade;

public class TradeInputData {
    private double tradeAmount;
    private String description;
    private String category;


    public TradeInputData(double tradeAmount, String description, String category) {
        this.description = description;
        this.tradeAmount = tradeAmount;
        this.category = category;
    }


    public double getTradeAmount() {
        return tradeAmount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}


