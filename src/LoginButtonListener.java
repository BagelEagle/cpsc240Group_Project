package src;

import javax.swing.*;
import java.awt.event.*;

import static src.Main.mainUser;

public class LoginButtonListener implements ActionListener{
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
        //Code in the line below is for testing purposes. It proves you can retrieve the text from
        //text boxes.
        JOptionPane.showMessageDialog(null, "You typed: " + this.login.getText() + " " + this.password.getText());
        //Currently does not check if login was successful. Just goes straight to main menu
        System.out.println(mainUser.getUsername());
        login.setText(mainUser.getUsername());
        password.setText(mainUser.getPassword());
        JOptionPane.showMessageDialog(null, "Welcome!");
        login.setText("");
        password.setText("");
        window.hideLogin();
        window.displayMenu();
    }
}
