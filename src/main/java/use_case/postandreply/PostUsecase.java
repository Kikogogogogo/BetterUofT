package use_case.postandreply;

import Data.PostRepo;
import Entity.Post;

import java.util.List;

public class PostUsecase {
    private final PostRepo postRepo;
    private int lastId;
    public PostUsecase(PostRepo postRepo) {
        this.postRepo = postRepo;
        this.lastId = determineLastId();
    }

    private int determineLastId() {
        List<Post> allPosts = postRepo.getAllPosts();
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
        postRepo.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepo.getAllPosts();
    }
}
