package GoF.Behavioral.Command;

public class ExitCommand extends Command {
    private SystemExitClass obj;
    public ExitCommand() {
        obj = new SystemExitClass();
    }
    @Override
    public void execute() {
        obj.exit();
    }
}
