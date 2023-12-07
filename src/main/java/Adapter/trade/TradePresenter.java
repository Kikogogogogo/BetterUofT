package Adapter.trade;

import View.trade.TradeView;
import use_case.trade.TradeOutputBoundary;

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

