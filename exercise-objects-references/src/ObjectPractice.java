public class ObjectPractice {
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

        // Part 3 Bank Account
        BankAccount acct1 = new BankAccount("Ryan", 5000);
        BankAccount acct2 = acct1; // any changes to acct2 will affect acct1 as well

        acct2.deposit(500);

        acct1.getAcctInfo();
        acct2.getAcctInfo();

        // Part 4 Using static  Members
        Employee employee1 = new Employee("Ryan");
        Employee employee2 = new Employee("Bill");
        Employee employee3 = new Employee("Bob");

        // needed to make totalEmployeeCount() method a static member to access the Employee class
        Employee.totalEmployeeCount();


    }
}