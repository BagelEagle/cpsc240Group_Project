package src;

import javax.swing.*;

/**
 * @author James Amador, April Groce, Kaylie Curran
 * Window GUI that handles all the windows and user information.
 */

public class Window {
    private JFrame login;
    private JFrame newUser;
    private JFrame menu;
    private JFrame deposit;
    private JFrame withdraw;
    private JFrame transfer;
    private JFrame requestLoan;
    private JFrame checkBalance;
    private User user;

    /**
     * Constructor method that initializes every window, but only displays the login window
     */
    public Window(){
        initializeLoginWindow();
        initializeNewUserWindow();
        initializeMenuWindow();
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
        button.addActionListener(new LoginButtonListener(this, log, pass));
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
        this.menu = new JFrame("Main Menu");
        this.menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.menu.getContentPane().setLayout(new BoxLayout(this.menu.getContentPane(), BoxLayout.Y_AXIS));
        //add menu buttons here
        addCheckBalanceMenuButton();
        addDepositMenuButton();
        addWithdrawalMenuButton();
        addTransferMenuButton();
        addLoanMenuButton();
        addLogoutButton();
        //pack
        this.menu.pack();
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
     * Adds a 'make a deposit' menu button.
     */
    public void addDepositMenuButton(){
        JButton button = new JButton("Make a Deposit");
        button.addActionListener(new DepositButtonListener(this));
        this.menu.getContentPane().add(button);
    }

    /**
     * Adds a 'make a withdrawal' menu button.
     */
    public void addWithdrawalMenuButton(){
        JButton button = new JButton("Make a Withdrawal");
        button.addActionListener(new WithdrawButtonListener(this));
        this.menu.getContentPane().add(button);
    }

    /**
     * Adds a 'make a Funds Transfer' menu button.
     */
    public void addTransferMenuButton(){
        JButton button = new JButton("Make a Funds Transfer");
        button.addActionListener(new TransferButtonListener(this));
        this.menu.getContentPane().add(button);
    }

    /**
     * Adds a 'request a loan' menu button.
     */
    public void addLoanMenuButton(){
        JButton button = new JButton("Request a Loan");
        button.addActionListener(new LoanRequestButtonListener(this));
        this.menu.getContentPane().add(button);
    }

    /**
     * Ends the session for the user that is logged in, and clears their information.
     */
    public void addLogoutButton(){
        JButton button = new JButton("Logout");
        button.addActionListener(new LogoutButtonListener(this));
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
     * Toggles the menu to be visible
     */
    public void displayMenu(){
        this.menu.setVisible(true);
    }

    /**
     * Toggles the menu to be hidden
     */
    public void hideMenu(){
        this.menu.setVisible(false);
    }

    /**
     * Getter method that returns the JFrame of the deposit window
     * @return make a deposit window
     */
    public JFrame getDeposit () {
        return deposit;
    }

    /**
     * Toggles the 'make a deposit' window to be visible
     */
    public void displayDeposit(){
        this.deposit.setVisible(true);
    }

    /**
     * Toggles the 'make a deposit' window to be hidden
     */
    public void hideDeposit(){
        this.deposit.setVisible(false);
    }

    /**
     * Getter method that returns the JFrame of the withdrawal window
     * @return make a withdrawal window
     */
    public JFrame getWithdraw () {
        return withdraw;
    }

    /**
     * Toggles the 'make a withdrawal' window to be visible
     */
    public void displayWithdraw(){
        this.withdraw.setVisible(true);
    }

    /**
     * Toggles the 'make a withdrawal' window to be hidden
     */
    public void hideWithdraw(){
        this.withdraw.setVisible(false);
    }

    /**
     * Getter method that returns the JFrame of the transfer funds window
     * @return make funds transfer window
     */
    public JFrame getTransfer () {
        return transfer;
    }

    /**
     * Toggles the 'make a funds transfer' window to be visible
     */
    public void displayTransfer(){
        this.transfer.setVisible(true);
    }

    /**
     * Toggles the 'make a funds transfer' window to be hidden
     */
    public void hideTransfer(){
        this.transfer.setVisible(false);
    }

    /**
     * Getter method that returns the JFrame of the request a loan window
     * @return request a loan window
     */
    public JFrame getRequestLoan () {
        return requestLoan;
    }

    /**
     * Toggles the 'request a loan' window to be visible
     */
    public void displayRequestLoan(){
        this.requestLoan.setVisible(true);
    }

    /**
     * Toggles the 'request a loan' window to be hidden
     */
    public void hideRequestLoan(){
        this.requestLoan.setVisible(false);
    }
    public void initializeCheckBalanceWindow(){}

    /**
     * Getter method that returns the JFrame of the check balance window
     * @return check balance window
     */
    public JFrame getCheckBalance () {
        return checkBalance;
    }

    /**
     * Toggles the 'request a loan' window to be visible
     */
    public void displayCheckBalance(){
        this.checkBalance.setVisible(true);
    }
    /**
     * Toggles the 'request a loan' window to be hidden
     */
    public void hideCheckBalance(){
        this.checkBalance.setVisible(false);
    }

    /**
     * Getter method that gets the user attribute stored in the window GUI.
     * @return this.user along with their bank information.
     */
    public User getUser(){
        return this.user;
    }

    /**
     * Setter method that sets the user attribute. Note that this method should only be called
     * if the user has successfully logged in, or if a user has just created an account.
     * @param loggedInUser - the user that created an account / logged in.
     */
    public void setUser(User loggedInUser){
        this.user = loggedInUser;
    }

    /**
     * Clears the information stored in the user attribute. This method should be used when
     * the user logs out, so that no sensitive information remains for the next user that logs in.
     */
    public void clearUser(){
        this.user = null;
    }
}
