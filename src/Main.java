package src;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, User> users = new HashMap<>();
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

    public static void createNewUser () {
        String newUsername = null;
        System.out.println("Create a new account");
        System.out.println("Please enter a username");
        System.out.print(": ");
        for (String id: users.keySet()) {
            Scanner in = new Scanner(System.in);
            newUsername = in.nextLine();
            while (id.equals(newUsername)) {
                System.out.println("This username is taken. Please enter a different username");
                System.out.print(": ");
                newUsername = in.nextLine();
            }
        }
        System.out.print("Please enter a password:");
        Scanner in2 = new Scanner(System.in);
        String password = in2.nextLine();
        System.out.println("First name:");
        Scanner in3 = new Scanner(System.in);
        String fname = in3.nextLine();
        System.out.println("Last name:");
        Scanner in4 = new Scanner(System.in);
        String lname = in4.nextLine();
        users.put(newUsername,new User(newUsername,password,fname,lname,0.0,0.0));
    }

    public static void main(String[] args) {
        System.out.println("Welcome to your mobile bank account!");
        int choice = 0;
        while (choice!=3) {
            System.out.println("1. Login to existing account");
            System.out.println("2. Create an account");
            System.out.println("3. Exit");
            System.out.print(": ");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            if (choice == 1) {

            } else if (choice == 2) {
                createNewUser();
            } else if (choice == 3) {
                System.exit(0);
            }
        }
//        // create the login Window
//        JFrame frame = new JFrame("Login Page");
//
//        // Exits program upon closing window
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Make Box layout
//        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
//
//        //Adds login and password textboxes, as well as the labels and login button
//        addLoginField(frame);
//
//        // display the window
//        frame.pack();
//        frame.setVisible(true);
    }
}
