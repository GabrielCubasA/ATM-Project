import javax.swing.JOptionPane;
import java.util.HashMap;

public class Organize {

static HashMap<String, Account> accounts = new HashMap<String, Account>();

    void accountCreation() {

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

    
    
}
