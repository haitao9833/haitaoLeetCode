package GoF.Behavioral.Command;

import GoF.Behavioral.XMLUtil;

/**
 * 命令模式：
 *        角色：
 *            1、Invoker          请求发送者    聚合一个抽象命令类，构造注入或者 Setter 注入
 *            2、Command          抽象命令类    一个请求 == 一个命令
 *            3、ConcreteCommand  具体命令类    组合一个请求接收者，构造函数中直接实例化
 *            4、Receiver         请求接收者    具体实现对请求的业务处理
 *        优点：完全解耦请求发送者和请求接收者
 *             将二者之间的请求封装为一个命令对象
 *        缺点：针对每一个请求接收者，都需要设计一个具体命令类
 */

public class Client {
    public static void main(String[] args) {
        Button button = new Button();
        for (Command command : XMLUtil.getCommandBeans()) {
            button.setCommand(command);
            button.click();
            System.out.println();
        }
    }
}
