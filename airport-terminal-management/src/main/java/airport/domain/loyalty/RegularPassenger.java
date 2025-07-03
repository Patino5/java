package airport.domain.loyalty;

import java.math.BigDecimal;

public class RegularPassenger implements LoyaltyProgram {

    public BigDecimal applyDiscount(BigDecimal ticketPrice) {
        return ticketPrice;
    }
}
