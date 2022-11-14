import javax.swing.*;
import java.awt.event.*;

class LoginButtonListener implements ActionListener{
    //Text fields for login and password
    final private JTextField login;
    final private JTextField password;
    public LoginButtonListener(JTextField login, JTextField pass){
        this.login = login;
        this.password = pass;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null, "You typed: " + this.login.getText() + " " + this.password.getText());
    }

}
