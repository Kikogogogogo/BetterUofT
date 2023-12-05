package Entity;
import java.sql.Timestamp;


public class Report {
    private Long reportId;
    private Long userId;
    private Long itemId;
    private Timestamp timestamp;
    private String description;


    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}