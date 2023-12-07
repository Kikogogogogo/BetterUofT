package use_case.LostAndFound;

import Data.LostAndFound.ReportRepository;
import Entity.LostAndFound.Report;

public class CreateReport {
    private final ReportRepository reportRepository;

    public CreateReport(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report createNewReport(Report report) {
        return reportRepository.save(report);
    }

}