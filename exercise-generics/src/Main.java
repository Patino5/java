import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Box<Integer> num = new Box<>();
        Box<String> str = new Box<>();

        num.set(42);
        str.set("Java");
        System.out.println("Box of Interger Value: " + num.get() +
                "\nBox of String Value: " + str.get());

        ArrayList<Box<Integer>> listOfBoxIntegers = new ArrayList<>();

        Box<Integer> age = new Box<>();
        age.set(36);
        Box<Integer> num2 = new Box<>();
        num2.set(5);
        Box<Integer> num3 = new Box<>();
        num3.set(23);

        listOfBoxIntegers.add(age);
        listOfBoxIntegers.add(num2);
        listOfBoxIntegers.add(num3);

        for (int i = 0; i < listOfBoxIntegers.size(); i++) {
            System.out.println("Box " + (i + 1) +
                    " contains: " + listOfBoxIntegers.get(i).get());
        }

        // Part 4 Process Items in a Queue
        Queue<Box<String>> line = new LinkedList<>();

        Box<String> order1 = new Box<>();
        order1.set("Placed first order");
        order1.setName("Burger");
        Box<String> order2 = new Box<>();
        order2.set("Placed second order");
        order2.setName("Fries");
        Box<String> order3 = new Box<>();
        order3.set("Placed third order");
        order3.setName("Milkshake");

        line.add(order1);
        line.add(order2);
        line.add(order3);
        int count = 1;

        while (!line.isEmpty()){
            System.out.println("Queue Box " + count +
                    " contains: " + line.peek().getName() +
                    ", " + line.poll().get());
            count++;
        }

    }
}
