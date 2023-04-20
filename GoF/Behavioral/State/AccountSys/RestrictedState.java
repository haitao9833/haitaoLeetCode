package GoF.Behavioral.State.AccountSys;

public class RestrictedState extends AccountState {
    public RestrictedState(AccountState state) {  // 受限状态，仅有状态参数的构造函数
        this.account = state.account;
    }
    @Override
    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
        stateCheck();
    }
    @Override
    public void withdraw(double amount) {
        System.out.println("账户受限，取款失败！");
    }
    @Override
    public void computeInterest() {
        System.out.println("受限状态，按天计算利息！");
    }
    @Override
    public void stateCheck() {
        if (account.getBalance() > 0) {
            account.setState(new NormalState(this));
        } else if (account.getBalance() > -2000) {
            account.setState(new OverdraftState(this));
        }
    }
}
