import java.lang.reflect.Array;
import java.util.concurrent.ForkJoinWorkerThread;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Coffee Order System
    enum CoffeeSize {
        SMALL,
        MEDIUM,
        LARGE
    }

    enum SeatSection {
        GENERAL,
        PREMIUM,
        VIP
    }

    enum TrafficLight {
        RED,
        YELLOW,
        GREEN
    }

    enum Weekday {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    enum AlertLevel {
        LOW,
        MODERATE,
        HIGH,
        SEVERE
    }

    public static void main(String[] args) {

        // Part 1 Coffee Size Order
        CoffeeSize order = CoffeeSize.SMALL;
        System.out.println(" Selected coffee size: " + order);

        // Part 2 Seat Reservations
        System.out.println(SeatSection.GENERAL + " is assigned value: " + SeatSection.GENERAL.ordinal());
        System.out.println(SeatSection.PREMIUM + " is assigned value: " + SeatSection.PREMIUM.ordinal());
        System.out.println(SeatSection.VIP + " is assigned value: " + SeatSection.VIP.ordinal());

        // Part 3 Traffic Light System
        TrafficLight[]  values = TrafficLight.values();
        System.out.println("Traffic light signal: "+ values[1]);

        // Part 4 Weekday Schedule
        Weekday workDay = Weekday.WEDNESDAY;
        System.out.println("Workday selected: " + workDay);
        System.out.println("Is it a weekend? " + (workDay == Weekday.SATURDAY || workDay == Weekday.SUNDAY));

        //Part 5 Emergency Alert System
        AlertLevel currentAlert = AlertLevel.SEVERE;
        System.out.println("Current Alert Level: " + currentAlert);
        switch (currentAlert){
            case LOW:
                System.out.println("No immediate danger.");
                break;
            case MODERATE:
                System.out.println("Stay alert and aware.");
                break;
            case HIGH:
                System.out.println("Take precautions and stay informed");
                break;
            case SEVERE:
                System.out.println("Immediate action required!");
                break;
        }


    }
}