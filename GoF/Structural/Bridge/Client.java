package GoF.Structural.Bridge;

import GoF.Structural.XMLUtil;

/**
 * 桥接模式：
 *        抽象部分与实现部分解耦，动态关联
 *        识别出一个类所具有的两个独立变化的维度，将它们设计为两个独立的继承等级结构
 *        其中关系最密切的维度设计为抽象类，另一维度设计为实现类接口
 *        并建立抽象关联 == Abstraction 聚合一个 Implementor 成员变量
 *        对某一方进行扩展不影响另一方，使得两者都能够独立变化
 *        角色：
 *            1、Abstraction 抽象类 + RefinedAbstraction 扩充抽象类 == 一维的继承等级结构
 *            2、Implementor 实现类接口 + ConcreteImplementor 具体实现类 == 另一维的继承等级结构
 *        和适配器模式的搭配：
 *                        适配器模式通常用于将第三方应用接口集成到现有系统中
 *                        桥接模式通过类继承和接口实现方式对现有系统进行扩展
 */

public class Client {
    public static void main(String[] args) {
        for (Image image : XMLUtil.getImageBeans()) {
            for (ImageImp imp : XMLUtil.getImageImpBeans()) {
                image.setImageImp(imp);
                image.parseFile("恐怖黎明");
                System.out.println();
            }
        }
    }
}
