package GoF.Structural.Proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        InvocationHandler handler = null;
        // 调用处理程序类 handler == 可以理解为代理类 proxy_userDAO & proxy_documentDAO 的类体

        AbstractUserDAO userDAO = new UserDAO();          // 真实主题类 userDAO
        handler = new DAOLogHandler(userDAO);             // 将需要被代理的真实主题类 userDAO 构造注入处理程序类 handler
        AbstractUserDAO proxy_userDAO = (AbstractUserDAO) Proxy.newProxyInstance( // 代理类 proxy_userDAO
                AbstractUserDAO.class.getClassLoader() ,  // 类加载器
                new Class[]{AbstractUserDAO.class} ,      // 真实主题类 userDAO 实现的接口列表 AbstractUserDAO
                handler                                   // 代理类 proxy_userDAO 关联的一个调用处理程序类 handler
        );
        System.out.println("代理类：" + proxy_userDAO.getClass().getName());
        System.out.println(proxy_userDAO.findUserById("33"));
        /**
         * 动态创建 proxy_userDAO 代理 userDAO
         * 且在 proxy_userDAO 调用接口方法 findUserById() 时
         * 将自动转换为调用关联的调用处理程序类 handler 的 invoke() 方法
         * 此时 findUserById() == invoke() 中的 method 参数
         * 即有：代理类.接口方法 == handler.invoke()
         */

        System.out.println();

        AbstractDocumentDAO documentDAO = new DocumentDAO();
        handler = new DAOLogHandler(documentDAO);
        AbstractDocumentDAO proxy_documentDAO = (AbstractDocumentDAO) Proxy.newProxyInstance(
                documentDAO.getClass().getClassLoader() ,
                documentDAO.getClass().getInterfaces() ,  // 简写法 == 真实主题类 DocumentDAO 实现的接口列表 Class[]
                handler
        );
        System.out.println("代理类：" + proxy_documentDAO.getClass().getName());
        proxy_documentDAO.deleteDocumentById("Doc33");
    }
}
