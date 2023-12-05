package use_case.LostAndFound;
import java.util.Optional;
import Data.ReportRepository;

public class DeleteReport {
    private ReportRepository reportRepository;

    public DeleteReport(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void deleteReport(Long reportId) {
        reportRepository.delete(reportId);
    }
}
