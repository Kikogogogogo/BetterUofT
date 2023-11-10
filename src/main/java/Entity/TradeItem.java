package Entity;

import java.sql.Timestamp;

public abstract class TradeItem implements entity.Item {
    private String name;
    private String description;
    private Timestamp timestamp;
    private String id;
    private boolean traded;

    public TradeItem(String name, String description, String date, String time, Timestamp timestamp, String id, boolean status) {
        this.name = name;
        this.description = description;
        this.timestamp = timestamp;
        this.id = id;
        this.traded = status;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getTimestamp() { return timestamp; }

    public String getId() { return id; }

    public boolean getStatus() { return traded; }

    public void setStatus(boolean status) { this.traded = status; }
}
