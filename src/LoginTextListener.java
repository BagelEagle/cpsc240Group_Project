package src;

import javax.swing.*;
import java.awt.event.*;

class LoginTextListener implements ActionListener {
    public LoginTextListener(){
    }

    @Override
    public void actionPerformed(ActionEvent e){

        JOptionPane.showMessageDialog(null, "Push the button to Login!");
    }
}
