package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author James Amador
 * Action Listener class specific to the 'Logout' button on the main menu.
 */
public class MainMenuLogoutButtonListener implements ActionListener{
    private Window window;
    /**
     * Constructor for the 'Logout' button on the menu screen.
     * @param jframeWindow - The window where all the windows are stored, in order to switch between windows.
     */
    public MainMenuLogoutButtonListener(Window jframeWindow){
        this.window = jframeWindow;
    }

    @Override
    public void actionPerformed(ActionEvent mouseClick){
        JOptionPane.showMessageDialog(null, "Signing out.");
        this.window.clearUser();
        this.window.hideMenu();
        this.window.displayLogin();
    }
}
