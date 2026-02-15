public class BankAccount {

    protected String firstName;
    protected String lastName;
    protected int accountID;
    protected double balance;

    // Constructor
    public BankAccount() {
        balance = 0.0;
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
    }

    // Withdrawal method
    public void withdrawal(double amount) {
        balance -= amount;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    // Account summary
    public void accountSummary() {
        System.out.println("Account Holder: " + firstName + " " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: $" + balance);
    }
}
