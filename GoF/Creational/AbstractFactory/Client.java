package GoF.Creational.AbstractFactory;

import GoF.Creational.XMLUtil;

/**
 * 抽象工厂模式
 *           工厂方法模式 == 处理一个产品等级结构（产品等级结构 == 产品继承结构 == 有同一个父类产品的一系列子产品）
 *           抽象工厂模式 == 处理一个产品族，族内的每一个产品都属于不同的产品等级结构，但又有一定的相关和相互依赖性
 *           优点：
 *               增加产品族很容易
 *               将一族相关的、一起工作的类的创建活动封装在一个工厂之中
 *               保证客户端始终只使用同一个产品族中的产品对象
 *           缺点：
 *               增加产品等级结构很麻烦
 *               需要修改抽象工厂增加新的产品创建方法，且在所有的具体工厂中实现
 *           需要在考虑之初，就设计好一个包含全部产品的产品族，后续则不再增加也不再删除，产品等级结构稳定
 */

public class Client {
    public static void main(String[] args) {
        for (SkinFactory factory : XMLUtil.getAbstractFactoryBeans()) {
            Button button = factory.createButton();
            TextField textField = factory.createTextField();
            ComboBox comboBox = factory.createComboBox();
            button.display();
            textField.display();
            comboBox.display();
            System.out.println();
        }
    }
}
