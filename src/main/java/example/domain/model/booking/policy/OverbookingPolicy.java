package example.domain.model.booking.policy;

import example.domain.model.booking.Cargo;
import example.domain.model.booking.Voyage;

/**
 * オーバーブッキングポリシー
 */
public interface OverbookingPolicy {
    boolean isAllowed(Cargo cargo, Voyage voyage);
}
