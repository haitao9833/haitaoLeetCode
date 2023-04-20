package GoF.Creational.Builder;

import GoF.Creational.XMLUtil;

/**
 * 构建者模式
 *         一个复杂对象由多个组成部分的对象构成
 *         客户端不关心组成部分对象的构建，也无需知道其中的装配方式，只需要知道所需构建者的类型即可
 *         角色
 *            1、抽象构建者     一般包含 buildPartX() 方法创建组成部分对象 + gerResult() 方法返回配置好的复杂对象
 *            2、具体构建者
 *            3、产品
 *            4、指挥者         内部聚合一个抽象构建者，包含 construct() 方法安排复杂对象各个组成部分的建造次序
 *                             还可以调用构建者中提供的钩子方法，以更精细地控制构建过程，控制是否需要执行某个 buildPartX() 方法
 *                             创建产品类对象的过程独立于该产品类
 *                             1、构造参数注入
 *                             2、Setter 方法
 *                             3、方法参数注入
 *         简化：取消指挥者，直接在抽象构建者中创建 construct() 方法
 *         缺点：构建的产品之间需要具有较多的共同点
 *              如果产品之间差异性较大，则不适合构建者模式
 */

public class Client {
    public static void main(String[] args) {
        for (ActorBuilder builder : XMLUtil.getBuilderBeans()) {
            Director director = new Director();
            Actor actor = director.construct(builder);
            System.out.printf("%3s  %3s  %3s  %3s  %3s\n"
                    , actor.getType()
                    , actor.getSex()
                    , actor.getFace()
                    , actor.getCostume()
                    , actor.getHairstyle());
        }
    }
}
