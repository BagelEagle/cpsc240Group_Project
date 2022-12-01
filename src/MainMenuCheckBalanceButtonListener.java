package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * @author James Amador
 * Action Listener class specific to the check balance button on the main menu.
 */
public class MainMenuCheckBalanceButtonListener implements ActionListener {
    private Window window;

    /**
     * Constructor for the check balance button on the menu screen.
     *
     * @param jframeWindow - The window where all the windows are stored, in order to switch between windows.
     */
    public MainMenuCheckBalanceButtonListener(Window jframeWindow) {
        window = jframeWindow;
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
    }
    @Override
    public void actionPerformed(ActionEvent mouseClick) {
        //I commented out the code here since it broke the original functionality of the Button Listener.
        //I kept the code here just in case.
        //JFrame window = new JFrame("Check Balance");
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
        //JLabel label = new JLabel();
        //label.setText("Which account would you like to check the balance of?");
        //window.add(label);
        String message = "This button would take the user to a window where the user can check their balances for their accounts.";
        JOptionPane.showMessageDialog(null, message);

        window.hideMenu();
        window.displayCheckBalance();
    }
}
