package Data;

import Entity.Club;

import java.util.List;

public interface TradeData {
    void save(String[] input);

    List<String[]> getAllTrade();
}

