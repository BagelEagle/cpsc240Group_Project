package src;

import javax.swing.*;
import java.awt.event.*;

class NewUserButtonListener implements ActionListener{
    //Text field
    final private String buttonName;
    public NewUserButtonListener(String name){
        this.buttonName = name;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null, "Button pushed!");
    }
}
