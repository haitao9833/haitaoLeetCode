package GoF.Behavioral.Strategy.DiscountSys;

public class ChildrenDiscount implements Discount {
    private final double cut = 10;
    @Override
    public double calculate(double price) {
        System.out.print("儿童票：");
        if (price >= 20) {
            return price - cut;
        }
        return price;
    }
}
