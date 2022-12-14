package src;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author James Amador
 * Action Listener class specific to the new user button on the login window.
 */
public class WelcomeCreateAccountButtonListener implements ActionListener{
    private Window window;

    /**
     * Constructor for the register new user button on the login screen.
     * @param jframeWindow - The window where all the windows are stored, in order to switch between windows.
     */
    public WelcomeCreateAccountButtonListener(Window jframeWindow){
        window = jframeWindow;
    }

    /**
     *
     * @param mouseClick the event to be processed. This parameter can be called anything, and is not really used when coding, except
     *                   the actionPerformed method requires there be a parameter listed here.
     */
    @Override
    public void actionPerformed(ActionEvent mouseClick){
        JOptionPane.showMessageDialog(null, "This button takes the user to the create account screen.");
        this.window.hideWelcome();
        this.window.displayNewUser();
    }
}
