package Data;
import Entity.Reply;
import java.util.List;

public interface ReplyRepo {
    void save(Reply reply);
    List<Reply> getRepliesForPost(String postId);
}