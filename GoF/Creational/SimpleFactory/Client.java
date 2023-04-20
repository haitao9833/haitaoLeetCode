package GoF.Creational.SimpleFactory;

import GoF.Creational.XMLUtil;

/**
 * 创建型模式 == 对象的创建和使用分离
 *
 * 简单工厂模式
 *           角色
 *              1、静态工厂      返回抽象产品类型
 *              2、抽象产品      具体产品的公共代码 + 供不同具体产品实现的抽象方法
 *              3、具体产品      具有公共的父类
 *           优点：封装创建对象的逻辑和细节，可由 config.xml 指定参数控制创建过程与创建结果
 *           简化：直接在抽象产品中提供静态的工厂方法
 *           缺点：一旦具体产品种类过多，工厂类扩展将比较复杂
 *                添加新的具体产品，需要修改工厂类的代码
 */

public class Client {
    public static void main(String[] args) {
        for (String type : XMLUtil.getChartTypes()) {
            Chart chart = ChartFactory.getChartByMap(type);
            chart.display();
            System.out.println();
        }
    }
}
