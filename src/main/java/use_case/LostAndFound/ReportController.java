package use_case.LostAndFound;


import Entity.LostAndFound.Report;

import java.util.Optional;

public class ReportController {
    private CreateReport createReport;
    private FindReport findReport;
    private UpdateReport updateReport;
    private DeleteReport deleteReport;

    public ReportController(CreateReport createReport, FindReport findReport, UpdateReport updateReport, DeleteReport deleteReport) {
        this.createReport = createReport;
        this.findReport = findReport;
        this.updateReport = updateReport;
        this.deleteReport = deleteReport;
    }

    public Report createReport(Report report) {
        return createReport.createNewReport(report);
    }

    public Optional<Report> findReport(Long reportId) {
        return findReport.findReportById(reportId);
    }

    public Report updateReport(Report report) {
        return updateReport.updateReport(report);
    }

    public void deleteReport(Long reportId) {
        deleteReport.deleteReport(reportId);
    }

}