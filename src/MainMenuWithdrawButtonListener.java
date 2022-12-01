package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author James Amador
 * ActionListener class specific to the 'make a deposit' button on the main menu.
 */
public class MainMenuWithdrawButtonListener implements ActionListener{
    private Window window;
    /**
     * Constructor for the 'make a withdrawal' button on the menu screen.
     * @param jframeWindow - The window where all the windows are stored, in order to switch between windows.
     */
    public MainMenuWithdrawButtonListener(Window jframeWindow){
        this.window = jframeWindow;
    }

    @Override
    public void actionPerformed(ActionEvent mouseClick){
        String message = "This button would take the user to a window where the user has the option to make a withdrawal. \n" +
                "That window has not been initialized yet, so ths button just displays this message.";
        JOptionPane.showMessageDialog(null, message);
        //this.window.displayWithdraw();
    }
}
