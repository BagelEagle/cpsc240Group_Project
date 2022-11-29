package src;

import javax.swing.*;

public class Window {
    private JFrame login;
    private JFrame menu;
    private JFrame deposit;
    private JFrame withdraw;
    private JFrame transfer;
    private JFrame requestLoan;
    private JFrame checkBalance;

    public JFrame getLogin () {
        return login;
    }

    public JFrame getMenu () {
        return menu;
    }

    public JFrame getDeposit () {
        return deposit;
    }

    public JFrame getWithdraw () {
        return withdraw;
    }

    public JFrame getTransfer () {
        return transfer;
    }

    public JFrame getRequestLoan () {
        return requestLoan;
    }

    public JFrame getCheckBalance () {
        return checkBalance;
    }
}
