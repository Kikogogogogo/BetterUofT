package Data;
import Entity.Report;

import java.util.*;

public class InMemoryReportRepository implements ReportRepository {
    private final Map<Long, Report> reports = new HashMap<>();
    private long currentId = 0;

    @Override
    public Report save(Report report) {
        if (report.getReportId() == null) {
            report.setReportId(++currentId);
        }
        reports.put(report.getReportId(), report);
        return report;
    }

    @Override
    public Optional<Report> findById(Long reportId) {
        return Optional.ofNullable(reports.get(reportId));
    }

    @Override
    public List<Report> findAll() {
        return new ArrayList<>(reports.values());
    }

    @Override
    public Report update(Report report) {
        Long reportId = report.getReportId();
        if (reportId == null || !reports.containsKey(reportId)) {
            throw new IllegalArgumentException("Report not found");
        }
        reports.put(reportId, report);
        return report;
    }

    @Override
    public void delete(Long reportId) {
        if (!reports.containsKey(reportId)) {
            throw new IllegalArgumentException("Report not found");
        }

        reports.remove(reportId);
    }
}