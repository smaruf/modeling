package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author maruf
 * @since 10/29/17
 */
@Setter
@Getter
@Builder
public class User {
    private Set<Contribution> contribution;
    private java.util.Set<Contribution> contributions;
    private String key;
}
