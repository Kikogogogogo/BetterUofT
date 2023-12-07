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

import java.sql.Timestamp;
import java.util.Optional;

public class ReportUseCasesTest {
    private InMemoryReportRepository reportRepository;
    private CreateReport createReport;
    private FindReport findReport;
    private UpdateReport updateReport;
    private DeleteReport deleteReport;

    @Before
    public void setUp() {
        reportRepository = new InMemoryReportRepository();
        createReport = new CreateReport(reportRepository);
        findReport = new FindReport(reportRepository);
        updateReport = new UpdateReport(reportRepository);
        deleteReport = new DeleteReport(reportRepository);
    }

    @Test
    public void testCreateReport() {
        Report newReport = new Report();
        newReport.setReportId(1L);
        newReport.setUserId(1L);
        newReport.setItemId(1L);
        newReport.setTimestamp(new Timestamp(System.currentTimeMillis()));
        newReport.setDescription("Test Description");

        Report savedReport = createReport.createNewReport(newReport);

        assertNotNull(savedReport);
    }

    @Test
    public void testFindReport() {
        Report newReport = new Report();
        newReport.setReportId(1L);
        newReport.setUserId(1L);
        newReport.setItemId(1L);
        newReport.setTimestamp(new Timestamp(System.currentTimeMillis()));
        newReport.setDescription("Test Description");
        newReport.setDescription("Sample report");
        Report savedReport = createReport.createNewReport(newReport);

        Report foundReport = findReport.findReportById(savedReport.getReportId()).orElse(null);

        assertNotNull(foundReport);
        assertEquals("Sample report", foundReport.getDescription());
    }

    @Test
    public void testUpdateReport() {
        Report newReport = new Report();
        newReport.setReportId(1L);
        newReport.setUserId(1L);
        newReport.setItemId(1L);
        newReport.setTimestamp(new Timestamp(System.currentTimeMillis()));
        newReport.setDescription("Sample report");
        Report savedReport = createReport.createNewReport(newReport);

        savedReport.setDescription("Updated report");
        Report updatedReport = updateReport.updateReport(savedReport);

        assertNotNull(updatedReport);
        assertEquals("Updated report", updatedReport.getDescription());
    }

    @Test
    public void testDeleteReport() {
        Report newReport = new Report();
        newReport.setReportId(1L);
        newReport.setUserId(1L);
        newReport.setItemId(1L);
        newReport.setTimestamp(new Timestamp(System.currentTimeMillis()));
        newReport.setDescription("Sample report");
        Report savedReport = createReport.createNewReport(newReport);

        deleteReport.deleteReport(savedReport.getReportId());

        assertFalse(findReport.findReportById(savedReport.getReportId()).isPresent());
    }
}