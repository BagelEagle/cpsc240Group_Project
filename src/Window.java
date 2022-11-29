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
     * Creates a text label. This can be put anywhere on the screen, such as
     * above a text box
     * @param frame The name of the window where the label to be added
     * @param text The text that will be the label
     */
    public static void addLabel(JFrame frame, String text){
        JLabel label = new JLabel(text);
        frame.getContentPane().add(label);
    }

    /**
     * Creates a Login window for users to input their
     * login and password. Note that this method is only
     * called in the constructor of the Window class.
     */
    public void initializeLoginWindow(){
        //Creates the window
        this.login = new JFrame("Login Page");
        //Exits the program upon closing the window
        this.login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Make a box layout
        this.login.getContentPane().setLayout(new BoxLayout(login.getContentPane(), BoxLayout.Y_AXIS));
        //Adds the login fields and button
        addLoginField();
        //pack
        this.login.pack();
    }

    /**
     * Creates a login button for the login screen
     * @param text Name of the button
     * @param log Login text field
     * @param pass Password text field. Note that while the Type is listed as a JTextField,
     *             it is actually a JPasswordField.
     */
    public void addLoginButton(String text, JTextField log, JTextField pass) {
        JButton button = new JButton(text);
        button.addActionListener(new LoginButtonListener(log, pass));
        this.login.getContentPane().add(button);
    }

    /**
     * Creates a login field for users to input username and password.
     * Also creates a login button. Button is currently nonfunctional.
     */
    public void addLoginField(){
        JTextField loginField = new JTextField(40);
        JTextField passwordField = new JPasswordField(40);
        loginField.addActionListener(new TextListener());
        passwordField.addActionListener(new TextListener());
        addLabel(this.login, "Username:");
        this.login.getContentPane().add(loginField);
        addLabel(this.login, "Password:");
        this.login.getContentPane().add(passwordField);
        //nonfunctional button. LoginButtonListener should be edited to compare
        //what the user typed vs. the password stored in the corresponding username field's file.
        addLoginButton("Placeholder text", loginField, passwordField);
    }

    /**
     * Displays the login window
     */
    public void displayLogin() {
        login.setVisible(true);
    }

    /**
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
