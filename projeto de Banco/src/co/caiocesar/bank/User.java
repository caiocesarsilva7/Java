package co.caiocesar.bank;

public class User {
    private String ag;
    private String cc;
    private String name;
    private double balance;
    private static final int MAX_LENGHT = 12;
    private Log logger;

    public User(String ag, String  cc, String name){
        this.ag = ag;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }

    public void setName(String name){
        if (name.length() > MAX_LENGHT){
            this.name = name.substring(0, 12);
        } else {
            this.name = name;
        }
    }

    public boolean withDraw(double value){
        if (balance < value){
            logger.out("SAQUE - R$" + value + " Seu saldo atual é de " + balance);
            return false;
        } else {
            balance -= value;
            System.out.println("Valor a retirar: " + value + ", total na conta agora é " + balance);
            logger.out("SAQUE - R$ " + value + " Sua conta agora é de R$ " + balance);
            return true;
        }
    }
    public void deposit(double value){
        balance += value;
        logger.out("DEPÓSITO - R$ " + value + " Sua conta agora é de R$ " + balance);
        }

        public double getBalance(){
        return balance;
        }

    @Override
    public String toString() {
    return "A conta " + this.name + " " + this.ag + " / " + this.cc + " possui: R$ " + balance;
    }
}

