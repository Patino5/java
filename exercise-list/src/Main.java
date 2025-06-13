import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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

        // part 5. check the size
        System.out.println(students.size());

        // part 6. check if list is empty
        System.out.println(students.isEmpty());

        // part 7. sort the list alphabetically
        Collections.sort(students); // or can use students.sort(String::compareTo);
        System.out.println("Sorted list: " + students);

        // Bonus Challenge - add another list of students and merge with first. sort the combined
        // list and print it out.

        ArrayList<String> students2 = new ArrayList<>();

        students2.add("Zach");
        students2.add("Noah");
        students2.add("Nick");
        students2.add("Alex");
        students2.add("Scott");

        students.addAll(students2);
        students.sort(String::compareTo);

        for (String student : students) {
            System.out.println(student);
        }

    }
}
