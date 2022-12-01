package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import static src.Main.mainUser;

/**
 * @author James Amador
 * Action Listener class specific to the 'make a deposit' button on the main menu.
 */
public class MainMenuDepositButtonListener implements ActionListener{
    private Window window;
    /**
     * Constructor for the 'make a deposit' button on the menu screen.
     * @param jframeWindow - The window where all the windows are stored, in order to switch between windows.
     */
    public MainMenuDepositButtonListener(Window jframeWindow){
        this.window = jframeWindow;
    }

    @Override
    public void actionPerformed(ActionEvent mouseClick){
        System.out.println("Which account balance would you like to see?");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.println("3. Money Market");
        System.out.println("4. Certificate Deposit");
        System.out.println("5. All");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if (choice == 1) {
            mainUser.balanceChecking();
        } else if (choice == 2) {
            mainUser.balanceSavings();
        } else if (choice == 3) {
            mainUser.balanceMoneyMarket();
        } else if (choice == 4) {
            mainUser.balanceCertificateDeposit();
        } else if (choice == 5) {
            mainUser.balance();
        } else {
            System.out.println("You did not select a valid account");
            System.out.println("");
        }
        JOptionPane.showMessageDialog(null, "Placeholder message.");
        this.window.displayDeposit();
    }
}
