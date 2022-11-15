package src;

import javax.swing.*;
import java.awt.event.*;

class TextListener implements ActionListener {
    public TextListener(){
    }

    @Override
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null, "Push the button to Login!");
    }
}
