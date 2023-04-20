package GoF.Creational.Factory;

import GoF.Creational.XMLUtil;

/**
 * 工厂方法模式
 *          产品等级结构 == 工厂等级结构
 *                  抽象工厂 --> 具体工厂
 *                  抽象产品 --> 具体产品
 *                  具体产品与具体工厂一一对应
 *                  增加一个具体产品，只需对应增加一个具体工厂即可，无需像简单工厂模式那样修改工厂类（唯一的）的源代码
 *          优点：用户只需要关心所需产品对应的工厂即可，无需关心创建细节，甚至无需知道所需产品的类名
 *              可以提供一组重载的工厂方法，满足创建需求的多样性
 *              还可以进一步封装产品类的具体业务方法，直接在具体工厂类内封装调用，即直接使用工厂对象即可调用产品对象的方法
 *          缺点：系统扩展，类的数量将成对增加
 * 将产品类的实例化延迟到了工厂子类中
 */
public class Client {
    public static void main(String[] args) {
        for (LoggerFactory factory : XMLUtil.getFactoryBeans() ) {
            Logger logger = factory.createLogger();
            logger.writeLog();
            System.out.println();
        }
    }
}
