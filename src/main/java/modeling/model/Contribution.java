package modeling.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author maruf
 * @since 10/29/17
 */
@Setter
@Getter
public abstract class Contribution implements Serializable {
    private User user;
    private String key;

    public Contribution(User user, String key) {
        this.user = user;
        this.key = key;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Contribution)) return false;
        if (!super.equals(object)) return false;

        Contribution that = (Contribution) object;

        if (!key.equals(that.key)) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + key.hashCode();
        return result;
    }
}
