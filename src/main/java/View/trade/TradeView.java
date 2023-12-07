package View.trade;

import Adapter.trade.TradeController;
import Adapter.trade.TradePresenter;
import Data.Trade.CsvTradeDataAccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class TradeView extends JFrame {

    private JTextField categoryField;
    private JTextArea descriptionArea;
    private JTextField priceField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;

    private JButton submitButton;
    private TradePresenter presenter = new TradePresenter(this);
    private CsvTradeDataAccess tradeDataAccess = new CsvTradeDataAccess("trade.csv");
    private final TradeController tradeController = new TradeController(presenter, tradeDataAccess);

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PHONE_REGEX = "^\\d{10}$"; // Example for a 10-digit phone number without any dashes or spaces


    public TradeView() {
        setTitle("Trade Item");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        add(createFormPanel(), BorderLayout.CENTER);
        add(createSubmitButton(), BorderLayout.PAGE_END);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(4, 4, 4, 4);

        formPanel.add(new JLabel("Category:"), gbc);
        categoryField = new JTextField(20);
        formPanel.add(categoryField, gbc);

        formPanel.add(new JLabel("Description:"), gbc);
        descriptionArea = new JTextArea(5, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(descriptionArea);
        formPanel.add(scrollPane, gbc);

        formPanel.add(new JLabel("Price:"), gbc);
        priceField = new JTextField(20);
        formPanel.add(priceField, gbc);

        formPanel.add(new JLabel("Contact Name:"), gbc);
        nameField = new JTextField(20);
        formPanel.add(nameField, gbc);

        // Email
        formPanel.add(new JLabel("Email:"), gbc);
        emailField = new JTextField(20);
        formPanel.add(emailField, gbc);

        // Phone
        formPanel.add(new JLabel("Phone:"), gbc);
        phoneField = new JTextField(20);
        formPanel.add(phoneField, gbc);

        gbc.weightx = 1;
        gbc.weighty = 1;
        formPanel.add(new JLabel(""), gbc);

        return formPanel;
    }

    private JButton createSubmitButton() {
        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 40));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSubmit();
            }
        });
        return submitButton;
    }
    public void onSubmit() {
        String category = categoryField.getText();
        String description = descriptionArea.getText();
        String priceText = priceField.getText();
        String contactName = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String validationError = validateInput(category, description, priceText, contactName, email, phone);
        if (!validationError.isEmpty()) {
            JOptionPane.showMessageDialog(this, validationError, "Input Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop further processing if there is a validation error
        }
        String[] input = {category, description, priceText, contactName, email, phone};
        tradeController.submitTrade(input);
    }
    public String validateInput(String category, String description, String price, String contactName, String email, String phone) {
        if (category.isEmpty() || description.isEmpty() || price.isEmpty() || contactName.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            return "All fields are required.";
        }
        try {
            Double.parseDouble(price); // Validate if price is a number
        } catch (NumberFormatException e) {
            return "Invalid price format.";
        }
        if (!email.matches(EMAIL_REGEX)) {
            return "Invalid email format.";
        }

        if (!phone.matches(PHONE_REGEX)) {
            return "Invalid phone format.";
        }

        return ""; // Return empty string if all validations pass
    }


    public static void main(String[] args) {
//        String csvFilePath = "trades.csv";
//        TradeOutputBoundary dataAccess = new CsvTradeDataAccess(csvFilePath);
//        TradeInputBoundary interactor = new TradeInteractor(dataAccess);
//        TradeController controller = new TradeController(interactor);
        SwingUtilities.invokeLater(TradeView::new);
}

    public void showResult() {
        showMessageDialog(null, "Item uploaded Successfully");
    }
}
