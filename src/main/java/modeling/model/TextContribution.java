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
    private Set<Vote> votes;
    private String Text;

    public TextContribution(User user, String key, Set<Vote> votes, String text) {
        super(user, key);
        this.votes = votes;
        Text = text;
    }

    @Override
    public String toString() {
        return "TextContribution{" +
                "Text='" + Text + '\'' +
                "key='" + getKey() +
                '}';
    }
}
