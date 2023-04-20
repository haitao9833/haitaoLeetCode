package GoF.Behavioral.Strategy.DiscountSys;

import GoF.Behavioral.XMLUtil;

/**
 * 策略模式：
 */

public class Client {
    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket();
        double originalPrice = 60;
        double currentPrice;
        for (Discount discount : XMLUtil.getStrategyBeans()) {
            movieTicket.setPrice(originalPrice);
            movieTicket.setDiscount(discount);        // 设置策略
            currentPrice = movieTicket.getPrice();
            System.out.println(currentPrice);
        }
    }
}
