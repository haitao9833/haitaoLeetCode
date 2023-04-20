package GoF.Behavioral.Command.Sub01;

public abstract class Command {
    public abstract int execute(int value);    // 执行
    public abstract int undo();                // 撤销执行
}
