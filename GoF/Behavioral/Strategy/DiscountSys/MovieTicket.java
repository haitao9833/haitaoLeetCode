package GoF.Behavioral.Strategy.DiscountSys;

public class MovieTicket {
    private double price;
    private Discount discount;
    public double getPrice() {
        return discount.calculate(price);
    }   // 打折扣
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }  // Setter 注入
}
