package GoF.Behavioral.ChainOfResponsibility;

public class Congress extends Approver {
    public Congress(String name) {
        super(name);
    }
    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.printf("最终解决方法：召开董事会决定是否审批采购单 %2d 金额为 %6.2f ，采购目的为 %s\n"
                    , request.getNumber()
                    , request.getAmount()
                    , request.getPurpose());
    }
}
