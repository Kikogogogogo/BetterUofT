package View.LostAndFound;

import Data.InMemoryReportRepository;
import Data.ReportRepository;
import Entity.Report;
import View.GUI.FinalApp;
import use_case.LostAndFound.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.Optional;


public class ReportApplication extends JFrame {
    private ReportController reportController;

    private JTextField reportIdField, userIdField, itemIdField, descriptionField;
    private JButton submitButton, findButton, updateButton, deleteButton, backToFinalAppButton, closeButton;
    private JPanel panel;

    public ReportApplication() {
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        reportIdField = new JTextField(20);
        userIdField = new JTextField(20);
        itemIdField = new JTextField(20);
        descriptionField = new JTextField(20);

        submitButton = new JButton("Submit lost item");
        findButton = new JButton("Find lost item");
        updateButton = new JButton("Update item");
        deleteButton = new JButton("Delete lost item report");
        backToFinalAppButton = new JButton("Back to main page");
        closeButton = new JButton("Close Program");

        submitButton.addActionListener(e -> submitReport());
        findButton.addActionListener(e -> findReport());
        updateButton.addActionListener(e -> updateReport());
        deleteButton.addActionListener(e -> deleteReport());
        backToFinalAppButton.addActionListener(e -> openFinalApp());
        closeButton.addActionListener(e -> closeProgram());

        panel.add(new JLabel("Report ID:"));
        panel.add(reportIdField);
        panel.add(new JLabel("User ID:"));
        panel.add(userIdField);
        panel.add(new JLabel("Item ID:"));
        panel.add(itemIdField);
        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);

        panel.add(submitButton);
        panel.add(findButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(backToFinalAppButton);
        panel.add(closeButton);

        add(panel, BorderLayout.CENTER);
        pack();
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