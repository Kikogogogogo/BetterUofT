package View.LostAndFound;

import Data.InMemoryReportRepository;
import Data.ReportRepository;
import Entity.Report;
import use_case.LostAndFound.*;

import javax.swing.*;
import java.util.Optional;


public class ReportApplication {
    private JFrame frame;
    private JTextField reportField;
    private JTextField reportIdField;
    private JButton submitButton, findButton, updateButton, deleteButton;
    private ReportController reportController;

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
        frame = new JFrame("Report Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        reportField = new JTextField(20);
        reportIdField = new JTextField(20);
        submitButton = new JButton("Submit Report");
        findButton = new JButton("Find Report");
        updateButton = new JButton("Update Report");
        deleteButton = new JButton("Delete Report");

        submitButton.addActionListener(e -> submitReport());
        findButton.addActionListener(e -> findReport());
        updateButton.addActionListener(e -> updateReport());
        deleteButton.addActionListener(e -> deleteReport());

        frame.add(new JLabel("Report ID:"));
        frame.add(reportIdField);
        frame.add(new JLabel("Report Details:"));
        frame.add(reportField);
        frame.add(submitButton);
        frame.add(findButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.pack();
        frame.setVisible(true);
    }

    private void submitReport() {
        Report report = new Report();
        report.setDescription(reportField.getText());
        reportController.createReport(report);
        JOptionPane.showMessageDialog(frame, "Report submitted successfully!");
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
        JOptionPane.showMessageDialog(frame, "Report updated successfully!");
    }

    private void deleteReport() {
        Long reportId = Long.parseLong(reportIdField.getText());
        reportController.deleteReport(reportId);
        JOptionPane.showMessageDialog(frame, "Report deleted successfully!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReportApplication());
    }
}