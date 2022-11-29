package src;

import javax.swing.*;

public class Window {
    private JFrame login;
    private JFrame newUser;
    private JFrame menu;
    private JFrame deposit;
    private JFrame withdraw;
    private JFrame transfer;
    private JFrame requestLoan;
    private JFrame checkBalance;
    public Window(){
        initializeLoginWindow();
    }

    /**
     * @author James Amador
     * Creates a Login window for users to input their
     * login and password. Note that this method is only
     * called in the constructor of the Window class.
     */
    public void initializeLoginWindow(){
        login = new JFrame("Login Page");
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.getContentPane().setLayout(new BoxLayout(login.getContentPane(), BoxLayout.Y_AXIS));
        //function that adds login field.
        //NOTE: I'm going to move the function from main into this class
        //login.pack();
    }

    /**
     * @author James Amador
     * Displays the login window
     */
    public void displayLogin() {
        login.setVisible(true);
    }

    /**
     * @author James Amador
     * Hides the login window
     */
    public void hideLogin(){
        login.setVisible(false);
    }
    public JFrame getNewUser(){ return newUser; }

    public JFrame getMenu () {
        return menu;
    }

    public JFrame getDeposit () {
        return deposit;
    }

    public JFrame getWithdraw () {
        return withdraw;
    }

    public JFrame getTransfer () {
        return transfer;
    }

    public JFrame getRequestLoan () {
        return requestLoan;
    }

    public JFrame getCheckBalance () {
        return checkBalance;
    }
}
