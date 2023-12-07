package Entity.PostandReply;

import java.io.Serializable;

public class Post implements Serializable {
    private String id;
    private String message;

    public Post(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Post ID: " + id + " | Content: " + message;
    }
}
