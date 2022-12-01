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

    /**
     * Constructor for the registration button. Neads the Window object to switch between windows. Stores
     * information from each text field for comparison, information collection, and storage.
     * @param jframeWindow The main Window class where all the screens live
     * @param uname The text box where the user types the username
     * @param pass The text box where the user types the password
     * @param confPass The text box where the user retypes the password for confirmation
     */
    public RegistrationButtonListener(Window jframeWindow, JTextField uname, JTextField pass, JTextField confPass){
        window = jframeWindow;
        username = uname;
        password = pass;
        confirmedPassword = confPass;
    }

    /**
     * Action listener listens for a mouse click. Reacts to information typed in the text boxes, once clicked.
     * @param mouseClick the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent mouseClick){
        JOptionPane.showMessageDialog(null, "Welcome!");
        window.hideNewUser();
        window.displayMenu();
    }
}
