package lostAndFoundTest;

import static org.junit.Assert.*;

import Adapter.LostAndFound.ReportController;
import Data.LostAndFound.InMemoryReportRepository;
import Entity.LostAndFound.Report;
import org.junit.Test;
import use_case.LostAndFound.*;

import java.sql.Timestamp;
import java.util.Optional;

public class ReportControllerTest {
    private ReportController reportController;
    private InMemoryReportRepository reportRepository;

    @Test
    public void testUpdateReport() {
        reportRepository = new InMemoryReportRepository();
        reportController = new ReportController(
                new CreateReport(reportRepository),
                new FindReport(reportRepository),
                new UpdateReport(reportRepository),
                new DeleteReport(reportRepository));
        Report newReport = new Report();
        newReport.setUserId(1L);
        newReport.setItemId(1L);
        newReport.setDescription("Original Description");
        newReport.setTimestamp(new Timestamp(System.currentTimeMillis())); // Set timestamp
        Report createdReport = reportController.createReport(newReport);

        createdReport.setDescription("Updated Description");
        Report updatedReport = reportController.updateReport(createdReport);

        assertNotNull(updatedReport);
        assertEquals("Updated Description", updatedReport.getDescription());

        Optional<Report> foundReport = reportController.findReport(createdReport.getReportId());
        assertTrue(foundReport.isPresent());
        assertEquals("Updated Description", foundReport.get().getDescription());
    }

    @Test
    public void testDeleteReport() {
        reportRepository = new InMemoryReportRepository();
        reportController = new ReportController(
                new CreateReport(reportRepository),
                new FindReport(reportRepository),
                new UpdateReport(reportRepository),
                new DeleteReport(reportRepository));
        Report newReport = new Report();
        newReport.setUserId(1L);
        newReport.setItemId(1L);
        newReport.setDescription("Report to Delete");
        newReport.setTimestamp(new Timestamp(System.currentTimeMillis())); // Set timestamp
        Report createdReport = reportController.createReport(newReport);

        reportController.deleteReport(createdReport.getReportId());
        Optional<Report> foundReport = reportController.findReport(createdReport.getReportId());
        assertFalse(foundReport.isPresent());
    }
}