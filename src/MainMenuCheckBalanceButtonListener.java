package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author James Amador
 * Action Listener class specific to the check balance button on the main menu.
 */
public class MainMenuCheckBalanceButtonListener implements ActionListener {
    private Window window;
    /**
     * Constructor for the check balance button on the menu screen.
     * @param jframeWindow - The window where all the windows are stored, in order to switch between windows.
     */
    public MainMenuCheckBalanceButtonListener(Window jframeWindow){
        this.window = jframeWindow;
    }

    @Override
    public void actionPerformed(ActionEvent mouseClick){
        JOptionPane.showMessageDialog(null, "Placeholder message. Display balance here.");
    }
}
