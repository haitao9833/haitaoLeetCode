package GoF.Structural.Proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOLogHandler implements InvocationHandler { // 代理类的调用处理程序类
    private Calendar calendar;
    private Object object;
    public DAOLogHandler() {}
    public DAOLogHandler(Object object) {  // 需要被代理的真实主题类，构造注入
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy , Method method , Object[] args) throws Throwable {
        beforeInvoke();
        System.out.println("代理类：" + proxy.getClass().getName());
        System.out.println("真实主题类：" + this.object.getClass().getName());
        System.out.println("代理的方法：" + this.object.getClass().getName() + "." +method.getName());
        System.out.println("代理的方法的参数：" + Arrays.toString(args));
        Object res = method.invoke(object , args);   // == object.method(args)
        afterInvoker();                              // == 用真实主题类实例 object 调用 method(args) 方法
        return res;
    }
    public void beforeInvoke() {
        System.out.println("---方法调用开始---");
        calendar = new GregorianCalendar();
        System.out.printf("调用时间：%d:%d:%d\n"
                , calendar.get(Calendar.HOUR_OF_DAY)
                , calendar.get(Calendar.MINUTE)
                , calendar.get(Calendar.SECOND));
    }
    public void afterInvoker() {
        System.out.println("---方法调用结束---");
    }
}
