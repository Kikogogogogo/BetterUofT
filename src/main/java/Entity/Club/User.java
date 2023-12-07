package Entity.Club;

public class User {
    private String username;
    private String password;
    private int id;
    private String email;
    private String major;
    private String yearjoined;

    public User(String username, String password, int id, String email, String major, String yearjoined) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.email = email;
        this.major = major;
        this.yearjoined = yearjoined;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMajor() {
        return major;
    }

    public String getYearJoined() {
        return yearjoined;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
