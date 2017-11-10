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
public abstract class TextContribution extends Contribution {
    private java.util.Set<Vote> votes;
    private String Text;

    public TextContribution(User user, String key, Set<Vote> votes, String text) {
        super(user, key);
        this.votes = votes;
        Text = text;
    }
}
