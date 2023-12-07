package use_case.LostAndFound;

import Data.LostAndFound.ReportRepository;
import Entity.LostAndFound.Report;

public class UpdateReport {
    private ReportRepository reportRepository;

    public UpdateReport(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report updateReport(Report report) {
        return reportRepository.update(report);
    }
}