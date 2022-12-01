package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import static src.Main.mainUser;

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
        JFrame window = new JFrame("Check Balance");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));


    }

    @Override
    public void actionPerformed(ActionEvent mouseClick) {
        JFrame window = new JFrame("Check Balance");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));

        JLabel label = new JLabel();
        label.setText("Which account would you like to check the balance of?");
        window.add(label);
    }
}
