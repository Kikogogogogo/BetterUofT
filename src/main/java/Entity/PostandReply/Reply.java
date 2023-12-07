package Entity.PostandReply;

import java.io.Serializable;

public class Reply implements Serializable {
    private String id;
    private String postId;
    private String message;

    public Reply(String id, String postId, String message) {
        this.id = id;
        this.postId = postId;
        this.message = message;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Reply ID: " + id + " | Post ID: " + postId + " | Content: " + message;
    }
}
