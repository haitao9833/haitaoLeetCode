package GoF.Structural.Decorator;

/**
 * 装饰模式：
 *        角色：
 *            1、Component         抽象构件      具体构件和抽象装饰类的共同父类，使得客户可以一致处理未被装饰的对象和装饰后的对象
 *            2、ConcreteComponent 具体构件      实现抽象构件中的方法
 *            3、Decorator         抽象装饰类    核心设计 == 聚合一个抽象构件对象，即可以调用具体构建的方法，一般使用构造函数注入
 *            4、ConcreteDecorator 具体装饰类    实现、调用抽象装饰类中的方法，新增方法
 *        优点：替代继承，动态扩展对象功能
 *             多次装饰，且装饰顺序不同可以排列组合出不同的行为
 *             具体构件类和具体装饰类独立变化
 *        缺点：产生很多小对象，占用系统资源，影响性能
 *             排错难
 *        透明：
 *            客户端完全针对抽象编程，一致处理装饰前对象和装饰后对象，即一致处理具体构件和具体装饰类，都当作抽象构件类型处理
 *            具体装饰类的 operation() 方法需要覆盖重写抽象装饰类的 operation() 方法，并于其中调用自己新增的方法
 *            客户端无法单独调用这些新增方法，因为在抽象装饰类中未声明定义
 *        不透明：
 *              客户端要想单独调用具体装饰类中的新增方法
 *              则需要使用具体装饰类声明定义所需装饰类，无法使用抽象构件类型声明定义该装饰类
 *              客户端需有区别地对待装饰之前和装饰之后的对象
 */

public class Client {
    public static void main(String[] args) {
        Component component = new BlackBorderDecorator(new ScrollBarDecorator(new ListBox()));
        component.display();   // 多级装饰
    }
}
