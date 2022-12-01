package src;

import javax.swing.*;
import java.awt.event.*;

public class LoginButtonListener implements ActionListener{
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
        String message = "This button can read in what the user types in both text fields. It should verify that the password matches" +
                " the password found in the corresponding user file. For now, this button just tells you what you typed for testing purposes." +
                " It also switches to the main menu";
        JOptionPane.showMessageDialog(null, message);
        JOptionPane.showMessageDialog(null, "You typed: " + this.login.getText() + " " + this.password.getText());
        //Currently does not check if login was successful. Just goes straight to main menu
        //System.out.println(mainUser.getUsername());
        //login.setText(mainUser.getUsername());
        //password.setText(mainUser.getPassword());
        login.setText("");
        password.setText("");
        window.hideLogin();
        window.displayMenu();
    }
}
