package PostandReplyTest;

import Data.PostandReply.ReplyRepoAccess;
import Entity.PostandReply.Reply;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ReplyRepoAccessStub implements ReplyRepoAccess {
    private List<Reply> replies = new ArrayList<>();

    @Override
    public List<Reply> getRepliesForPost(String postId) {
        return replies.stream()
                .filter(reply -> reply.getPostId().equals(postId))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Reply reply) {
        replies.add(reply);
    }
}
