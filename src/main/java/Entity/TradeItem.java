package Entity;

import java.sql.Timestamp;

public abstract class TradeItem implements Entity.Item {
    private String name;
    private String description;
    private Timestamp timestamp;
    private String id;
    private boolean traded;
    private String category;

    public TradeItem(String name, String description, String date, String time, Timestamp timestamp, String id, boolean status, String category) {
        this.name = name;
        this.description = description;
        this.timestamp = timestamp;
        this.id = id;
        this.traded = status;
        this.category = category;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}