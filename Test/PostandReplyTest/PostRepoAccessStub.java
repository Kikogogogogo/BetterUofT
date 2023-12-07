package PostandReplyTest;

import Data.PostandReply.PostRepoAccess;
import Entity.PostandReply.Post;

import java.util.ArrayList;
import java.util.List;

class PostRepoAccessStub implements PostRepoAccess {
    private List<Post> posts = new ArrayList<>();

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(posts); // Return a copy of the list to mimic real-world behavior
    }

    @Override
    public void save(Post post) {
        posts.add(post);
    }
}
