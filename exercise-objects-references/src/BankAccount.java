import java.awt.image.BandCombineOp;

public class BankAccount {
    private String owner;
    double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount){
        System.out.println("Initial Balance: " + this.balance + " for " + owner);
        balance += amount;
        System.out.println("Depositing " + amount + " to " + owner);
        System.out.println("Updated balance: " + this.balance);
    }

    public void getAcctInfo(){
        System.out.println("Account owner: " + owner + " Balance: " + this.balance);
    }

}
