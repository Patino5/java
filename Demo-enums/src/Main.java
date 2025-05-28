//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // used for a unique val and number.
    enum OrderStatus {
        ORDERED,
        WAREHOUSE,
        SHIPPED,
        DELIVERED,
        RETURNED
    }

    enum TrafficLight {
        RED,
        YELLOW,
        GREEN
    }


    public static void main(String[] args) {
        // order status, 1 ordered, 2 warehouse, 3 shipped, 4 delivered, 5 returned

        OrderStatus status = OrderStatus.WAREHOUSE;
        // print the label
        System.out.println(OrderStatus.DELIVERED);
        // print the number
        System.out.println(OrderStatus.DELIVERED.ordinal());

        // get a collection of all the enum values
        TrafficLight[] light = TrafficLight.values();

        System.out.println(light[0]); // outputs RED


    }
}