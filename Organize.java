import javax.swing.JOptionPane;
import java.util.HashMap;

public class Organize {

static HashMap<String, Account> accounts = new HashMap<String, Account>();

    void accountCreation() {

        String createUser = JOptionPane.showInputDialog("Create new username: ");
        int createPassword = Integer.parseInt(JOptionPane.showInputDialog("Create new password: "));
        double balance = Double.parseDouble(JOptionPane.showInputDialog("Enter your starting balance: "));

        Account account = new Account(createUser, createPassword, balance);

        accounts.put(createUser, account);

        JOptionPane.showMessageDialog(null, "Account created successfully!");

    }

    void accountAccess() {

        String username = JOptionPane.showInputDialog("Enter your username: ");
        int password = Integer.parseInt(JOptionPane.showInputDialog("Enter your password: "));
        
        Account account = accounts.get(username);

        if (account != null && account.getPassword() == password) {

            Bank bank = account.getBank();

            JOptionPane.showMessageDialog(null, "Login successful! Your balance is: $" + bank.getBalance());

            int userSelection = Integer.parseInt(JOptionPane.showInputDialog("What would you like to do? \n1. Deposit \n2. Withdraw \n3. Exit"));

            if (userSelection == 1) {

                double depositAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount you would like to deposit: "));

                bank.deposit(depositAmount);

                JOptionPane.showMessageDialog(null, "Deposit successful! Your new balance is: $" + bank.getBalance());
            } 

            else if (userSelection == 2) {

                double withdrawAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount you would like to withdraw: "));

                bank.withdraw(withdrawAmount);

                JOptionPane.showMessageDialog(null, "Withdrawal successful! Your new balance is: $" + bank.getBalance());
            } 

            else if (userSelection == 3) {
                JOptionPane.showMessageDialog(null, "Logging out...");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.");
        }
    }


}

    
