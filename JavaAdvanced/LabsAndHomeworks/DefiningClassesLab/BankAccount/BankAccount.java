package DefiningClassesLab.BankAccount;
public class BankAccount {
    private static int idCounter = 1;
    private static double interestRate = 0.02;
    private int id;
    private double balance;
    public BankAccount() {
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
