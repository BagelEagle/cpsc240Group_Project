package src;

import javax.swing.*;
import java.awt.event.ActionListener;

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
        initializeNewUserWindow();
        //initialize each window here as a method.
        //Display login will always be last, since it
        //is the first window that is displayed upon creation of
        // "Window" class.
        displayLogin();
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
        this.login = new JFrame("Login");
        //Exits the program upon closing the window
        this.login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Make a box layout
        this.login.getContentPane().setLayout(new BoxLayout(login.getContentPane(), BoxLayout.Y_AXIS));
        //Adds the login fields and button
        addLoginField();
        addNewUserButton();
        //pack
        this.login.pack();
    }

    /**
     * Creates a login button for the login screen
     * @param log Login text field
     * @param pass Password text field. Note that while the Type is listed as a JTextField,
     *             it is actually a JPasswordField.
     */
    public void addLoginButton(JTextField log, JTextField pass) {
        JButton button = new JButton("Login");
        button.addActionListener(new LoginButtonListener(log, pass));
        this.login.getContentPane().add(button);
    }

    /**
     * Creates a button for new users to register an account
     */
    public void addNewUserButton(){
        JButton button = new JButton("Register");
        button.addActionListener(new NewUserButtonListener(this));
        //button.setPreferredSize(new Dimension(120,40));
        this.login.getContentPane().add(button);
    }

    /**
     * Creates a login field for users to input username and password.
     * Also creates a login button. Button is currently nonfunctional.
     */
    public void addLoginField(){
        JTextField loginField = new JTextField(40);
        JTextField passwordField = new JPasswordField(40);
        loginField.addActionListener(new LoginTextListener());
        passwordField.addActionListener(new LoginTextListener());
        addLabel(this.login, "Username:");
        this.login.getContentPane().add(loginField);
        addLabel(this.login, "Password:");
        this.login.getContentPane().add(passwordField);
        //nonfunctional button. LoginButtonListener should be edited to compare
        //what the user typed vs. the password stored in the corresponding username field's file.
        addLoginButton(loginField, passwordField);
    }

    /**
     * Getter method that returns the login JFrame window
     * @return login window
     */
    public JFrame getLogin(){
        return login; }
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

    /**
     * Initializes the registration window for new users, but does not display the window.
     */
    public void initializeNewUserWindow(){
        //Creates the window with the name "Register New User"
        this.newUser = new JFrame("Register New User");
        //Exits the program upon closing the window
        this.newUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Make a box layout
        this.newUser.getContentPane().setLayout(new BoxLayout(this.newUser.getContentPane(), BoxLayout.Y_AXIS));
        //Adds the registration fields and button
        addRegistrationFields();
        //pack
        this.newUser.pack();
    }

    /**
     * Creates a button that registers the user if no other users share the user-specified username.
     * Only creates an account if the password typed in confPass matches what is in pass.
     * @param log The user's selected login name. Button will listen for this text box.
     * @param pass The user's selected password. Button will listen for this text box.
     * @param confPass The user's password retyped. Button will listen for this text box.
     */
    public void addRegisterButton(JTextField log, JTextField pass, JTextField confPass) {
        JButton button = new JButton("Register");
        button.addActionListener(new RegistrationButtonListener(this, log, pass, confPass));
        this.newUser.getContentPane().add(button);
    }

    /**
     * Adds in Textfields to collect information from the user.
     */
    //NOTE: More fields should be added to reflect the user class
    public void addRegistrationFields(){
        JTextField loginField = new JTextField(40);
        JTextField passwordField = new JPasswordField(40);
        JTextField confirmPasswordField = new JPasswordField(40);
        addLabel(this.newUser, "Username:");
        this.newUser.getContentPane().add(loginField);
        addLabel(this.newUser, "Password:");
        this.newUser.getContentPane().add(passwordField);
        addLabel(this.newUser, "Confirm password:");
        this.newUser.getContentPane().add(confirmPasswordField);
        addRegisterButton(loginField, passwordField, confirmPasswordField);
    }

    /**
     * Getter method that returns the registration JFrame window for new users
     * @return new user window
     */
    public JFrame getNewUser(){
        return newUser;
    }

    /**
     * Displays the new user window
     */
    public void displayNewUser(){
        newUser.setVisible(true);
    }

    /**
     * Hides the new user window
     */
    public void hideNewUser(){
        newUser.setVisible(false);
    }
    /**
     * Initializes the main menu of the program.
     * This is the main hub for new and existing users.
     */
    public void initializeMenuWindow(){

    }
    /**
     * Adds a check balance menu button. Currently, it is set up to display the balance in a pop up window.
     */
    public void addCheckBalanceMenuButton(){
        JButton button = new JButton("Check Account Balance");
        button.addActionListener(new CheckBalanceButtonListener(this));
        this.menu.getContentPane().add(button);
    }
    /**
     * Getter method that returns the main menu JFrame for the user that logged in
     * @return main menu window
     */
    public JFrame getMenu () {
        return menu;
    }

    /**
     * Getter method that returns the JFrame of the deposit window
     * @return make a deposit window
     */
    public JFrame getDeposit () {
        return deposit;
    }

    /**
     * Getter method that returns the JFrame of the withdrawal window
     * @return make a withdrawal window
     */
    public JFrame getWithdraw () {
        return withdraw;
    }

    /**
     * Getter method that returns the JFrame of the transfer funds window
     * @return make funds transfer window
     */
    public JFrame getTransfer () {
        return transfer;
    }

    /**
     * Getter method that returns the JFrame of the request a loan window
     * @return request a loan window
     */
    public JFrame getRequestLoan () {
        return requestLoan;
    }

    /**
     * Getter method that returns the JFrame of the check balance window
     * @return check balance window
     */
    public JFrame getCheckBalance () {
        return checkBalance;
    }
}
