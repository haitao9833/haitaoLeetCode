package GoF.Behavioral.State.AccountSys;

/**
 * 状态模式：
 */

public class Client {
    public static void main(String[] args) {
        Account account = new Account("李慧莹" , 0);
        account.deposit(1000);
        account.withdraw(2000);
        account.deposit(3000);
        account.withdraw(5000);
        account.withdraw(1000);
        account.deposit(3001);
        account.computeInterest();
    }
}
