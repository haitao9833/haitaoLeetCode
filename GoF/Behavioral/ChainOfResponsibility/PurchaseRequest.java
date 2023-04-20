package GoF.Behavioral.ChainOfResponsibility;

public class PurchaseRequest {   // 自定义请求类
    private double amount;
    private int number;
    private String purpose;
    public PurchaseRequest(double amount , int number , String purpose) {
        this.amount = amount;
        this.number = number;
        this.purpose = purpose;
    }
    public double getAmount() {
        return amount;
    }
    public int getNumber() {
        return number;
    }
    public String getPurpose() {
        return purpose;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
