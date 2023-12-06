package View.trade;

import Adapter.trade.TradeController;
import Adapter.trade.TradePresenter;
import Data.ClubDataAccess;
import Data.ClubDataAccessObject;
import Data.CsvTradeDataAccess;
import use_case.trade.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
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
    private void onSubmit() {
        String category = categoryField.getText();
        String description = descriptionArea.getText();
        String priceText = priceField.getText();
        String contactName = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String[] input = {category, description, priceText, contactName, email, phone};
        tradeController.submitTrade(input);
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
