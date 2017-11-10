package modeling.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author maruf
 * @since 10/29/17
 */
@Setter
@Getter
public class Comment extends TextContribution {
    public static final long serialVersionId = 100014L;
    private Idea commentOn;
    private Set<Comment> replies;
    private Comment replyOn;

    @Builder
    public Comment(User user, Set<Vote> votes, String text, Idea commentOn, Set<Comment> replies, Comment replyOn) {
        super(user, commentOn.getKey() + "-comment-" + commentOn.getComments().size() + "-" + Math.random(), votes, text);
        this.commentOn = commentOn;
        this.replies = replies;
        this.replyOn = replyOn;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentOn=" + commentOn +
                ", replyOn=" + replyOn +
                ", key=" + getKey() +
                ", text=" + getText() +
                '}';
    }
}
