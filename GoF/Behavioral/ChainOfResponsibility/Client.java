package GoF.Behavioral.ChainOfResponsibility;

/**
 * 职责链模式：
 *          将一个请求的发送与接收解耦，使得多个对象都有机会处理这个请求
 *          角色：
 *              1、Handler          抽象处理者，关联一个自身类型的成员变量，作为处理的下家
 *              2、ConcreteHandle   具体处理者，处理能处理的，不能处理的转发给下家
 *          职责链的创建过程可以由客户端自由定义
 *          添加新的具体处理者也很方便
 */

public class Client {
    public static void main(String[] args) {
        Approver director = new Director("唐芊蔚");
        Approver vicePresident = new VicePresident("李佳蓉");
        Approver president = new President("李慧莹");
        Approver congress = new Congress("蒋海涛");

        director.setSuccessor(vicePresident);
        vicePresident.setSuccessor(president);
        president.setSuccessor(congress);

        director.processRequest(new PurchaseRequest(30000 ,1 , "买书"));
        director.processRequest(new PurchaseRequest(80000 ,2 , "酒吧"));
        director.processRequest(new PurchaseRequest(400000 ,3 , "买车"));
        director.processRequest(new PurchaseRequest(900000 ,4 , "买房"));
    }
}
