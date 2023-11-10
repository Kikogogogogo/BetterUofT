package entity;

public interface Item {
    String getName();
    String getDescription();
    String getLocation();
    String getDate();
    String getTime();
    String getId();
    boolean getStatus();
    void setStatus(boolean status);
}
