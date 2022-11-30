package src;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author James Amador
 * Action Listener class specific to the new user button on the login window.
 * Has one attribute: the name of the button
 */
public class NewUserButtonListener implements ActionListener{
    public NewUserButtonListener(){
    }

    /**
     *
     * @param mouseClick the event to be processed. This parameter can be called anything, and is not really used when coding, except
     *                   the actionPerformed method requires there be a parameter listed here.
     */
    @Override
    public void actionPerformed(ActionEvent mouseClick){
        //Placeholder action. What should happen here is hide the login window and display a new user window.
        JOptionPane.showMessageDialog(null, "Button pushed!");
    }
}
