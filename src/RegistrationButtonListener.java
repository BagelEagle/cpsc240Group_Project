package src;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author James Amador
 * Button Listener for the registration window. Looks at the text fields within the window and determines
 * whether the information provided was satisfactory for user account creation.
 */
public class RegistrationButtonListener implements ActionListener{
    private Window window;
    private JTextField username;
    private JTextField password;
    private JTextField confirmedPassword;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField checkingAmt;
    private JTextField savingsAmt;

    /**
     * Constructor for the registration button. Neads the Window object to switch between windows. Stores
     * information from each text field for comparison, information collection, and storage.
     * @param jframeWindow The main Window class where all the screens live
     * @param uname The text box where the user types the username
     * @param pass The text box where the user types the password
     * @param confPass The text box where the user retypes the password for confirmation
     * @param fname - The text box where the user types in their first name
     * @param lname - The text box where the user types in their last name
     * @param checkingAmt - The text box where the user types in the initial amount in checking
     * @param savingsAmt - The text box where the user types in the initial amount in savings
     */
    public RegistrationButtonListener(Window jframeWindow, JTextField uname, JTextField pass, JTextField confPass,
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

    /**
     * Action listener listens for a mouse click. Reacts to information typed in the text boxes, once clicked.
     * If the user has satisfactorily filled in each field, then the information is saved, then each text box is cleared.
     * @param mouseClick the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent mouseClick){
//        if user was successful:
//          popupwindow says success!
//          information is saved first
//          then it is deleted like so
//          this.username.setText("");
//          this.password.setText("");
//          this.confirmedPassword.setText("");
//          this.firstName.setText("");
//          this.lastName.setText("");
//          this.checkingAmt.setText("");
//          this.savingsAmt.setText("");
//          Switch to main menu with user information
//          window.hideNewUser();
//          window.displayMenu();
    }
}
