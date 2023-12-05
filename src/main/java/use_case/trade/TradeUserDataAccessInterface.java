package use_case.trade;

import Entity.TradeItem;

public interface TradeUserDataAccessInterface {
    void saveTrade(String[] input);
    void createTrade(TradeItem trade);
    TradeItem readTrade(String tradeId);
}
