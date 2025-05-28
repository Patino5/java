public class ObjectPratice {
    public static void main(String[] args) {
        // Part one Car Dealership System
        Car car1 = new Car("Toyota", "Corolla", 2020);
        Car car2 = new Car("Ford","Mustang", 2022);

        car1.displayInfo();
        car2.displayInfo();

        // Part 2 Book Libray System
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", true);
        Book book2 = new Book("Cloudy with a Chance of Meatballs", "Judi Barrett", true);

        book1.isCheckedOut();
        book2.isCheckedOut();

        book1.borrowBook();
        book2.borrowBook();

        book1.isCheckedOut();
        book2.isCheckedOut();

    }
}