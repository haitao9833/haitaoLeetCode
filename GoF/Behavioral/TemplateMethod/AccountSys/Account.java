package GoF.Behavioral.TemplateMethod.AccountSys;

import java.util.regex.Pattern;

public abstract class Account {
    // 模板方法，算法框架
    public void handle(String account , String password) {
        if (!validate(account , password)) {
            return;
        }
        calculateInterest();
        display();
    }
    // 具体方法
    public boolean validate(String account ,  String password) {
        System.out.printf("账号：%s\n密码：%s" , account , password);
        if (Pattern.matches("\\d+" , password)) {
            System.out.println(" (账户有效)");
            return true;
        } else {
            System.out.println(" (账户无效！)");
            return false;
        }
    }
    // 抽象方法
    public abstract void calculateInterest();
    // 具体方法
    public void display() {
        System.out.println("显示利息！");
    }


    // 钩子方法，控制其他方法的执行
}
