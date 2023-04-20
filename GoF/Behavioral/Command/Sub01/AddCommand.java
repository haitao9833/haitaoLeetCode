package GoF.Behavioral.Command.Sub01;

public class AddCommand extends Command {
    private Adder adder;
    private int value;
    public AddCommand() {
        adder = new Adder();
    }
    @Override
    public int execute(int value) {
        this.value = value;
        return adder.add(value);
    }
    @Override
    public int undo() {
        return adder.add(-value);
    }
}
