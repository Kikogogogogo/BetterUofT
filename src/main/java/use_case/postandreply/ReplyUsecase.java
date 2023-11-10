package use_case.postandreply;
import Data.ReplyRepo;
import Entity.Reply;
import java.util.List;
import java.util.UUID;

public class ReplyUsecase {
    private final ReplyRepo replyRepo;

    public ReplyUsecase(ReplyRepo replyRepo) {
        this.replyRepo = replyRepo;
    }

    public void createReply(String postId, String message) {
        String id = UUID.randomUUID().toString();
        Reply reply = new Reply(id, postId, message);
        replyRepo.save(reply);
    }

    public List<Reply> getRepliesForPost(String postId) {
        return replyRepo.getRepliesForPost(postId);
    }
}
