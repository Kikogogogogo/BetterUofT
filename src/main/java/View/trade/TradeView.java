package View.trade;

import javax.swing.*;
import java.awt.*;

public class TradeView extends JFrame {

    private JTextField categoryField;
    private JTextArea descriptionArea;
    private JTextField priceField;
    private JButton submitButton;

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

        gbc.weightx = 1;
        gbc.weighty = 1;
        formPanel.add(new JLabel(""), gbc);

        return formPanel;
    }

    private JButton createSubmitButton() {
        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 40));
        // submitButton.addActionListener(...); // Add action listener to handle submit action
        return submitButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TradeView::new);
    }
}
