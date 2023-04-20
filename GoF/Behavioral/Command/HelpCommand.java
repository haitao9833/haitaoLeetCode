package GoF.Behavioral.Command;

public class HelpCommand extends Command {
    private DisplayHelpClass obj;
    public HelpCommand() {
        obj = new DisplayHelpClass();
    }
    @Override
    public void execute() {
        obj.help();
    }
}
