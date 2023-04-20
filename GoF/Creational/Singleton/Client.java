package GoF.Creational.Singleton;

/**
 * 单例模式
 *        该类只有一个实例，且由类自身负责创建和保存该唯一实例
 *             private static 唯一实例
 *             private 构造函数
 *             public static 静态方法访问唯一实例
 *        饿汉式
 *             private static 唯一实例 == new 声明时即定义，类加载时唯一静态单例就会被创建
 *        懒汉式
 *             private static 唯一实例 == null;
 *             getInstance() 第一次调用该方法时才创建唯一静态单例，类加载时不会自行实例化
 *             又称为延迟加载 Lazy Load ，即需要时才创建实例
 *             双重检查锁定????????
 *        优点：对于需要频繁创建和销毁的对象，节省系统资源，提高系统性能
 *             可以扩展为多例类
 *        缺点：职责过重，将对象的创建和功能使用耦合在了一起
 */

public class Client {
    public static void main(String[] args) {
        LoadBalancer loadBalancer = LoadBalancer.getLoadBalancer();
        LoadBalancer loadBalancer01 = LoadBalancer.getLoadBalancer();
        LoadBalancer loadBalancer02 = LoadBalancer.getLoadBalancer();
        LoadBalancer loadBalancer03 = LoadBalancer.getLoadBalancer();
        if (loadBalancer == loadBalancer01 && loadBalancer01 == loadBalancer02 && loadBalancer02 == loadBalancer03) {
            System.out.println("服务器负载均衡器具有唯一性");
        }

        loadBalancer.addServer("服务器 1");
        loadBalancer.addServer("服务器 2");
        loadBalancer.addServer("服务器 3");
        loadBalancer.addServer("服务器 4");

        for (int i = 0; i < 10; i++) {
            System.out.println("客户端请求分发至：" + loadBalancer.getServer());
        }
    }
}
