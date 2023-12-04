package Data.PostandReply;
import Entity.Reply;
import java.util.List;

public interface ReplyRepoAccess {
    void save(Reply reply);
    List<Reply> getRepliesForPost(String postId);
}