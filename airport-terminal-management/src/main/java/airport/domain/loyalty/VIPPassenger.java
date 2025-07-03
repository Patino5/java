package airport.domain.loyalty;

import java.math.BigDecimal;

public class VIPPassenger implements LoyaltyProgram {

    public BigDecimal applyDiscount(BigDecimal ticketPrice) {
        return ticketPrice.subtract(ticketPrice.multiply(BigDecimal.valueOf(.20)));
    }
}
