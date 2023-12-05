package Adapter.PostandReply;

import Entity.Post;
import Entity.Reply;
import use_case.postandreply.ChatWithHuman.PostUsecase;
import use_case.postandreply.ChatWithHuman.ReplyUsecase;

public class PostandReplyPrensenter {
    private PostUsecase postUsecase;
    private ReplyUsecase replyUsecase;

    public PostandReplyPrensenter(PostUsecase postUsecase, ReplyUsecase replyUsecase) {
        this.postUsecase = postUsecase;
        this.replyUsecase = replyUsecase;
    }

    public java.util.List<Post> getAllPosts() {
        return postUsecase.getAllPosts();
    }

    public java.util.List<Reply> getRepliesForPost(String postId) {
        return replyUsecase.getRepliesForPost(postId);
    }
}
