package View.LostAndFound;
import Data.InMemoryReportRepository;
import Data.ReportRepository;
import Entity.Report;
import use_case.LostAndFound.*;

import javax.swing.*;


public class ReportApplication {
    private JFrame frame;
    private JTextField reportField;
    private JButton submitButton;
    private JButton reportButton;
    private JButton findButton;
    private JButton deleteButton;

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
        frame = new JFrame("Report System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        reportField = new JTextField(20);
        submitButton = new JButton("Submit Report");
        submitButton.addActionListener(e -> submitReport());

        frame.add(new JLabel("Enter Report Details:"));
        frame.add(reportField);
        frame.add(submitButton);
        frame.pack();
        frame.setVisible(true);
    }
    private void startUI() {
        frame = new JFrame("Report");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        reportField = new JTextField(25);
        reportButton = new JButton("Submit Report");
        findButton = new JButton("find Report");
        deleteButton = new JButton("delete Report");



    }


    private void submitReport() {
        Report report = new Report();
        report.setDescription(reportField.getText());
        // Set other report fields as necessary

        reportController.createReport(report);
        JOptionPane.showMessageDialog(frame, "Report submitted successfully!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReportApplication());
    }
}
