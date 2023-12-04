package Data.PostandReply;
import Entity.Post;

import java.util.List;

public interface PostRepoAccess {
    void save(Post post);
    List<Post> getAllPosts();
}
