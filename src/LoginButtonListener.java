package src;

import javax.swing.*;
import java.awt.event.*;

class LoginButtonListener implements ActionListener{
    private Window window;
    private JTextField login;
    private JTextField password;
    public LoginButtonListener(Window jframeWindow, JTextField login, JTextField pass){
        this.login = login;
        this.password = pass;
    }
    //Here is where the main check should occur to see if the users credentials matches what is saved in the file
    @Override
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null, "You typed: " + this.login.getText() + " " + this.password.getText());
        //If login successful
        //window.hideLogin();
        //window.displayMenu();
    }
}
