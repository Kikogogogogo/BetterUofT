package View.trade;

import Data.CsvTradeDataAccess;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ShowTradeView extends JFrame {
    private CsvTradeDataAccess tradeDataAccess = new CsvTradeDataAccess("trade.csv");
    public ShowTradeView() {
        setTitle("Trade Items");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        // Panel to hold cards
        JPanel cardsPanel = new JPanel();
        cardsPanel.setLayout(new BoxLayout(cardsPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(cardsPanel);
        panel.add(scrollPane, BorderLayout.CENTER);

        //return all information stored in csv
        List<String[]> output = tradeDataAccess.getAllTrade();
        for (String[] item : output) {
            //description, categorty, price, name, email, phone
            JPanel card = createCardPanel(item[0], item[1], item[2], item[3],
                    item[4], item[5]);
            cardsPanel.add(card);
        }
        setVisible(true);
    }
    public JPanel createCardPanel(String description, String category, String price, String name, String email, String phone) {
        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        cardPanel.add(new JLabel("Description: " + description), BorderLayout.NORTH);
        cardPanel.add(new JLabel("Category: " + category), BorderLayout.CENTER);
        cardPanel.add(new JLabel("Price: $" + price), BorderLayout.SOUTH);

        // Additional styling
        cardPanel.setPreferredSize(new Dimension(350, 100)); // Adjust size as needed
        cardPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openDetailedView(description, category, price, name, email, phone); // Implement openDetailedView method
            }
        });

        return cardPanel;
    }
    public void openDetailedView(String description, String category, String price, String name, String email, String phone) {
        // 'this' refers to the parent frame
        JDialog detailDialog = new JDialog(this, "Item Details", true);
        detailDialog.setSize(300, 200);
        // 0 rows, 1 column for a vertical layout
        detailDialog.setLayout(new GridLayout(0, 1));

        // Add item details
        detailDialog.add(new JLabel("Description: " + description));
        detailDialog.add(new JLabel("Category: " + category));
        detailDialog.add(new JLabel("Price: " + price));


        JButton contactButton = new JButton("Contact");
        detailDialog.add(contactButton, BorderLayout.SOUTH);

        // Button ActionListener
        contactButton.addActionListener(e -> showContactDialog(name, email, phone));

        // Add a close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> detailDialog.dispose());
        detailDialog.add(closeButton);

        // Display the dialog
        // Center it relative to the parent frame
        detailDialog.setLocationRelativeTo(this);
        detailDialog.setVisible(true);
    }

    private static void showContactDialog(String name, String email, String phone) {
        JDialog contactDialog = new JDialog();
        contactDialog.setTitle("Contact Information");

        // Set layout
        contactDialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        // Ensure components stretch to fill the horizontal space
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Increase insets for better spacing
        gbc.insets = new Insets(5, 10, 5, 10);

        // Name label and field
        contactDialog.add(new JLabel("Contact Person:"), gbc);
        JTextField nameField = new JTextField(name, 20);
        nameField.setEditable(false); // Assuming the field should not be editable
        contactDialog.add(nameField, gbc);

        // Email label and field
        contactDialog.add(new JLabel("Email:"), gbc);
        JTextField emailField = new JTextField(email, 20);
        emailField.setEditable(false); // Assuming the field should not be editable
        contactDialog.add(emailField, gbc);

        // Phone label and field
        contactDialog.add(new JLabel("Phone:"), gbc);
        JTextField phoneField = new JTextField(phone, 20);
        phoneField.setEditable(false); // Assuming the field should not be editable
        contactDialog.add(phoneField, gbc);

        // Close button
        gbc.fill = GridBagConstraints.NONE; // Reset fill for button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> contactDialog.dispose());
        contactDialog.add(closeButton, gbc);

        nameField.setEditable(false);
        emailField.setEditable(false);
        phoneField.setEditable(false);

        contactDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        // Adjust the dialog box size and make it visible
        contactDialog.pack(); // Automatically adjust the size based on its contents
        contactDialog.setLocationRelativeTo(null); // Center it on screen
        contactDialog.setVisible(true);
        nameField.setEditable(false);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShowTradeView::new);
    }
}
