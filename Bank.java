public class Bank {

    double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        balance = balance + amount;
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    double getBalance() {
        return balance;
    }
}
