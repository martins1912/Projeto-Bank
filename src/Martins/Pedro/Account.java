package Martins.Pedro;

public class Account {


    private String ag;
    private String cc;
    private String name;
    private double balance;


    private static final int MAX_LENGTH = 12;

    public Account(String ag, String cc, String name) {
        this.ag = ag;
        this.cc = cc;
        setName(name);

        Log.out("Conta criada para " + this.name);


    }

    public void setName(String name) {
        if (name.length() > MAX_LENGTH) {
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }
        System.out.println(this.name);
    }

    public void deposit(double value) {
        balance = balance + value;
        Log.out("Deposito - R$" + value + " | saldo: " + balance);

    }

    public boolean withDraw(double value) {



        if (balance < value) {
            Log.out("Saque - R$" + value + " recusado | saldo: " + balance);
            return false;

        }

        balance -= value;
        Log.out("Saque - R$" + value + " efetuado | saldo: " + balance);
        return true;



    }
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        String result = "A conta" + this.name + " " + this.ag + " " + this.cc + " possui: R$" + this.balance;
        return result;


    }


}