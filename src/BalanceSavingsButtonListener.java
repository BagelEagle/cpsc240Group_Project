package src;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class BalanceSavingsButtonListener implements ActionListener{
    private Window window;
    public BalanceSavingsButtonListener(Window jframeWindow){
        window = jframeWindow;
    }

    /**
     * Displays the amount of money in the savings account in a popup window.
     * @param mouseClick the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent mouseClick){
        JOptionPane.showMessageDialog(null, "The balance in your Savings Account is: ");
    }
}
