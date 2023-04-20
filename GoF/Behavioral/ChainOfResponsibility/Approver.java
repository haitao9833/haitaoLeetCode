package GoF.Behavioral.ChainOfResponsibility;

public abstract class Approver {
    protected Approver successor;                  // 关联一个职责下家
    protected String name;                         // protected 子类能直接访问
    public Approver(String name) {
        this.name = name;
    }
    public void setSuccessor(Approver successor) {  // 设置下家
        this.successor = successor;
    }
    public abstract void processRequest(PurchaseRequest request);
}
