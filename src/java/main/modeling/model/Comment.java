package model;

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
    private Idea commentOn;
    private Set<Comment> replies;
    private Comment replyOn;

    @Builder
    public Comment(User user, String key, Set<Vote> votes, String text, Idea commentOn, Set<Comment> replies, Comment replyOn) {
        super(user, key, votes, text);
        this.commentOn = commentOn;
        this.replies = replies;
        this.replyOn = replyOn;
    }
}
