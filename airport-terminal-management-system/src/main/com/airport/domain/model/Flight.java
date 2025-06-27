package airport.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class Flight {
    private String flightNumber;
    private Date departureDate;
    private BigDecimal ticketPrice;
    private Aircraft aircraftType; // commercial or private

    public Flight(String flightNumber, Date departureDate, BigDecimal ticketPrice, Aircraft aircraftType) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.ticketPrice = ticketPrice;
        this.aircraftType = aircraftType;
    }

    public Flight(){}

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Aircraft getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(Aircraft aircraftType) {
        this.aircraftType = aircraftType;
    }
}
