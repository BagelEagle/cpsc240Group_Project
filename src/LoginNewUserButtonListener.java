package src;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author James Amador
 * Action Listener class specific to the new user button on the login window.
 */
public class LoginNewUserButtonListener implements ActionListener{
    private Window window;

    /**
     * Constructor for the register new user button on the login screen.
     * @param jframeWindow - The window where all the windows are stored, in order to switch between windows.
     */
    public LoginNewUserButtonListener(Window jframeWindow){
        window = jframeWindow;
    }

    /**
     *
     * @param mouseClick the event to be processed. This parameter can be called anything, and is not really used when coding, except
     *                   the actionPerformed method requires there be a parameter listed here.
     */
    @Override
    public void actionPerformed(ActionEvent mouseClick){
        JOptionPane.showMessageDialog(null, "Placeholder message.");
        this.window.hideLogin();
        this.window.displayNewUser();
    }
}
