package modeling.model;

/**
 * @author maruf
 * @since 10/29/17
 */
public class Comment extends TextContribution {
    private Idea commentOn;
    private Set<Comment> replies;
    private Comment replyOn;
}
