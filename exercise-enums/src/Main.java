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
    public static void main(String[] args) {

        CoffeeSize order = CoffeeSize.SMALL;

        System.out.println(" Selected coffee size: " + order);

        System.out.println(SeatSection.GENERAL + " is assigned value: " + SeatSection.GENERAL.ordinal());
        System.out.println(SeatSection.PREMIUM + " is assigned value: " + SeatSection.PREMIUM.ordinal());
        System.out.println(SeatSection.VIP + " is assigned value: " + SeatSection.VIP.ordinal());


    }
}