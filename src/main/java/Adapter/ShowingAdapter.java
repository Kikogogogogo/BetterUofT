package Adapter;

import Entity.Post;
import Entity.Reply;
import use_case.postandreply.PostUsecase;
import use_case.postandreply.ReplyUsecase;

public class ShowingAdapter {
    private PostUsecase postUsecase;
    private ReplyUsecase replyUsecase;

    public ShowingAdapter(PostUsecase postUsecase, ReplyUsecase replyUsecase) {
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
