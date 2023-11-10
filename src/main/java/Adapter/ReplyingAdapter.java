package Adapter;

import use_case.postandreply.ReplyUsecase;

public class ReplyingAdapter {
    private ReplyUsecase replyUsecase;

    public ReplyingAdapter(ReplyUsecase replyUsecase) {
        this.replyUsecase = replyUsecase;
    }

    public void createReply(String postId, String message) {
        replyUsecase.createReply(postId, message);
    }
}
