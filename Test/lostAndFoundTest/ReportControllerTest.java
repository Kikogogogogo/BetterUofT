package lostAndFoundTest;

import static org.junit.Assert.*;

import Data.LostAndFound.InMemoryReportRepository;
import Entity.LostAndFound.Report;
import org.junit.Before;
import org.junit.Test;
import use_case.LostAndFound.CreateReport;
import use_case.LostAndFound.DeleteReport;
import use_case.LostAndFound.FindReport;
import use_case.LostAndFound.UpdateReport;

import use_case.LostAndFound.ReportController;


import java.util.Optional;

class ReportControllerTest {
    private ReportController reportController;
    private InMemoryReportRepository reportRepository;

    @Before
    public void setUp() {
        reportRepository = new InMemoryReportRepository();
        CreateReport createReport = new CreateReport(reportRepository);
        FindReport findReport = new FindReport(reportRepository);
        UpdateReport updateReport = new UpdateReport(reportRepository);
        DeleteReport deleteReport = new DeleteReport(reportRepository);
        reportController = new ReportController(createReport, findReport, updateReport, deleteReport);
    }

    @Test
    public void testUpdateReport() {
        Report reportToUpdate = new Report();
        reportToUpdate.setReportId(1L);
        reportToUpdate.setUserId(1L);
        reportToUpdate.setItemId(1L);
        reportToUpdate.setReportId(1L);
        reportToUpdate.setDescription("Updated Description");

        Report updatedReport = reportController.updateReport(reportToUpdate);
        assertNotNull(updatedReport);
        assertEquals("Updated Description", updatedReport.getDescription());

        Optional<Report> foundReport = reportController.findReport(1L);
        assertTrue(foundReport.isPresent());
        assertEquals("Updated Description", foundReport.get().getDescription());
    }

    @Test
    public void testDeleteReport() {
        Report newReport = new Report();

        newReport.setReportId(2L);
        newReport.setUserId(789L);
        newReport.setItemId(1011L);
        newReport.setDescription("Report to Delete");

        reportController.createReport(newReport);

        // Test Delete
        reportController.deleteReport(2L);
        Optional<Report> foundReport = reportController.findReport(2L);
        assertTrue(foundReport.isEmpty());
    }
}