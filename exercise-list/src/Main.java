import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        students.add("Ryan");
        students.add("Bob");
        students.add("Billy");
        students.add("Jay");
        students.add("Ray");

        // part 3. print third student in list.
        System.out.println(students.get(2));

        // part 4. Remove Element - second from list
        students.remove(1);
        System.out.println(students);
    }
}
