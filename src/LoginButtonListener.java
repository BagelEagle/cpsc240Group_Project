package src;

import javax.swing.*;
import java.awt.event.*;

class LoginButtonListener implements ActionListener{
    private Window window;
    private JTextField login;
    private JTextField password;
    public LoginButtonListener(Window jframeWindow, JTextField login, JTextField pass){
        this.window = jframeWindow;
        this.login = login;
        this.password = pass;
    }
    //Here is where the main check should occur to see if the users credentials matches what is saved in the file
    @Override
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null, "You typed: " + this.login.getText() + " " + this.password.getText());
        //Currently does not check if login was successful. Just goes straight to main menu
        window.hideLogin();
        window.displayMenu();
    }
}
