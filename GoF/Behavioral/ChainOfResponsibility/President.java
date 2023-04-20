package GoF.Behavioral.ChainOfResponsibility;

public class President extends Approver {
    public President(String name) {
        super(name);
    }
    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 500000) {
            System.out.printf("董事长 %3s 审批采购单 %2d 金额为 %6.2f ，采购目的为 %s\n"
                    , this.name
                    , request.getNumber()
                    , request.getAmount()
                    , request.getPurpose());
        } else {
            this.successor.processRequest(request);
        }
    }
}
