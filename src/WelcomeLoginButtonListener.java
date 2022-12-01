package src;

import javax.swing.*;
import java.awt.event.*;

public class WelcomeLoginButtonListener implements ActionListener{
    private Window window;
    public WelcomeLoginButtonListener(Window jframeWindow){
        this.window = jframeWindow;
    }

    @Override
    public void actionPerformed(ActionEvent mouseClick){
        this.window.hideWelcome();
        this.window.displayLogin();
    }
}
