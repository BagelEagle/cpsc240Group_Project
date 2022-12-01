package src;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BalanceMoneyMarketButtonListener implements ActionListener{
    private Window window;
    public BalanceMoneyMarketButtonListener(Window jframeWindow){
        window = jframeWindow;
    }

    /**
     * Displays the amount of money in the Money Market account in a popup window.
     * @param mouseClick the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent mouseClick){
        JOptionPane.showMessageDialog(null, "The balance in your Money Market account is: ");
    }
}
