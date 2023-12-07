package Adapter.trade;

import Entity.TradeItem;
import View.trade.TradeView;
import use_case.trade.TradeOutputBoundary;
import use_case.trade.TradeOutputData;

public class TradePresenter implements TradeOutputBoundary {
    private TradeViewModel tradeViewModel;
    private TradeView view;
    public TradePresenter(TradeView view){
        this.view = view;
    }

    @Override
    public void showTrade(String[] input) {
        this.view.showResult();
    }

}

