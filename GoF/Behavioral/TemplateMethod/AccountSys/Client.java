package GoF.Behavioral.TemplateMethod.AccountSys;

import GoF.Behavioral.XMLUtil;

/**
 * 模板方法模型：
 */

public class Client {
    public static void main(String[] args) {
        for (Account account : XMLUtil.getAccountBeans()) {
            account.handle("Tony" , "12");
            System.out.println();
        }
    }
}
