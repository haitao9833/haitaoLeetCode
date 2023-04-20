package GoF.Structural.Proxy;

import GoF.Structural.XMLUtil;

/**
 * 代理模式：
 *        客户端 --> 代理类 --> 目标对象
 *        去掉客户不能看到的内容，增添客户需要的额外新服务
 *        角色：
 *            1、Subject     抽象主题   代理主题与真实主题的共同接口，任何使用真实主题的地方都可以使用代理主题，客户端针对抽象编程
 *            2、Proxy       代理主题   关联一个真实主题的成员变量，创建、操作、删除真实主题
 *            3、RealSubject 真实主题
 *        动态代理：
 *               运行时根据实际需要动态创建代理类，让同一个代理类能够代理多个不同的真实主题类、不同的方法
 */

public class Client {
    public static void main(String[] args) {
        for (Searcher searcher : XMLUtil.getProxyBeans()) {
            System.out.println(searcher.doSearch("12345." , "."));
            System.out.println();
            System.out.println(searcher.doSearch("123456" , "6"));
            System.out.println();
            System.out.println(searcher.doSearch("12345a" , "a"));
        }
    }
}