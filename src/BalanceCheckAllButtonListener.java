package src;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BalanceCheckAllButtonListener implements ActionListener{
    private Window window;
    public BalanceCheckAllButtonListener(Window jframeWindow){
        window = jframeWindow;
    }

    /**
     * Displays the amount of money in all accounts in a popup window.
     * @param mouseClick the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent mouseClick){
        JOptionPane.showMessageDialog(null, "The balance for each account is: ");
    }
}
