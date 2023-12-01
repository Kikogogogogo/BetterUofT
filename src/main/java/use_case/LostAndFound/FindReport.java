package use_case.LostAndFound;

import Data.ReportRepository;
import Entity.Report;

import java.util.Optional;

public class FindReport {
    private ReportRepository reportRepository;

    public FindReport(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Optional<Report> findReportById(Long reportId) {
        return reportRepository.findById(reportId);
    }
}