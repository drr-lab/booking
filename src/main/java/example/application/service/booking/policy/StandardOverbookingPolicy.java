package example.application.service.booking.policy;

import example.domain.model.booking.Cargo;
import example.domain.model.booking.Voyage;
import org.springframework.stereotype.Component;

/**
 * 基本のオーバーブッキングポリシー
 */
@Component
public class StandardOverbookingPolicy implements OverbookingPolicy {
    @Override
    public boolean isAllowed(Cargo cargo, Voyage voyage) {
        double maxBooking = voyage.capacity() * 1.1;
        return voyage.bookedSize() + cargo.size() > maxBooking;
    }
}
