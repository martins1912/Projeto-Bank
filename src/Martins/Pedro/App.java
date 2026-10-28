package Martins.Pedro;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank santander = new Bank("0001");

        while (true) {
            System.out.println("Seja bem-vindo ao Banco Santander, o que deseja fazer? C=Criar conta, E=sair do programa");
            String op = sc.nextLine();

            if (op.equals("C")) {
                System.out.println("Digite o nome: ");
                String name = sc.nextLine();
                Account account = santander.generateAccount(name);
                System.out.println(account);
                santander.insertAccount(account);
                operateAccount(account, sc);

            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("comando invalido");
            }
        }
        List<Account> accounts = santander.getAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
        santander.outputTotal();

        sc.close();
    }

    static void operateAccount(Account account, Scanner sc) {
        while (true) {
            System.out.println("O que deseja fazer? D=Depositar, S=Sacar, V=Ver saldo, X=Voltar");
            String op = sc.nextLine();

            if (op.equals("D")) {
                System.out.println("Valor do depósito: ");
                try {
                    double value = Double.parseDouble(sc.nextLine());
                    account.deposit(value);
                    System.out.println("Depósito realizado!");
                } catch (NumberFormatException e) {
                    System.out.println("valor invalido");
                }
            } else if (op.equals("S")) {
                System.out.println("Valor do saque: ");
                try {
                    double value = Double.parseDouble(sc.nextLine());
                    if (account.withDraw(value)) {
                        System.out.println("Saque realizado!");
                    } else {
                        System.out.println("Saldo insuficiente ou valor invalido");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("valor invalido");
                }
            } else if (op.equals("V")) {
                System.out.println(account);
            } else if (op.equals("X")) {
                break; // volta para o menu principal
            } else {
                System.out.println("comando invalido");

                System.out.println("Valor invalido");
            }
        }
    }
}