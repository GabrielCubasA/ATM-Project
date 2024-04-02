
import javax.swing.JOptionPane;
import java.util.HashMap;

public class Main {

    // Creating a HashMap to store Account objects with their associated usernames
    static HashMap<String, Account> accounts = new HashMap<String, Account>();

    public static void main(String[] args) {

        // Initializing a control variable for the main loop
        String exitLoop = "";

        // Main loop which continues until the user inputs "exit"
        while(!"exit".equals(exitLoop)){
            
            // Asking the user what they would like to do
            String menuSelection = JOptionPane.showInputDialog(null, "What would you like to do? \n1. Create new account \n2. Log in to existing account \n3. Exit");
            
            // If the user wants to create a new account
            if ("1".equals(menuSelection)) {
                
                // Asking the user for their new username, password, and initial balance
                String createUser = JOptionPane.showInputDialog("Create new username: ");
                int createPassword = Integer.parseInt(JOptionPane.showInputDialog("Create new password: "));
                double balance = Double.parseDouble(JOptionPane.showInputDialog("Enter your starting balance: "));

                // Creating a new Account object with the provided details
                Account account = new Account(createUser, createPassword, balance);

                // Storing the new Account object in the HashMap
                accounts.put(createUser, account);

                // Informing the user that the account was created successfully
                JOptionPane.showMessageDialog(null, "Account created successfully!");
            } 

            // If the user wants to log in to an existing account
            else if ("2".equals(menuSelection)) {

                // Asking the user for their username and password
                String username = JOptionPane.showInputDialog("Enter your username: ");
                int password = Integer.parseInt(JOptionPane.showInputDialog("Enter your password: "));
                
                // Retrieving the Account object associated with the provided username
                Account account = accounts.get(username);

                // If the account exists and the provided password is correct
                if (account != null && account.getPassword() == password) {

                    // Getting the Bank object associated with the account
                    Bank bank = account.getBank();

                    // Informing the user that the login was successful and displaying their current balance
                    JOptionPane.showMessageDialog(null, "Login successful! Your balance is: $" + bank.getBalance());

                    // Asking the user what they would like to do next
                    int userSelection = Integer.parseInt(JOptionPane.showInputDialog("What would you like to do? \n1. Deposit \n2. Withdraw \n3. Exit"));

                    // If the user wants to deposit money
                    if (userSelection == 1) {

                        // Asking the user how much they would like to deposit
                        double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount you would like to deposit: "));

                        // Depositing the specified amount
                        bank.deposit(depositAmount);

                        // Informing the user that the deposit was successful and displaying their new balance
                        JOptionPane.showMessageDialog(null, "Deposit successful! Your new balance is: $" + bank.getBalance());
                    } 

                    // If the user wants to withdraw money
                    else if (userSelection == 2) {

                        // Asking the user how much they would like to withdraw
                        double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount you would like to withdraw: "));

                        // Withdrawing the specified amount
                        bank.withdraw(withdrawAmount);

                        // Informing the user that the withdrawal was successful and displaying their new balance
                        JOptionPane.showMessageDialog(null, "Withdrawal successful! Your new balance is: $" + bank.getBalance());
                    } 

                    // If the user wants to log out
                    else if (userSelection == 3) {
                        JOptionPane.showMessageDialog(null, "Logging out...");
                    }

                } else {
                    // If the account does not exist or the provided password is incorrect, informing the user that the login failed
                    JOptionPane.showMessageDialog(null, "Invalid username or password.");
                }
            }

            // If the user wants to exit the program
            else if ("3".equals(menuSelection)) {
                exitLoop = "exit";
            }
        }
    }
}
