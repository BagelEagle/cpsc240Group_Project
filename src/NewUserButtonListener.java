package src;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author James Amador
 * Action Listener class specific to the new user button on the login window.
 * Has one attribute: the name of the button
 */
public class NewUserButtonListener implements ActionListener{
    private Window window;
    public NewUserButtonListener(Window jframeWindow){
        window = jframeWindow;
    }

    /**
     *
     * @param mouseClick the event to be processed. This parameter can be called anything, and is not really used when coding, except
     *                   the actionPerformed method requires there be a parameter listed here.
     */
    @Override
    public void actionPerformed(ActionEvent mouseClick){
        JOptionPane.showMessageDialog(null, "Placeholder message. This message is located in the method where login window is hidden and the new user window is displayed");
        this.window.hideLogin();
        this.window.displayNewUser();
    }
}
