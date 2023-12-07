package Adapter.trade;

import Data.CsvTradeDataAccess;
import Entity.TradeItem;
import use_case.trade.TradeInputBoundary;
import use_case.trade.TradeInputData;
import use_case.trade.TradeInteractor;
import use_case.trade.TradeUserDataAccessInterface;

// TradeController.java

public class TradeController {

    //Is actually InputBoundary but is called usecase because it is an implementation
    private TradeInputBoundary usecase;

    public TradeController(TradePresenter presenter, CsvTradeDataAccess tradeDataAccess) {
        this.usecase = new TradeInteractor(presenter, tradeDataAccess);
    }


    public void submitTrade(String[] input) {
        //calls interactor to do the action
        this.usecase.submitTrade(input);

    }
}


