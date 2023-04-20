package GoF.Behavioral.TemplateMethod.AccountSys;

public class CurrentAccount extends Account { // 活期账户
    @Override
    public void calculateInterest() {
        System.out.println("按活期利率计算利息！");
    }
}
