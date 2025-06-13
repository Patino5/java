import java.util.ArrayList;

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

        for (Box<Integer> boxInteger : listOfBoxIntegers) {
            System.out.println(boxInteger.get());
        }



    }
}
