import javax.swing.JOptionPane;

public class Main{


    public static void main(String[] args) {

        Organize organize = new Organize();

        String exitLoop = "";

        while(!"exit".equals(exitLoop)){
            
            
            String menuSelection = JOptionPane.showInputDialog(null, "What would you like to do? \n1. Create new account \n2. Log in to existing account \n3. Exit");
            
            if ("1".equals(menuSelection)) {

                organize.accountCreation();      
            } 
            else if ("2".equals(menuSelection)) {
       
                    organize.accountAccess();   
            }
            else if ("3".equals(menuSelection)) {
                exitLoop = "exit";
            }
        }
    }
}
