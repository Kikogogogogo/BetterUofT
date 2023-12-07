package lostAndFoundTest;

import Data.InMemoryReportRepository;
import Entity.Report;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class InMemoryReportRepositoryTest {
    private InMemoryReportRepository repository;

    @Before
    public void setUp() {
        repository = new InMemoryReportRepository();
    }
    @Test
    public void testSaveAndFindById() {
        Report report = new Report();
        report.setDescription("Test");
        report.setUserId(1L);
        report.setItemId(1L);
        report.setTimestamp(new Timestamp(System.currentTimeMillis()));

        Report savedReport = repository.save(report);
        assertNotNull(savedReport);

        Optional<Report> foundReport = repository.findById(savedReport.getReportId());
        assertTrue(foundReport.isPresent());
        assertEquals("Test", foundReport.get().getDescription());
    }
    @Test
    public void testUpdate() {
        Report report = new Report();
        report.setDescription("Original Description");
        report.setUserId(1L);
        report.setItemId(1L);
        report.setTimestamp(new Timestamp(System.currentTimeMillis()));
        Report savedReport = repository.save(report);

        savedReport.setDescription("Updated Description");
        Report updatedReport = repository.update(savedReport);

        assertEquals("Updated Description", updatedReport.getDescription());
    }

    @Test
    public void testDelete() {
        Report report = new Report();
        report.setDescription("Test");
        report.setUserId(1L);
        report.setItemId(1L);
        report.setTimestamp(new Timestamp(System.currentTimeMillis()));

        Report savedReport = repository.save(report);
        repository.delete(savedReport.getReportId());

        Optional<Report> foundReport = repository.findById(savedReport.getReportId());
        assertFalse(foundReport.isPresent());
    }

    @Test
    public void testFindAll() {
        Report report1 = new Report();
        report1.setDescription("Report 1");
        report1.setUserId(1L);
        report1.setItemId(1L);
        report1.setTimestamp(new Timestamp(System.currentTimeMillis()));

        Report report2 = new Report();
        report2.setDescription("Report 2");
        report2.setUserId(2L);
        report2.setItemId(2L);
        report2.setTimestamp(new Timestamp(System.currentTimeMillis()));

        repository.save(report1);
        repository.save(report2);

        List<Report> reports = repository.findAll();
        assertTrue(reports.contains(report2));
    }
}
