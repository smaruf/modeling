package modeling.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author maruf
 * @since 10/29/17
 */
@Setter
@Getter
public class Vote extends Contribution {
    public static final long serialVersionId = 100015L;
    private TextContribution contribution;

    @Builder
    public Vote(User user, TextContribution contribution) {
        super(user, contribution.getKey() + "-votes-" + Math.random());
        this.contribution = contribution;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "contribution=" + contribution +
                "key=" + getKey() +
                '}';
    }
}
