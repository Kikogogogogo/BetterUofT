package View.LostAndFound;

import Data.InMemoryReportRepository;
import Data.ReportRepository;
import Entity.Report;
import use_case.LostAndFound.*;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;


public class ReportApplication extends JFrame {
    private ReportController reportController;

    private JFrame frame;
    private JTextField reportField, reportIdField;
    private JButton submitButton, findButton, updateButton, deleteButton;
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
        frame = new JFrame("Lost and Found Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        reportIdField = new JTextField(20);
        reportField = new JTextField(20);
        submitButton = new JButton("Submit lost item");
        findButton = new JButton("Find lost item");
        updateButton = new JButton("Update item");
        deleteButton = new JButton("Delete lost item report");

        submitButton.addActionListener(e -> submitReport());
        findButton.addActionListener(e -> findReport());
        updateButton.addActionListener(e -> updateReport());
        deleteButton.addActionListener(e -> deleteReport());

        panel.add(new JLabel("Item ID:"));
        panel.add(reportIdField);
        panel.add(new JLabel("Item Details:"));
        panel.add(reportField);
        panel.add(submitButton);
        panel.add(findButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
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