package Data;

import Entity.Club;
import Entity.TradeItem;
import use_case.trade.TradeOutputBoundary;
import use_case.trade.TradeUserDataAccessInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvTradeDataAccess implements TradeData {
    private String filePath;

    public CsvTradeDataAccess(String filePath) {

        this.filePath = filePath;

    }


    public void save(String[] input) {
        //descripton, category, price, name, email, phone
        String item = input[0] + "," + input[1] + "," + input[2] + "," + input[3] + "," + input[4] + "," + input[5] + "\n";

        //write to csv file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {;
            writer.write(item);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<String[]> getAllTrade() {
        // returns everything on csv file
        List<String[]> items = new ArrayList<>();

        //read csv file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                items.add(values);
            }
        }
        catch (IOException e) {

        }

        return items;
    }
}

