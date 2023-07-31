package co.caiocesar.bank;

import java.util.List;
import java.util.ArrayList;
public class Bank {

    private String ag;
    private List <User> accounts;
    private int lastAccount = 1;

    public Bank(String ag){
        this.ag = ag;
        this.accounts = new ArrayList<>();
    }

    public List<User> getAccounts() {
        return accounts;
    }

    public void insertAccount(User account){
        accounts.add(account);
    }

    public User generateAccount(String name){
        User account = new User(ag, "" + lastAccount, name);
        lastAccount++;
        return account;
    }
    public void outputTotal(){
        double total = 0;
        for(User account : accounts) {
           double balance = account.getBalance();
           total += balance;
        }
        System.out.println("Banco possui agora: R$" + total);
    }
}
