package GoF.Behavioral.Strategy.DiscountSys;

public class StudentDiscount implements Discount {
    private final double rate = 0.8;
    @Override
    public double calculate(double price) {
        System.out.print("学生票：");
        return price * rate;
    }
}
