package GoF.Behavioral.State.AccountSys;

public class Account {
    private AccountState state;
    private String owner;
    private double balance = 0;     // 账户余额
    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.state = new NormalState(this);
        System.out.printf("%s 开户成功 , 初始金额为 %6.2f\n\n" , this.owner , this.balance);
    }

    public double getBalance() {
        return balance;
    }
    public void setState(AccountState state) {
        this.state = state;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        state.deposit(amount);
        System.out.printf("%s 存款 %6.2f\n" , this.owner , amount);
        System.out.printf("现在余额为 %6.2f\n" , this.balance);
        System.out.printf("现在账户状态为 %s\n" , state.getClass().getName());
        System.out.println();
    }
    public void withdraw(double amount) {
        state.withdraw(amount);
        System.out.printf("%s 取款 %6.2f\n" , this.owner , amount);
        System.out.printf("现在余额为 %6.2f\n" , this.balance);
        System.out.printf("现在账户状态为 %s\n" , state.getClass().getName());
        System.out.println();
    }
    public void computeInterest() {
        state.computeInterest();
    }
}
