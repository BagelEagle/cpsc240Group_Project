package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author James Amador
 * Action Listener class specific to the 'Request a Loan' button on the main menu.
 */
public class MainMenuRequestLoanButtonListener implements ActionListener {
    private Window window;
    /**
     * Constructor for the 'Request a Loan' button on the menu screen.
     * @param jframeWindow - The window where all the windows are stored, in order to switch between windows.
     */
    public MainMenuRequestLoanButtonListener(Window jframeWindow){
        this.window = jframeWindow;
    }

    @Override
    public void actionPerformed(ActionEvent mouseClick){
        String message = "This button would take the user to a window where the user has the option to request a loan. \n" +
                "That window has not been initialized yet, so ths button just displays this message.";
        JOptionPane.showMessageDialog(null, message);
        //this.window.displayRequestLoan();
    }
}
