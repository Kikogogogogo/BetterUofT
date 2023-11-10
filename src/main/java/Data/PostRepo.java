package Data;
import Entity.Post;

import java.util.List;
import java.util.List;

public interface PostRepo {
    void save(Post post);
    List<Post> getAllPosts();
}
