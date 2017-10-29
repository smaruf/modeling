package model;

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
    private TextContribution contribution;

    @Builder
    public Vote(User user, String key, TextContribution contribution) {
        super(user, key);
        this.contribution = contribution;
    }
}
