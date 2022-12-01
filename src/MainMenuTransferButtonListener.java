package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author James Amador
 * Action Listener class specific to the 'make a Funds Transfer' button on the main menu.
 */
public class MainMenuTransferButtonListener implements ActionListener {
    private Window window;
    /**
     * Constructor for the 'make a Funds Transfer' button on the menu screen.
     * @param jframeWindow - The window where all the windows are stored, in order to switch between windows.
     */
    public MainMenuTransferButtonListener(Window jframeWindow){
        this.window = jframeWindow;
    }

    @Override
    public void actionPerformed(ActionEvent mouseClick){
        JOptionPane.showMessageDialog(null, "Placeholder message.");
        this.window.displayTransfer();
    }
}
