//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Coffee Order System
    enum CoffeeSize {
        SMALL,
        MEDIUM,
        LARGE
    }
    public static void main(String[] args) {

        CoffeeSize order = CoffeeSize.SMALL;

        System.out.println(" Selected coffee size: " + order);

    }
}