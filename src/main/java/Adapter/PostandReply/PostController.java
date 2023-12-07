package Adapter.PostandReply;
import use_case.postandreply.ChatWithHuman.PostUsecase;

public class PostController {
    private PostUsecase postUsecase;

    public PostController(PostUsecase postUsecase) {
        this.postUsecase = postUsecase;
    }

    public void createPost(String message) {
        postUsecase.createPost(message);
    }
}
