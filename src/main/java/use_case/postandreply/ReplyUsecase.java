package use_case.postandreply;
import Data.PostandReply.ReplyRepoAccess;
import Entity.Reply;
import java.util.List;
import java.util.UUID;

public class ReplyUsecase {
    private final ReplyRepoAccess replyRepoAccess;

    public ReplyUsecase(ReplyRepoAccess replyRepoAccess) {
        this.replyRepoAccess = replyRepoAccess;
    }

    public void createReply(String postId, String message) {
        String id = UUID.randomUUID().toString();
        Reply reply = new Reply(id, postId, message);
        replyRepoAccess.save(reply);
    }

    public List<Reply> getRepliesForPost(String postId) {
        return replyRepoAccess.getRepliesForPost(postId);
    }
}
