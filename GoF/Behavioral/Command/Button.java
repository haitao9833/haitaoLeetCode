package GoF.Behavioral.Command;

public class Button {  // 可自定义功能的按键
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void click() {
        System.out.print("单击按钮：");
        command.execute();
    }
}
