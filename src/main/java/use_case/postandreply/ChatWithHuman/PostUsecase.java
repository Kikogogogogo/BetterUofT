package use_case.postandreply.ChatWithHuman;
import Data.PostandReply.PostRepoAccess;
import Entity.Post;
import java.util.List;

public class PostUsecase implements PostInputBoundary{
    private final PostRepoAccess postRepoAccess;
    private int lastId;
    public PostUsecase(PostRepoAccess postRepoAccess) {
        this.postRepoAccess = postRepoAccess;
        this.lastId = determineLastId();
    }

    private int determineLastId() {
        List<Post> allPosts = postRepoAccess.getAllPosts();
        int maxId = 0;
        for (Post post : allPosts) {
            try {
                int postId = Integer.parseInt(post.getId());
                maxId = Math.max(maxId, postId);
            } catch (NumberFormatException e) {

            }
        }
        return maxId;
    }

    public void createPost(String message) {
        lastId++;
        Post post = new Post(String.valueOf(lastId), message);
        postRepoAccess.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepoAccess.getAllPosts();
    }
}
