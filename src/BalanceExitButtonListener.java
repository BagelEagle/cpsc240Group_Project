package src;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author James Amador
 * Action Listener class that backs out of check account balance window
 */
public class BalanceExitButtonListener implements ActionListener{
    private Window window;

    public BalanceExitButtonListener(Window jframeWindow){
        window = jframeWindow;
    }

    /**
     * Exits the check balance screen and returns the user to the main menu
     * @param mouseClick the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent mouseClick){
        window.hideCheckBalance();
        window.displayMenu();
    }
}
