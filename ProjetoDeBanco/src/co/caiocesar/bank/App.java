package co.caiocesar.bank;


import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class App {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank santander = new Bank("0001");

        while(true){
            System.out.println("O que deseja fazer? C = Criar conta, E = Sair do programa");
            String op = scanner.nextLine();
            if (op.equals("C")){
                System.out.println("Digite seu nome:");
                String name = scanner.nextLine();
                User account = santander.generateAccount(name);
                santander.insertAccount(account);
                operateAccount(account);
            } else if (op.equals("E")){
                break;
            }else {
                System.out.println("Comando invalido, tente novamente");
            }
        }
        List<User> accountList = santander.getAccounts();
        for(User cc : accountList){
            System.out.println(cc);
        }
        santander.outputTotal();
    }
    static void operateAccount(User account){
        Scanner scanner= new Scanner(System.in);
        while (true) {
            System.out.println("O que deseja fazer? D = Deposito, S = Saque, E = Sair");
            String op = scanner.nextLine();
            if (op.equals("D")) {
                System.out.println("Qual valor deseja depositar?");
                double value = scanner.nextDouble();
                account.deposit(value);
            } else if (op.equals("S")){
                System.out.println("Qual valor deseja sacar?");
                double value = scanner.nextDouble();
                if (!account.withDraw(value)){
                    System.out.println("Ops! Não foi possivel sacar o valor R$ " + value);
                }} else if (op.equals("E")){
                break;
            } else {
                System.out.println("Comando invalido, tente novamente!");
            }
            scanner = new Scanner(System.in);
        }

    }}
