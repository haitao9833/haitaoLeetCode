package GoF.Structural.Flyweight;

/**
 * 享元模式：
 *        以共享的方式支持大量细粒度对象的重用
 *        内部状态：
 *               存储在享元对象内部，不变化，可共享，例如字符 "李慧莹"
 *               通常将内部状态作为成员变量，保证内部状态的一致性
 *        外部状态：
 *               使用时由客户端注入享元对象中，可变化，不共享，例如字符 "李慧莹" 的字体颜色、大小
 *               通过向从享元池中取出的对象注入不同的外部状态，可以得到一系列相似的对象
 *               通常将外部状态作为方法参数传入，在使用方法时传入，不保存在享元对象中
 *        角色：
 *            1、Flyweight                  抽象享元类        声明访问内部状态、设置外部状态的方法
 *            2、ConcreteFlyweight          具体享元类        通常可以结合单例模式
 *            3、UnsharedConcreteFlyweight  非共享具体享元类   不共享，直接创建
 *            4、FlyweightFactory           享元工厂          享元池，创建并管理享元对象，针对抽象享元类编程
 *        12
 */

public class Client {
    public static void main(String[] args) {
        ChessmanFactory factory = ChessmanFactory.getInstance();

        Chessman black01 = factory.getChessman("b");
        Chessman black02 = factory.getChessman("b");
        System.out.println(black01 == black02);
        black01.display(new Coordinates(1 , 2));
        black02.display(new Coordinates(3 , 4));
        System.out.println(black01 == black02);

        System.out.println();

        Chessman white01 = factory.getChessman("w");
        Chessman white02 = factory.getChessman("w");
        System.out.println(white01 == white02);
        white01.display(new Coordinates(5 , 6));
        white02.display(new Coordinates(7 , 8));
        System.out.println(white01 == white02);
    }
}
