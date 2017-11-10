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
    public static final long serialVersionId = 100011L;
    private User user;
    private String key;

    Contribution(User user, String key) {
        this.user = user;
        this.key = key;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Contribution)) return false;
        if (!super.equals(object)) return false;

        Contribution that = (Contribution) object;

        return key.equals(that.key);
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + key.hashCode();
        return result;
    }
}
