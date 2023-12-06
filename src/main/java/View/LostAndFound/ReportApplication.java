package View.LostAndFound;

import Data.InMemoryReportRepository;
import Data.ReportRepository;
import Entity.Report;
import View.GUI.FinalApp;
import use_case.LostAndFound.*;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;


public class ReportApplication extends JFrame {
    private ReportController reportController;

    private JFrame frame;
    private JTextField reportField, reportIdField;
    private JButton submitButton, findButton, updateButton, deleteButton ,backToFinalAppButton, closeButton;
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
        reportField = new JTextField(20);
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
        backToFinalAppButton.addActionListener(e -> {
            openFinalApp();
            dispose();
        });
        closeButton.addActionListener(e -> closeProgram());

        closeButton.setBackground(Color.LIGHT_GRAY);
        closeButton.setForeground(Color.black);

        panel.add(new JLabel("Item ID:"));
        panel.add(reportIdField);
        panel.add(new JLabel("Item Details:"));
        panel.add(reportField);
        panel.add(submitButton);
        panel.add(findButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(backToFinalAppButton);
        panel.add(closeButton);


        add(panel, BorderLayout.CENTER);
        pack();
    }

    private void closeProgram() {
        dispose();
    }

    private void openFinalApp() {
        SwingUtilities.invokeLater(() -> {
            FinalApp finalApp = new FinalApp();
            finalApp.setVisible(true);
        });
    }

    private void submitReport() {
        Report report = new Report();
        report.setDescription(reportField.getText());
        reportController.createReport(report);
        JOptionPane.showMessageDialog(frame, "Lost and Found report submitted successfully!");
    }

    private void findReport() {
        Long reportId = Long.parseLong(reportIdField.getText());
        Optional<Report> report = reportController.findReport(reportId);
        report.ifPresentOrElse(
                r -> reportField.setText(r.getDescription()),
                () -> JOptionPane.showMessageDialog(frame, "Report not found!"));
    }

    private void updateReport() {
        Long reportId = Long.parseLong(reportIdField.getText());
        Report report = new Report();
        report.setReportId(reportId);
        report.setDescription(reportField.getText());
        reportController.updateReport(report);
        JOptionPane.showMessageDialog(frame, "Lost and Found report updated successfully!");
    }

    private void deleteReport() {
        Long reportId = Long.parseLong(reportIdField.getText());
        reportController.deleteReport(reportId);
        JOptionPane.showMessageDialog(frame, "Lost and Found report deleted successfully!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReportApplication reportApp = new ReportApplication();
            reportApp.setVisible(true);
        });
    }
}