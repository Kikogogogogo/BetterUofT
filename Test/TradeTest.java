import Adapter.trade.TradeController;
import Adapter.trade.TradePresenter;
import Data.CsvTradeDataAccess;
import View.trade.ShowTradeView;
import View.trade.TradeView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TradeTest {


//    class TradeValidatorTest {
//
//        @Test
//        void testAllFieldsFilled() {
//            String validation = validateInput("Electronics", "Used laptop", "500", "John Doe", "john@example.com", "1234567890");
//            assertEquals("", validation);
//        }
//
//        @Test
//        void testEmptyField() {
//            String validation = TradeValidator.validateInput("", "Used laptop", "500", "John Doe", "john@example.com", "1234567890");
//            assertEquals("All fields are required.", validation);
//        }
//
//        @Test
//        void testInvalidPriceFormat() {
//            String validation = TradeValidator.validateInput("Electronics", "Used laptop", "five hundred", "John Doe", "john@example.com", "1234567890");
//            assertEquals("Invalid price format.", validation);
//        }
//
//        @Test
//        void testInvalidEmailFormat() {
//            String validation = TradeValidator.validateInput("Electronics", "Used laptop", "500", "John Doe", "john@com", "1234567890");
//            assertEquals("Invalid email format.", validation);
//        }
//
//        @Test
//        void testInvalidPhoneFormat() {
//            String validation = TradeValidator.validateInput("Electronics", "Used laptop", "500", "John Doe", "john@example.com", "12345");
//            assertEquals("Invalid phone format.", validation);
//        }
//    }

    public void testInvalidPrice(){

    }


    @Test
    public void testSubmitTradeItem(){
        String[] sample = {"books","CSC207","10","Amy","123@321.com","1234567890"};
        TradeView tradeView = new TradeView();
        TradePresenter presenter = new TradePresenter(tradeView);
        CsvTradeDataAccess tradeDataAccess = new CsvTradeDataAccess("testTrade.csv");
        TradeController tradeController = new TradeController(presenter, tradeDataAccess);
        tradeController.submitTrade(sample);
        try (BufferedReader br = new BufferedReader(new FileReader("testTrade.csv"))) {
            String firstLine = br.readLine(); // Read the first line
            Assertions.assertEquals(firstLine, "books,CSC207,10,Amy,123@321.com,1234567890");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void testCreateCardPanel() {
        ShowTradeView showTradeView = new ShowTradeView();

        String description = "Laptop";
        String category = "Electronics";
        String price = "500";
        String name = "John Doe";
        String email = "john@example.com";
        String phone = "1234567890";

        JPanel cardPanel = showTradeView.createCardPanel(description, category, price, name, email, phone);

        assertNotNull(cardPanel, "Card panel should not be null");

        assertTrue("Card panel should use BorderLayout", cardPanel.getLayout() instanceof BorderLayout);

        // Verifying the contents of the card panel
        // Assuming the labels are added in North, Center, and South
        checkLabel(cardPanel, BorderLayout.NORTH, "Description: " + description);
        checkLabel(cardPanel, BorderLayout.CENTER, "Category: " + category);
        checkLabel(cardPanel, BorderLayout.SOUTH, "Price: $" + price);
    }
    private void checkLabel(JPanel panel, String position, String expectedText) {
        // Ensure that the panel is using BorderLayout
        assertTrue("Panel should use BorderLayout", panel.getLayout() instanceof BorderLayout);

        BorderLayout layout = (BorderLayout) panel.getLayout();
        Component comp = layout.getLayoutComponent(position);
        assertNotNull(comp, "Component at " + position + " should not be null");
        assertTrue("Component should be a JLabel", comp instanceof JLabel);
        JLabel label = (JLabel) comp;
        assertEquals(expectedText, label.getText(), "Label text at " + position + " should match");
    }


    @Test
    void testGetAllTrade() {
        // Use a test CSV file
        CsvTradeDataAccess dataAccess = new CsvTradeDataAccess("testTrade.csv");

        // Assume test_trades.csv has known data
        List<String[]> trades = dataAccess.getAllTrade();

        assertNotNull(trades, "Trades list should not be null");
        assertFalse(trades.isEmpty(), "Trades list should not be empty");

        // Further checks can be made based on the known contents of test_trades.csv
        // For example, if you know the first row's data, you can check that
        String[] firstTrade = trades.get(0);
        assertEquals("books", firstTrade[0], "Description should match");
        // ... and so on for other fields and rows
    }
//    public static boolean isEventQueueContainsJOptionPane() {
//        final boolean[] found = {false};
//        EventQueue eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
//        eventQueue.push(new EventQueue() {
//            @Override
//            protected void dispatchEvent(AWTEvent event) {
//                super.dispatchEvent(event);
//                if (event.getSource() instanceof JOptionPane) {
//                    found[0] = true;
//                }
//            }
//        });
//        return found[0];
//    }
//
//    @Test
//    public void testShowTradeView(){
//        String[] sample = {"books","CSC207","10","Amy","123@321.com","1234567890"};
//        TradeView tradeView = new TradeView();
//        TradePresenter presenter = new TradePresenter(tradeView);
//        CsvTradeDataAccess tradeDataAccess = new CsvTradeDataAccess("trade.csv");
//        TradeController tradeController = new TradeController(presenter, tradeDataAccess);
//        tradeController.submitTrade(sample);
//        assertTrue(isEventQueueContainsJOptionPane());
//
//
//    }
    public void testSubmutSucess(){

    }
    public void testOverLength(){

    }

}
