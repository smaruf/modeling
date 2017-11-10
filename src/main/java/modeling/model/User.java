package modeling.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

/**
 * @author maruf
 * @since 10/29/17
 */
@Setter
@Getter
@Builder
public class User implements Serializable {
    private Set<Contribution> contribution;
    private java.util.Set<Contribution> contributions;
    private String key;

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User)) return false;
        if (!super.equals(object)) return false;

        User user = (User) object;

        if (contribution != null ? !contribution.equals(user.contribution) : user.contribution != null) return false;
        if (contributions != null ? !contributions.equals(user.contributions) : user.contributions != null)
            return false;
        if (!key.equals(user.key)) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (contribution != null ? contribution.hashCode() : 0);
        result = 31 * result + (contributions != null ? contributions.hashCode() : 0);
        result = 31 * result + key.hashCode();
        return result;
    }
}
