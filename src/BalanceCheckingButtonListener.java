package src;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class BalanceCheckingButtonListener implements ActionListener{
    private Window window;
    public BalanceCheckingButtonListener(Window jframeWindow){
        window = jframeWindow;
    }

    /**
     * Displays the amount of money in the checking account in a popup window.
     * @param mouseClick the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent mouseClick){
        JOptionPane.showMessageDialog(null, "The balance is: ");
    }
}
