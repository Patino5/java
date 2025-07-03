package airport.view;

import airport.domain.model.Flight;

public class View {
    private final TextIO io;

    public View(TextIO io) {
        this.io = io;
    }

    public int displayMenu() {
        io.println("_".repeat(32));
        io.println("\\\\\\ Airport Terminal Manager ///");
        io.println("-".repeat(32));
        io.println("1. Display Flights");
        io.println("2. Add Reservation");
        io.println("3. Exit");
        return io.readInt("Choose 1 - 3: ", 1, 3);
    }

    public void displayFlightTable() {
        io.println("-".repeat(77));
        io.println("| Flight | Departure Date | Ticket Price |  Aircraft Model | Seats Available |");
        io.println("---------+----------------+--------------+-----------------+-----------------");
    }

    public void displayFlightRow(int index, Flight flight, int seatsAvailable) {
        io.printf("%d. %-5s |   %-12s |  $%10s | %-15.15s | %6d%n",
                index,
                flight.getFlightNumber(),
                flight.getDepartureDate(),
                flight.getTicketPrice(),
                flight.getAircraft().getModel(),
                seatsAvailable);
    }

    public int getFlightChoice(int maxFlights) {
        return io.readInt("Select a flight: ", 1, maxFlights);
    }

    public String getPassengerName() {
        return io.readString("Passenger Name: ");
    }

    public String getPassengerPassport() {
        return io.readString("Passport Number: ");
    }

    public void displayConfirmation(String passengerName, String flightNumber) {
        io.printf("Passenger: %s added to flight %s%n", passengerName, flightNumber);
    }

    public void displayFlightDetails(String flightNumber, int seatsAvailable, int totalSeats, String passengers) {
        String header = String.format("Flight %s | Seats Available: %d/%d",
                flightNumber, seatsAvailable, totalSeats);
        io.println("");
        io.println(header);
        io.println("-".repeat(header.length()));
        io.println("Passengers: ");
        io.println(passengers);
        io.println("-".repeat(header.length()));
    }
}
