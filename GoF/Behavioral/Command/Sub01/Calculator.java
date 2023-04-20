package GoF.Behavioral.Command.Sub01;

public class Calculator {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void compute(int value) {
        int i = command.execute(value);
        System.out.println("执行运算结果为：" + i);
    }
    public void undo() {
        int i = command.undo();
        System.out.println("撤销执行结果为：" + i);
    }
}
