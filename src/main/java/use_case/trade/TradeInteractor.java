package use_case.trade;
import Data.Trade.CsvTradeDataAccess;

public class TradeInteractor implements TradeInputBoundary {
    private TradeOutputBoundary presenter;
    private CsvTradeDataAccess tradeDataAccess;


    public TradeInteractor(TradeOutputBoundary presenter, CsvTradeDataAccess tradeDataAccess) {
        this.presenter = presenter;
        this.tradeDataAccess = tradeDataAccess;
    }
    @Override
    public void submitTrade(String[] input) {
        this.presenter.showTrade(input);
        this.tradeDataAccess.save(input);
    }

}