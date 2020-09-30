package example.application.service.booking;

import example.application.service.booking.policy.OverbookingPolicy;
import example.domain.model.booking.BookingNumber;
import example.domain.model.booking.Cargo;
import example.domain.model.booking.Voyage;
import org.springframework.stereotype.Service;

/**
 * 予約
 */
@Service
public class BookingService {

    private final OverbookingPolicy overbookingPolicy;

    public BookingService(OverbookingPolicy overbookingPolicy) {
        this.overbookingPolicy = overbookingPolicy;
    }

    /**
     * 限度を超えていなかったら予約して予約番号を返す
     * @param voyage
     * @param cargo
     * @return
     */
    BookingNumber booking(Voyage voyage, Cargo cargo) {

        if (overbookingPolicy.isAllowed(cargo, voyage))
            throw new IllegalStateException("最大積載量オーバー");

        return BookingNumber.generate();
    }
}
