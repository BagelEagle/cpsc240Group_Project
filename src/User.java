package src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.PrintWriter;
import java.util.InputMismatchException;

/**
 * @author James Amador, Kaylie Curran, April Groce
 */
public class User {
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String salt;
    private double checking;
    private double savings;
    private double moneyMarket;
    private double certificateDeposit;

    /**
     * This constructor is for new users. All users start with no money
     * in their money market and CDs, but the amount in their checking
     * and savings account is subject to whatever the user says they start
     * with on account creation.
     * @param uname Stores the username of the user
     * @param fname Stores the user's first name
     * @param lname Stores the user's last name
     * @param checkAct Stores the amount of money in the user's checking account
     * @param saveAct Stores the amount of money in the user's savings account
     */
    public User(String uname, String pass, String salt, String fname, String lname, double checkAct, double saveAct){
        this.username = uname;
        this.password = pass;
        this.salt = salt;
        this.fname = fname;
        this.lname = lname;
        this.checking = checkAct;
        this.savings = saveAct;
        this.moneyMarket = 0.0;
        this.certificateDeposit = 0.0;
    }

    /**
     * This constructor is for existing users. The information for each user is stored
     * in one file per user, with the filename being the user's username. This, of course,
     * is subject to change if another efficient method is found for storing user info.
     * This is based off of the Card constructor found in the SRS, with some heavy modifications.
     * @param read Scanner reads a file and parses each line for user information.
     */
    public User(Scanner read){
        this.username = read.nextLine();
        this.password = read.nextLine();
        this.salt = read.nextLine();
        this.fname = read.nextLine();
        this.lname = read.nextLine();
        this.checking = read.nextDouble();
        this.savings = read.nextDouble();
        this.moneyMarket = read.nextDouble();
        this.certificateDeposit = read.nextDouble();
    }

    public String getPassword () {
        return password;
    }

    public String getSalt () {
        return salt;
    }

    /**
     * Deposits a user specified amount into the user's checking account
     * @param balance the amount to be deposited into the checking account
     */
    public void depositChecking(double balance){
        this.checking += balance;
    }

    public void depositSavings(double balance){
        this.savings += balance;
    }

    public void depositMoneyMarket(double balance){
        this.moneyMarket += balance;
    }

    public void depositCertificateDeposit(double balance){
        this.certificateDeposit += balance;
    }

    /**
     * Withdraws a user specified amount from the user's checking account
     * @param balance the amount to be withdrawn from the checking account
     */
    public void withdrawChecking(double balance){
        if((this.checking - balance) >= 0){
            this.checking -= balance;
        }else{
            System.out.println("You cannot withdraw more money than is in your account!");
        }
    }

    public void withdrawSavings(double balance){
        if((this.savings - balance) >= 0){
            this.savings -= balance;
        }else{
            System.out.println("You cannot withdraw more money than is in your account!");
        }
    }

    public void withdrawMoneyMarket(double balance){
        if((this.moneyMarket - balance) >= 0){
            this.moneyMarket -= balance;
        }else{
            System.out.println("You cannot withdraw more money than is in your account!");
        }
    }

    public void withdrawCertificateDeposit(double balance){
        if((this.certificateDeposit - balance) >= 0){
            this.certificateDeposit -= balance;
        }else{
            System.out.println("You cannot withdraw more money than is in your account!");
        }
    }

    public void balanceChecking() {
        System.out.println(this.checking);
    }

    public void balanceSavings() {
        System.out.println(this.savings);
    }

    public void balanceMoneyMarket() {
        System.out.println(this.moneyMarket);
    }

    public void balanceCertificateDeposit() {
        System.out.println(this.certificateDeposit);
    }

    public void balance() {
        System.out.println(this.checking);
        System.out.println(this.savings);
        System.out.println(this.moneyMarket);
        System.out.println(this.certificateDeposit);
    }

    public void transferCheckingSaving(double balance) {
        withdrawChecking(balance);
        depositSavings(balance);
    }

    public void transferCheckingMM(double balance) {
        withdrawChecking(balance);
        depositMoneyMarket(balance);
    }

    public void transferCheckingCD(double balance) {
        withdrawChecking(balance);
        depositCertificateDeposit(balance);
    }
    /**
     * Retrieve's the amount of money in the user's checking account
     * @return amount of money in user's checking account
     */
    public double getChecking(){
        return this.checking;
    }

    /**
     * Retrieve's the amount of money in hte user's savings account
     * @return amount of money in user's savings account
     */
    public double getSavings(){
        return this.savings;
    }

    /**
     * Retrieve's the amount of money in the user's money market
     * @return amount of money in the user's money market
     */
    public double getMM(){
        return this.moneyMarket;
    }

    /**
     * Retrieve's the amount of money that is in the user's Certificate Deposit
     * @return the amount of money in the user's Certificate Deposit
     */
    public double getCD(){
        return this.certificateDeposit;
    }
}