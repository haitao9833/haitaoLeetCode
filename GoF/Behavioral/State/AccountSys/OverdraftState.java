package GoF.Behavioral.State.AccountSys;

public class OverdraftState extends AccountState {
    public OverdraftState(AccountState state) {  // 透支状态，仅有状态参数的构造函数
        this.account = state.account;
    }
    @Override
    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        stateCheck();
    }
    @Override
    public void withdraw(double amount) {
        account.setBalance(account.getBalance() - amount);
        stateCheck();
    }
    @Override
    public void computeInterest() {
        System.out.println("透支状态，按天计算利息！");
    }
    @Override
    public void stateCheck() {
        if (account.getBalance() > 0) {
            account.setState(new NormalState(this));
        } else if (account.getBalance() <= -2000) {
            account.setState(new RestrictedState(this));
        }
    }
}
