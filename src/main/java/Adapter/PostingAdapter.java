package Adapter;

import use_case.postandreply.PostUsecase;

public class PostingAdapter {
    private PostUsecase postUsecase;

    public PostingAdapter(PostUsecase postUsecase) {
        this.postUsecase = postUsecase;
    }

    public void createPost(String message) {
        postUsecase.createPost(message);
    }
}
