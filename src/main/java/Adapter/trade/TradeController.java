package Adapter.trade;

import Data.CsvTradeDataAccess;
import Entity.TradeItem;
import use_case.trade.TradeInputBoundary;
import use_case.trade.TradeInputData;
import use_case.trade.TradeInteractor;
import use_case.trade.TradeUserDataAccessInterface;

// TradeController.java

public class TradeController {
    private TradeInputBoundary usecase;

    public TradeController(TradePresenter presenter, CsvTradeDataAccess tradeDataAccess) {
        this.usecase = new TradeInteractor(presenter, tradeDataAccess);
    }


    public void submitTrade(String[] input) {
        this.usecase.submitTrade(input);
    }
}


