package View.LostAndFound;

import API.LAFAutoCorrect;
import Adapter.LostAndFound.ReportController;
import App.FinalApp;
import Data.LostAndFound.InMemoryReportRepository;
import Data.LostAndFound.ReportRepository;
import Entity.LostAndFound.Report;
import use_case.LostAndFound.*;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Optional;


public class ReportApplication extends JFrame {
    private ReportController reportController;

    private JTextField reportIdField, userIdField, itemIdField;

    private JTextArea descriptionField;
    private JButton submitButton, findButton, updateButton, deleteButton, backToFinalAppButton, closeButton, displayAllButton, autoCorrectButton;

    private LAFAutoCorrect autoCorrector = new LAFAutoCorrect();

    private JPanel panel;

    private FinalApp finalApp;


    public ReportApplication() {
        this.finalApp = finalApp;

        initializeUI();
        ReportRepository reportRepository = new InMemoryReportRepository();

        CreateReport createReport = new CreateReport(reportRepository);
        FindReport findReport = new FindReport(reportRepository);
        UpdateReport updateReport = new UpdateReport(reportRepository);
        DeleteReport deleteReport = new DeleteReport(reportRepository);

        reportController = new ReportController(createReport, findReport, updateReport, deleteReport);
    }

    private void initializeUI() {
        setTitle("Lost and Found Management System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel fieldsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        reportIdField = new JTextField(20);
        userIdField = new JTextField(20);
        itemIdField = new JTextField(20);
        descriptionField = new JTextArea(5, 20);
        descriptionField.setLineWrap(true);
        descriptionField.setWrapStyleWord(true);

        addField(fieldsPanel, "Report ID:", reportIdField, gbc);
        addField(fieldsPanel, "User ID:", userIdField, gbc);
        addField(fieldsPanel, "Item ID:", itemIdField, gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        addField(fieldsPanel, "Lost item description:", new JScrollPane(descriptionField), gbc);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        submitButton = new JButton("Submit lost item");
        findButton = new JButton("Find lost item");
        updateButton = new JButton("Update item");
        deleteButton = new JButton("Delete lost item report");
        backToFinalAppButton = new JButton("Back to main page");
        displayAllButton = new JButton("Display All Lost items");
        closeButton = new JButton("Close Program");

        closeButton.setBackground(Color.LIGHT_GRAY);
        closeButton.setForeground(Color.black);

        autoCorrectButton = new JButton("Auto Correct");

        submitButton.addActionListener(e -> submitReport());
        findButton.addActionListener(e -> findReport());
        updateButton.addActionListener(e -> updateReport());
        deleteButton.addActionListener(e -> deleteReport());
        backToFinalAppButton.addActionListener(e -> openFinalApp());
        closeButton.addActionListener(e -> closeProgram());
        displayAllButton.addActionListener(e -> displayAllReports());
        autoCorrectButton.addActionListener(e -> autoCorrectDescription());



        buttonPanel.add(submitButton);
        buttonPanel.add(findButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(autoCorrectButton);
        buttonPanel.add(backToFinalAppButton);
        buttonPanel.add(closeButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(fieldsPanel);
        mainPanel.add(buttonPanel);


        add(mainPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void autoCorrectDescription() {
        String originalText = descriptionField.getText();
        String correctedText = autoCorrector.getCorrectedText(originalText);
        descriptionField.setText(correctedText);
    }

    private void addField(JPanel panel, String label, Component field, GridBagConstraints gbc) {
        panel.add(new JLabel(label), gbc);
        panel.add(field, gbc);
    }

    private void displayAllReports() {
        String csvFilePath = "lostandfound.csv";
        JTextArea textArea = new JTextArea(20, 40);
        textArea.setEditable(false);

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                textArea.append(formatReportLine(line) + "\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(this, scrollPane, "All Reports", JOptionPane.INFORMATION_MESSAGE);
    }

    private String formatReportLine(String line) {
        String[] values = line.split(",");
        if (values.length == 5) {
            return "Report ID: " + values[0] + "\n"
                    + "User ID: " + values[1] + "\n"
                    + "Lost Item ID: " + values[2] + "\n"
                    + "Last updated: " + values[3] + "\n"
                    + "Lost item description: " + values[4];
        }
        return "Invalid report format";
    }

    private void submitReport() {
        try {
            Report report = new Report();
            if (!userIdField.getText().trim().isEmpty()) {
                report.setUserId(Long.parseLong(userIdField.getText().trim()));
            }
            if (!itemIdField.getText().trim().isEmpty()) {
                report.setItemId(Long.parseLong(itemIdField.getText().trim()));
            }
            report.setDescription(descriptionField.getText());
            report.setTimestamp(new Timestamp(System.currentTimeMillis()));
            reportController.createReport(report);
            clearFields();
            JOptionPane.showMessageDialog(this, "Lost item submitted successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for User ID and Item ID.");
        }
    }

    private void findReport() {
        try {
            Long reportId = Long.parseLong(reportIdField.getText().trim());
            Optional<Report> report = reportController.findReport(reportId);
            report.ifPresentOrElse(
                    r -> {
                        userIdField.setText(r.getUserId().toString());
                        itemIdField.setText(r.getItemId().toString());
                        descriptionField.setText(r.getDescription());
                    },
                    () -> JOptionPane.showMessageDialog(this, "Lost item not found!"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Report ID.");
        }
    }

    private void updateReport() {
        try {
            Long reportId = Long.parseLong(reportIdField.getText().trim());
            Report report = new Report();
            report.setReportId(reportId);
            if (!userIdField.getText().trim().isEmpty()) {
                report.setUserId(Long.parseLong(userIdField.getText().trim()));
            }
            if (!itemIdField.getText().trim().isEmpty()) {
                report.setItemId(Long.parseLong(itemIdField.getText().trim()));
            }
            report.setDescription(descriptionField.getText());
            report.setTimestamp(new Timestamp(System.currentTimeMillis()));
            reportController.updateReport(report);
            JOptionPane.showMessageDialog(this, "Lost item updated successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid data.");
        }
    }

    private void deleteReport() {
        try {
            Long reportId = Long.parseLong(reportIdField.getText().trim());
            reportController.deleteReport(reportId);
            clearFields();
            JOptionPane.showMessageDialog(this, "Lost item deleted successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Report ID.");
        }
    }

    private void openFinalApp() {
        SwingUtilities.invokeLater(() -> {
            FinalApp finalApp = new FinalApp();
            finalApp.setVisible(true);
        });
        dispose();
    }

    private void closeProgram() {
        dispose();
    }

    private void clearFields() {
        reportIdField.setText("");
        userIdField.setText("");
        itemIdField.setText("");
        descriptionField.setText("");
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReportApplication reportApp = new ReportApplication();
            reportApp.setVisible(true);
        });
    }
}
