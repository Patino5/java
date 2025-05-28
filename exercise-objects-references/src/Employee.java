public class Employee {
    private String name;
    private static int totalEmployees = 0;

    public Employee(String name){
        totalEmployees++;
    }

    public static void totalEmployeeCount(){
        System.out.println("Total Employees: " + totalEmployees);
    }

}
