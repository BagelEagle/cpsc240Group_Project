package src;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author James Amador
 * Action Listener class that backs out of create account window and erases any information
 * typed onto the fields
 */
public class ExitCreateAccountButtonListener implements ActionListener {
    private Window window;
    private JTextField username;
    private JTextField password;
    private JTextField confirmedPassword;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField checkingAmt;
    private JTextField savingsAmt;
    /**
     * Constructor for the exit button on the create new user window.
     * @param jframeWindow - The window where all the windows are stored, in order to switch between windows.
     * @param uname - The text box where the user types the username
     * @param pass - The text box where the user types the password
     * @param confPass - The text box where the user retypes the password for confirmation
     * @param fname - The text box where the user types in their first name
     * @param lname - The text box where the user types in their last name
     * @param checkingAmt - The text box where the user types in the initial amount in checking
     * @param savingsAmt - The text box where the user types in the initial amount in savings
     */
    public ExitCreateAccountButtonListener(Window jframeWindow, JTextField uname, JTextField pass, JTextField confPass,
                                           JTextField fname, JTextField lname, JTextField checkingAmt,
                                           JTextField savingsAmt){
        this.window = jframeWindow;
        this.username = uname;
        this.password = pass;
        this.confirmedPassword = confPass;
        this.firstName = fname;
        this.lastName = lname;
        this.checkingAmt = checkingAmt;
        this.savingsAmt = savingsAmt;
    }
    public void actionPerformed(ActionEvent mouseClick){
        this.username.setText("");
        this.password.setText("");
        this.confirmedPassword.setText("");
        this.firstName.setText("");
        this.lastName.setText("");
        this.checkingAmt.setText("");
        this.savingsAmt.setText("");
        this.window.hideNewUser();
        this.window.displayWelcome();
    }
}
