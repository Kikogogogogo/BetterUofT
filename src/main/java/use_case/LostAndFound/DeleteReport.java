package use_case.LostAndFound;
import Data.LostAndFound.ReportRepository;

public class DeleteReport {
    private ReportRepository reportRepository;

    public DeleteReport(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void deleteReport(Long reportId) {
        reportRepository.delete(reportId);
    }
}
