package Adapter.PostandReply;

import use_case.postandreply.ReplyUsecase;

public class ReplyController {
    private ReplyUsecase replyUsecase;

    public ReplyController(ReplyUsecase replyUsecase) {
        this.replyUsecase = replyUsecase;
    }

    public void createReply(String postId, String message) {
        replyUsecase.createReply(postId, message);
    }
}
