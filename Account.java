public class Account {

    String username;
    int password;
    Bank bank;

    public Account(String username, int password, double balance) {
        this.username = username;
        this.password = password;
        this.bank = new Bank(balance);
    }

    public int getPassword() {
        return password;
    }

    public Bank getBank() {
        return bank;
    }
}
