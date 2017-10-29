package model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author maruf
 * @since 10/29/17
 */
@Setter
@Getter
public abstract class Contribution {
    private User user;
    private String key;

    public Contribution(User user, String key) {
        this.user = user;
        this.key = key;
    }
}
