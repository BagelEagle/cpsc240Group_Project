package src;

import javax.swing.*;

public class Main {
    public static void addLoginButton(String text, JFrame f, JTextField log, JTextField pass) {
        // add a login button object
        JButton button = new JButton(text);
        button.addActionListener(new LoginButtonListener(log, pass));
        f.getContentPane().add(button);
    }
    public static void addLoginField(JFrame f){
        //Add Login Fields
        JTextField login = new JTextField(40);
        JTextField password = new JPasswordField(40);
        login.addActionListener(new TextListener());
        password.addActionListener(new TextListener());
        addLabel(f, "Username:");
        f.getContentPane().add(login);
        addLabel(f, "Password:");
        f.getContentPane().add(password);

        addLoginButton("Some text", f, login, password);
    }
    public static void addLabel(JFrame f, String text){
        //add a label object
        JLabel label = new JLabel(text);
        f.getContentPane().add(label);
    }

    public static void main(String[] args) {
        // create the login Window
        JFrame frame = new JFrame("Login Page");

        // Exits program upon closing window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make Box layout
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        //Adds login and password textboxes, as well as the labels and login button
        addLoginField(frame);

        // display the window
        frame.pack();
        frame.setVisible(true);
    }
}
