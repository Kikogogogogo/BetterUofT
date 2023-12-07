package Data.PostandReply;
import Entity.PostandReply.Reply;
import java.util.List;

public interface ReplyRepoAccess {
    void save(Reply reply);
    List<Reply> getRepliesForPost(String postId);
}