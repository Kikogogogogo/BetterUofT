package use_case.trade;
import Data.CsvTradeDataAccess;
import Entity.TradeItem;
import View.trade.TradeView;
import use_case.trade.TradeInputBoundary;

import javax.swing.*;
import java.awt.event.ActionEvent;

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