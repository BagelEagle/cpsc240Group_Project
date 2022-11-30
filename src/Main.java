package src;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static HashMap<String, User> users = new HashMap<>();
    private static User mainUser;

    public static void createNewUser () throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
        String newUsername = null;
        System.out.println("Create a new account");
        System.out.print("Please create a username: ");
        Scanner in = new Scanner(System.in);
        newUsername = in.nextLine();
        for (String id: users.keySet()) {
            if (id.equals(newUsername)) {
                while (id.equals(newUsername)) {
                    System.out.print("This username is taken. Please enter a different username: ");
                    Scanner newIn = new Scanner(System.in);
                    newUsername = newIn.nextLine();
                }
            }
        }
        File file = new File("./users/"+newUsername+".txt");
        file.createNewFile();

        PrintWriter output = new PrintWriter("./users/"+newUsername+".txt");
        output.println(newUsername);
        System.out.print("Please create a password: ");
        Scanner in2 = new Scanner(System.in);
        String password = in2.nextLine();
        //next 3 lines creates salt
        //password hashing - "the salt" is what is used to transform the password so each salt would need to be stored with password, so added a new variable to the user object to include this
        byte[] salt = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);

        System.out.println(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        Base64.Encoder enc = Base64.getEncoder();
        String theSalt = enc.encodeToString(salt);
        password = enc.encodeToString(hash);
        output.println(password);
        output.println(theSalt);

        System.out.println("First name:");
        Scanner in3 = new Scanner(System.in);
        String fname = in3.nextLine();
        output.println(fname);
        System.out.println("Last name:");
        Scanner in4 = new Scanner(System.in);
        String lname = in4.nextLine();
        output.println(lname);
        users.put(newUsername,new User(newUsername,password,theSalt,fname,lname,0.0,0.0));
        System.out.println("Your account has been successfully created.");
        System.out.println("");
        output.println(0);
        output.println(0);
        output.println(0);
        output.print(0);
        output.close();
    }

    public static void addToHashFromFile () throws FileNotFoundException {
        User user = null;
        String filename;
        File dir = new File("./users");
        File[] directoryListing = dir.listFiles();
        for (File aFile: directoryListing) {
            filename = aFile.getName();
            filename = filename.substring(0, filename.length() - 4);
            FileReader reader = new FileReader(aFile);
            Scanner in = new Scanner(reader);
            while (in.hasNext()) {
                user = new User(in);
                if (in.hasNext()) {
                    in.nextLine();
                }
            }
            users.put(filename, user);
        }
    }

    public static boolean login () throws NoSuchAlgorithmException, InvalidKeySpecException, FileNotFoundException {
        String filename;
        String fileUsername = null;
        String matchFile = null;
        System.out.println("Username: ");
        Scanner in = new Scanner(System.in);
        String loginUsername = in.nextLine();
        File dir = new File("./users");
        File[] directoryListing = dir.listFiles();
        for (File aFile: directoryListing) {
            filename = aFile.getName();
            fileUsername = filename.substring(0, filename.length() - 4);
            if (fileUsername.equals(loginUsername)) {
                matchFile = aFile.getName();
            }
        }
        if (matchFile==null) {
            System.out.println("Invalid Username.");
            return false;
        } else {
            System.out.println("Password: ");
            Scanner in2 = new Scanner (System.in);
            String pass = in.nextLine();
            for (String userName: users.keySet()) {
                if (userName.equals(fileUsername)) {
                    mainUser = users.get(userName);
                }
            }
            String salt = mainUser.getSalt();
            byte[] theSalt = salt.getBytes(StandardCharsets.UTF_8);
            System.out.println(theSalt);
            KeySpec spec = new PBEKeySpec(pass.toCharArray(), theSalt, 65536, 128);
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();
            String newPass = enc.encodeToString(hash);
            System.out.println(newPass);
            String userPass = mainUser.getPassword();
            System.out.println(userPass);
            if (newPass.equals(userPass)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void balance(User user) {
        System.out.println("Which account balance would you like to see?");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.println("3. Money Market");
        System.out.println("4. Certificate Deposit");
        System.out.println("5. All");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        if (choice == 1) {
            user.balanceChecking();
        } else if (choice == 2) {
            user.balanceSavings();
        } else if (choice == 3) {
            user.balanceMoneyMarket();
        } else if (choice == 4) {
            user.balanceCertificateDeposit();
        } else if (choice == 5) {
            user.balance();
        } else {
            System.out.println("You did not select a valid account");
            System.out.println("");
        }
    }

    public static void deposit(User user) {
        System.out.println("Which account would you like to deposit in to?");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.println("3. Money Market");
        System.out.println("4. Certificate Deposit");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        System.out.println("How much would you like to deposit?");
        double depositAmount = in.nextDouble();

        if (choice == 1) {
            user.withdrawChecking(depositAmount);
        } else if (choice == 2) {
            user.withdrawSavings(depositAmount);
        } else if (choice == 3) {
            user.withdrawMoneyMarket(depositAmount);
        } else if (choice == 4) {
            user.withdrawCertificateDeposit(depositAmount);
        } else {
            System.out.println("You did not select a valid account");
            System.out.println("");
        }
    }

    public static void withdraw(User user) {
        System.out.println("Which account would you like to withdraw from?");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.println("3. Money Market");
        System.out.println("4. Certificate Deposit");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        System.out.println("How much would you like to withdraw?");
        double withdrawAmount = in.nextDouble();

        if (choice == 1) {
            user.withdrawChecking(withdrawAmount);
        } else if (choice == 2) {
            user.withdrawSavings(withdrawAmount);
        } else if (choice == 3) {
            user.withdrawMoneyMarket(withdrawAmount);
        } else if (choice == 4) {
            user.withdrawCertificateDeposit(withdrawAmount);
        } else {
            System.out.println("You did not select a valid account");
            System.out.println("");
        }


    }

    public static void transfer(User user) {
        Scanner in = new Scanner(System.in);
        System.out.println("Which account would you like to transfer money from?");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.println("3. Money Market");
        System.out.println("4. Certificate Deposit");
        int account1 = in.nextInt();
        double balance1;
        if (account1 == 1) {
            ;balance1 = user.getChecking();
        } else if (account1 == 2) {
            balance1 = user.getSavings();
        } else if (account1 == 3) {
            balance1 = user.getMM();
        } else if (account1 == 4) {
            balance1 = user.getCD();
        } else {
                System.out.println("You did not select a valid account");
                System.out.println("");
        }

        Scanner in2 = new Scanner(System.in);
        System.out.println("Which account would you like to transfer money to?");
        System.out.println("1. Checking");
        System.out.println("2. Savings");
        System.out.println("3. Money Market");
        System.out.println("4. Certificate Deposit");
        int account2 = in.nextInt();
        double balance2;
        if (account2 == 1) {
            ;balance2 = user.getChecking();
        } else if (account2 == 2) {
            balance2 = user.getSavings();
        } else if (account2 == 3) {
            balance2 = user.getMM();
        } else if (account2 == 4) {
            balance2 = user.getCD();
        } else {
            System.out.println("You did not select a valid account");
            System.out.println("");
        }
    }

    public static void loan() {
        Scanner in = new Scanner(System.in);
        System.out.println("How much would you like to request a loan for?");
        double loanAmount = in.nextDouble();

        Scanner in2 = new Scanner(System.in);
        System.out.println("What is the reason you are requesting a loan?");
        String loanReason = in2.nextLine();

        Scanner in3 = new Scanner(System.in);
        System.out.println("What is your current salary?");
        double salary = in3.nextDouble();

        System.out.println("Thank you for your request. It will be reviewed and you will be notified when it has been approved");
        System.out.println("");
    }

    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException, IOException {
        //Line below initializes all the windows and displays the login window.
        //Window win = new Window();
        addToHashFromFile();
        System.out.println(users);
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
                if (login()==true) {
                    int choice1 = 0;
                    while (choice1!=6) {
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
                        choice1 = in.nextInt();
                        if (choice1==1) {
                            //balance();
                        } else if (choice1==2) {
//                        deposit();
                        } else if (choice1==3) {
                            //withdraw();
                        } else if (choice1==4) {
                            //transfer();
                        } else if (choice1==5) {
                            loan();
                        } else if (choice1==6) {
                            continue;
                        }
                    }
                } else {
                    continue;
                }
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
                        //balance();
                    } else if (choice2==2) {
//                        deposit();
                    } else if (choice2==3) {
                        //withdraw();
                    } else if (choice2==4) {
                        //transfer();
                    } else if (choice2==5) {
                        loan();
                    } else if (choice2==6) {
                        continue;
                    }
                }
            } else if (choice == 3) {
                System.exit(0);
            }
        }
    }
}
