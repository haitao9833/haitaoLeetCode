package GoF.Behavioral.State.AccountSys;

public abstract class AccountState {
    protected Account account;
    public abstract void deposit(double amount);      // 存款
    public abstract void withdraw(double amount);     // 取款
    public abstract void computeInterest();           // 利息
    public abstract void stateCheck();                // 状态转换
}
