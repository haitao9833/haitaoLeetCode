package GoF.Behavioral.ChainOfResponsibility;

public class VicePresident extends Approver {
    public VicePresident(String name) {
        super(name);
    }
    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 100000) {
            System.out.printf("副董事长 %3s 审批采购单 %2d ，金额为 %6.2f ，采购目的为 %s\n"
                    , this.name
                    , request.getNumber()
                    , request.getAmount()
                    , request.getPurpose());
        } else {
            this.successor.processRequest(request);
        }
    }
}
