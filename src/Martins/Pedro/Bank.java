package Martins.Pedro;

import java.util.List;
import java.util.ArrayList;

public class Bank {
    private String ag;

    private List<Account> accounts;

    private int LastAccount = 1;
    public Bank(String ag) {
        this.ag = ag;
        accounts = new ArrayList<>();
    }
    public List<Account> getAccounts() {
        return accounts;
    }

    public Account generateAccount(String name) {
        String cc;
        Account account = new Account(ag, cc=" " + LastAccount, name);
        LastAccount++;
        return account;


    }

    public void insertAccount(Account account) {
        accounts.add(account);
    }
    public void outputTotal() {
        double total = 0;
        for (Account account : accounts) {
            double balance = account.getBalance();
            total += balance;
        }
        System.out.println("Total Balance: " + total);
        System.out.println("Obrigado por escolher nosso banco: " + ag);
        {

        }

    }


}