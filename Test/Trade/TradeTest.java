package Trade;

import Adapter.trade.TradeController;
import Adapter.trade.TradePresenter;
import Data.Trade.CsvTradeDataAccess;
import Entity.Trade.TradeItem;
import View.trade.ShowTradeView;
import View.trade.TradeView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import use_case.trade.TradeInputData;
import use_case.trade.TradeOutputData;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


public class TradeTest {


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
    void testGetAllTrade() {
        // Use a test CSV file
        CsvTradeDataAccess dataAccess = new CsvTradeDataAccess("testTrade.csv");

        // Assume test_trades.csv has known data
        List<String[]> trades = dataAccess.getAllTrade();

        assertNotNull(trades, "Trades list should not be null");
        assertFalse(trades.isEmpty(), "Trades list should not be empty");

        // Further checks can be made based on the known contents of test_trades.csv
        // first row
        String[] firstTrade = trades.get(0);
        assertEquals("books", firstTrade[0], "Description should match");
        assertEquals("CSC207", firstTrade[1], "Description should match");
        assertEquals("10", firstTrade[2], "Description should match");
        assertEquals("Amy", firstTrade[3], "Description should match");
        assertEquals("123@321.com", firstTrade[4], "Description should match");
        assertEquals("1234567890", firstTrade[5], "Description should match");

        //second row
        String[] secondTrade = trades.get(1);
        assertEquals("books", firstTrade[0], "Description should match");
        assertEquals("CSC207", firstTrade[1], "Description should match");
        assertEquals("10", firstTrade[2], "Description should match");
        assertEquals("Amy", firstTrade[3], "Description should match");
        assertEquals("123@321.com", firstTrade[4], "Description should match");
        assertEquals("1234567890", firstTrade[5], "Description should match");

    }
    @Test
    void testTradeItemConstructorAndGetters() {
            // Create an instance of the concrete subclass with test data
        TradeItem tradeItem = new TradeItem("Laptop", "Electronics", "500", "John Doe", "john@example.com", "1234567890");

            // Test getters
        assertEquals("Laptop", tradeItem.getDescription(), "Description should match");
        assertEquals("Electronics", tradeItem.getCategory(), "Category should match");
        assertEquals("500", tradeItem.getPrice(), "Price should match");
        assertEquals("John Doe", tradeItem.getContactName(), "Contact name should match");
        assertEquals("john@example.com", tradeItem.getEmail(), "Email should match");
        assertEquals("1234567890", tradeItem.getPhone(), "Phone should match");
    }
    @Test
    void testTradeItemSetters() {
        // Create an instance and update values using setters
        TradeItem tradeItem = new TradeItem("Old Item", "Category", "100", "Name", "email@example.com", "1234567890");
        // Set new values
        tradeItem.setDescription("New Laptop");
        tradeItem.setCategory("New Electronics");
        tradeItem.setPrice("600");
        tradeItem.setContactName("Jane Doe");
        tradeItem.setEmail("jane@example.com");
        tradeItem.setPhone("0987654321");
        // Test that the getters return the updated values
        assertEquals("New Laptop", tradeItem.getDescription(), "Updated description should match");
        assertEquals("New Electronics", tradeItem.getCategory(), "Updated category should match");
        assertEquals("600", tradeItem.getPrice(), "Updated price should match");
        assertEquals("Jane Doe", tradeItem.getContactName(), "Updated contact name should match");
        assertEquals("jane@example.com", tradeItem.getEmail(), "Updated email should match");
        assertEquals("0987654321", tradeItem.getPhone(), "Updated phone should match");
        }

        @Test
    void testShowTradeView(){
        ShowTradeView showTradeView = new ShowTradeView();

        }

    @Test
    void testCreateCardPanel() {
        ShowTradeView showTradeView = new ShowTradeView();
        JPanel cardPanel = showTradeView.createCardPanel("Description", "Category", "Price", "Name", "Email", "Phone");

        assertNotNull(cardPanel, "Card panel should not be null");
        assertEquals(BorderLayout.class, cardPanel.getLayout().getClass(), "Layout should be BorderLayout");

        // Verify that the panel contains the expected labels
        verifyLabel(cardPanel, BorderLayout.NORTH, "Description: Description");
        verifyLabel(cardPanel, BorderLayout.CENTER, "Category: Category");
        verifyLabel(cardPanel, BorderLayout.SOUTH, "Price: $Price");
    }

    private void verifyLabel(JPanel panel, Object position, String expectedText) {
        Component comp = ((BorderLayout) panel.getLayout()).getLayoutComponent(position);
        assertNotNull(comp, "Component should not be null");
        assertTrue("Component should be a JLabel", comp instanceof JLabel);
        assertEquals(expectedText, ((JLabel) comp).getText(), "Text should match");
    }

    // Assume that openDetailedView is accessible for testing, possibly by changing its access level
    @Test
    void testOpenDetailedView() {
        ShowTradeView showTradeView = new ShowTradeView();
        showTradeView.openDetailedView("Description", "Category", "Price", "Name", "Email", "Phone");

    }

    @Test
    void testOnSubmit(){
        TradeView tradeView = new TradeView();
        tradeView.onSubmit();

    }


    private static final String EMAIL_REGEX = "your_email_regex_here";
    private static final String PHONE_REGEX = "your_phone_regex_here";

    @Test
    void testValidateInput_AllFieldsCorrect() {
        TradeView tradeView = new TradeView();
        String result = tradeView.validateInput("Category", "Description", "100", "Name", "email@example.com", "1234567890");
        assertEquals("", result, "Validation should pass with all correct fields");
    }

    @Test
    void testValidateInput_EmptyFields() {
        TradeView tradeView = new TradeView();
        String result = tradeView.validateInput("", "Description", "100", "Name", "email@example.com", "1234567890");
        assertEquals("All fields are required.", result, "Validation should fail with empty fields");
    }

    @Test
    void testValidateInput_InvalidPrice() {
        TradeView tradeView = new TradeView();
        String result = tradeView.validateInput("Category", "Description", "invalid_price", "Name", "email@example.com", "1234567890");
        assertEquals("Invalid price format.", result, "Validation should fail with invalid price format");
    }

    @Test
    void testValidateInput_InvalidEmail() {
        TradeView tradeView = new TradeView();
        String result = tradeView.validateInput("Category", "Description", "100", "Name", "invalid_email", "1234567890");
        assertEquals("Invalid email format.", result, "Validation should fail with invalid email format");
    }

    @Test
    void testValidateInput_InvalidPhone() {
        TradeView tradeView = new TradeView();
        String result = tradeView.validateInput("Category", "Description", "100", "Name", "email@example.com", "invalid_phone");
        assertEquals("Invalid phone format.", result, "Validation should fail with invalid phone format");
    }

    @Test
    void testTradeInputOutputData(){
        TradeInputData tradeInputData = new TradeInputData("Description", "category", "price", "contactname","email", "phone");
        TradeOutputData tradeOutputData = new TradeOutputData("Description", "category", "price", "contactname","email", "phone");
        assertEquals(tradeOutputData.getMessage(),"Success");


    }


}
