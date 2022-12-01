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
        String message = "Suppose the user no longer wished to login. If they typed something in the text fields, ideally " +
                "those fields should be made blank. That is what this actionPerformed method does. If you try to login again, " +
                "you'll see that what you typed isn't kept. That's a good security practice!";
        login.setText("");
        password.setText("");
        window.hideLogin();
        window.displayWelcome();
    }

}
