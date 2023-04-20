package GoF.Behavioral.Command.Sub01;

/**
 * 将请求封装为一个命令类对象，可以在命令类中实现诸多功能
 * 例如撤销 Undo 和恢复 Redo ，且避免了请求发送者和请求接收者的耦合
 */

public class Client {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setCommand(new AddCommand());
        calculator.compute(10);
        calculator.compute(5);
        calculator.compute(10);
        calculator.undo();
    }
}
