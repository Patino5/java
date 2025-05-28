//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double loanAmount = 25_000.00; // in dollars
        double annualIntrestRate = 5.5; // as a percentage
        int loanTermYears = 5;
        double monthlyPayments;

        // calculate monthly payments
        monthlyPayments = (loanAmount * (annualIntrestRate/100) / 12);

        // assignment operators
        loanAmount += 5000;
        annualIntrestRate -= 1;
        loanTermYears ++;

        // comparison operators
        System.out.println(loanAmount > 30_000);
        System.out.println(monthlyPayments > 500);

        // logical operators
        boolean affordable = (monthlyPayments < 500 && loanTermYears > 3);
        boolean expensive = (monthlyPayments > 700 || annualIntrestRate > 6);


        System.out.println("Loan amount: " + loanAmount);
        System.out.println("Annual Interest Rate: " + annualIntrestRate);
        System.out.println("Loan Terms in Years: " + loanTermYears);
        System.out.println("Monthly Payments: " + monthlyPayments);
        System.out.println("Affordable: " + affordable);
        System.out.println("Expensive: " + expensive);

    }
}