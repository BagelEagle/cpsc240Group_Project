package src;

import javax.swing.*;
import java.awt.event.*;

public class WelcomeLoginButtonListener implements ActionListener{
    private Window window;
    public WelcomeLoginButtonListener(Window jframeWindow){
        this.window = jframeWindow;
    }

    @Override
    public void actionPerformed(ActionEvent mouseClick){
        String message = "This method takes the user to the login screen. The screens are initialized, but not shown until\n" +
                " the appropriate button has been pushed. Each actionListner will either display a pop up window, or toggle \n" +
                "the visibility of screens to simulate a transition. Sometimes both occur.";
        JOptionPane.showMessageDialog(null, message);
        this.window.hideWelcome();
        this.window.displayLogin();
    }
}
