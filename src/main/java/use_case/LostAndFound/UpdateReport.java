package use_case.LostAndFound;

import Data.ReportRepository;
import Entity.Report;

public class UpdateReport {
    private ReportRepository reportRepository;

    public UpdateReport(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report updateReport(Report report) {
        return reportRepository.update(report);
    }
}