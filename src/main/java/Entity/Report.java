package Entity;
import java.sql.Timestamp;


public class Report {
    private Long reportId;
    private Long userId;
    private Long itemId;
    private Timestamp timestamp;
    private String description;

    // Constructors...

    // Getter for reportId
    public Long getReportId() {
        return reportId;
    }

    // Setter for reportId
    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Other getters and setters...
}