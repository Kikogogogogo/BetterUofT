package Entity;

public class FoundItem implements entity.Item {
    private String name;
    private String description;
    private String location;
    private String date;
    private String time;
    private String id;
    private boolean claimed;

    public FoundItem(String name, String description, String location, String date, String time, String id, boolean status) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;
        this.id = id;
        this.claimed = status;
    }

    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }

    public String getLocation() { return location; }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getId() { return id; }

    public boolean getStatus() { return claimed; }

    public void setStatus(boolean status) { this.claimed = status; }
}
