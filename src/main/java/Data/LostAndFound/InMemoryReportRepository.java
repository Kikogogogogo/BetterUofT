package Data.LostAndFound;
import Entity.LostAndFound.Report;

import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.sql.Timestamp;

public class InMemoryReportRepository implements ReportRepository {
    private final Map<Long, Report> reports = new HashMap<>();
    private final String csvFilePath = "lostandfound.csv";
    private long currentId = 0;

    public InMemoryReportRepository() {
        loadReportsFromCSV();
    }

    @Override
    public Report save(Report report) {
        if (report.getReportId() == null) {
            report.setReportId((long) (reports.size() + 1));
        }
        reports.put(report.getReportId(), report);
        writeToCSV();
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
        reports.put(report.getReportId(), report);
        writeToCSV();
        return report;
    }

    @Override
    public void delete(Long reportId) {
        reports.remove(reportId);
        writeToCSV();
    }

    private void loadReportsFromCSV() {
        Path path = Paths.get(csvFilePath);
        if (Files.exists(path)) {
            try (BufferedReader br = Files.newBufferedReader(path)) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (!line.trim().isEmpty()) {
                        String[] values = line.split(",");
                        if (values.length >= 5) {
                            try {
                                Report report = new Report();
                                report.setReportId(Long.parseLong(values[0].trim()));
                                report.setUserId(Long.parseLong(values[1].trim()));
                                report.setItemId(Long.parseLong(values[2].trim()));
                                report.setTimestamp(Timestamp.valueOf(values[3].trim()));
                                report.setDescription(values[4].trim());
                                reports.put(report.getReportId(), report);
                                currentId = Math.max(currentId, report.getReportId());
                            } catch (NumberFormatException | DateTimeParseException e) {
                                System.err.println("Skipping invalid line: " + line);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeToCSV() {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(csvFilePath))) {
            for (Report report : reports.values()) {
                String[] reportDetails = {
                        report.getReportId().toString(),
                        report.getUserId().toString(),
                        report.getItemId().toString(),
                        report.getTimestamp().toString(),
                        report.getDescription()
                };
                String line = String.join(",", reportDetails);
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}