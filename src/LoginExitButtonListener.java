package src;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author James Amador
 * Action Listener class that backs out of the login window and erases any information
 * typed into the text boxess
 */
public class LoginExitButtonListener implements ActionListener{
    private Window window;
    private JTextField login;
    private JTextField password;
    public LoginExitButtonListener(Window jframeWindow, JTextField login, JTextField pass){
        this.window = jframeWindow;
        this.login = login;
        this.password = pass;
    }

    /**
     * Clears the information that may or may not have been typed into the text fields
     * before switching back to the welcome screen
     * @param mouseClick the event to be processed
     */
    public void actionPerformed(ActionEvent mouseClick){
        login.setText("");
        password.setText("");
        window.hideLogin();
        window.displayWelcome();
    }

}
