package GoF.Structural.Adapter;

import GoF.Structural.XMLUtil;

/**
 * 类结构模式：继承 + 实现
 * 对象结构模式：关联
 *
 * 适配器模式：
 *          角色：
 *              1、Target 定义客户实际所需的接口
 *              2、Adapter 协调 Target 和 Adaptee 之间的不兼容，对 Target 和 Adaptee 进行适配
 *                         类适配器模式中：
 *                                     实现 Target ，继承 Adaptee
 *                                     Target 只能为接口
 *                                     且只能适配（继承）一个 Adaptee
 *                         对象适配器模式中：
 *                                       继承 Target ，关联 Adaptee
 *                                       使用频率更高，Target 可以为抽象类或具体类，可以适配（关联）多个 Adaptee
 *              3、Adaptee 定义了客户希望使用的接口，但该接口需要被适配
 *          优点：将现有接口转化为客户类所需要的接口，实现了对现有类的复用
 *               且无需修改 Target（客户类） 和 Adaptee（现有类） 的源代码
 *               由适配器 Adapter 封装 Target 中的接口对 Adaptee 中相应接口的调用
 *               解耦了 Target 和 Adaptee ，灵活性和扩展性都非常好
 *               关联关系中，Adapter 可以适配多个 Adaptee 及其子类
 *          双向适配器：
 *                   Target 可以通过 Adapter 调用 Adaptee
 *                   Adaptee 可以通过 Adapter 调用 Target
 * 缺省适配器模式：
 *             角色：
 *                 1、ServiceInterface 适配者接口            声明了大量方法
 *                 2、AbstractServiceClass 缺省适配器类      实现了适配者接口，用空方法形式实现了所有方法
 *                                                         通常定义为抽象类，因为对其进行实例化没有任何意义
 *                 3、ConcreteServiceClass 具体业务类        继承缺省适配器类，根据需要有选择性地实现覆盖父类中的空方法
 *             若无缺省适配器类，具体业务类不得不实现适配者接口，将不得不实现接口中的所有方法，即便无需使用
 */

public class Client {
    public static void main(String[] args) {
        for (CarTarget car : XMLUtil.getAdapterBean()) {
            // System.out.println(car.getClass().getName());
            car.move();
            car.phonate();
            car.twinkle();
        }
    }
}
