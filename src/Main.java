package src;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

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

    public static void createNewUser () throws InvalidKeySpecException, NoSuchAlgorithmException {
        String newUsername = null;
        System.out.println("Create a new account");
        System.out.print("Please create a username: ");
        Scanner in = new Scanner(System.in);
        newUsername = in.nextLine();
        for (String id: users.keySet()) {
            if (id.equals(newUsername)) {
                System.out.print("This username is taken. Please enter a different username: ");
                Scanner newIn = new Scanner(System.in);
                newUsername = newIn.nextLine();
            }
        }
        System.out.print("Please create a password:");
        Scanner in2 = new Scanner(System.in);
        String password = in2.nextLine();

        //password hashing - "the salt" is what is used to transform the password so each salt would need to be stored with password, so added a new variable to the user object to include this
        byte[] salt = new byte[16];
        SecureRandom random = null;
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        String theSalt = enc.encodeToString(salt);
        password = enc.encodeToString(hash);

        System.out.println("First name:");
        Scanner in3 = new Scanner(System.in);
        String fname = in3.nextLine();
        System.out.println("Last name:");
        Scanner in4 = new Scanner(System.in);
        String lname = in4.nextLine();
        users.put(newUsername,new User(newUsername,password,theSalt,fname,lname,0.0,0.0));
    }

    public static void login () {

    }

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
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
                int choice2 = 0;
                while (choice2!=6) {
                    System.out.println("Main Menu");
                    System.out.println("Manage your bank accounts");
                    System.out.println("1. See account balance");
                    System.out.println("2. Make a deposit");
                    System.out.println("3. Withdraw money");
                    System.out.println("4. Transfer money");
                    System.out.println("5. Request a loan");
                    System.out.println("6. Log out");
                    System.out.print(": ");
                    Scanner in2 = new Scanner(System.in);
                    choice2 = in.nextInt();
                    if (choice2==1) {

                    } else if (choice2==2) {

                    } else if (choice2==3) {

                    } else if (choice2==4) {

                    } else if (choice2==5) {

                    } else if (choice2==6) {
                        continue;
                    }
                }
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
