package GoF.Behavioral.Command.Sub01;

public class Adder {
    private int res = 0;
    public int add(int value) {
        res += value;
        return res;
    }
}
