package GoF.Behavioral.Strategy.DiscountSys;

public class VIPDiscount implements Discount {
    private final double rate = 0.5;
    @Override
    public double calculate(double price) {
        System.out.print("VIP票：");
        return price * rate;
    }
}
