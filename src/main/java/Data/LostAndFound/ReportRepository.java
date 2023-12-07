package Data.LostAndFound;
import Entity.LostAndFound.Report;

import java.util.List;
import java.util.Optional;

public interface ReportRepository {
    Report save(Report report);
    Optional<Report> findById(Long reportId);
    List<Report> findAll();
    Report update(Report report);
    void delete(Long reportId);
}
