package modeling.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author maruf
 * @since 10/29/17
 */
@Setter
@Getter
public class Idea extends TextContribution {
    private java.util.Set<Comment> comments;
    private String title;

    public Idea(User user, String key, Set<Vote> votes, String text, Set<Comment> comments, String title) {
        super(user, key, votes, text);
        this.comments = comments;
        this.title = title;
    }
}
