package GoF.Structural.Decorator;

public class BlackBorderDecorator extends ComponentDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }
    @Override
    public void display() {
        this.setBlackBorder();
        super.display();                       // 调用抽象装饰类中的方法
    }
    private void setBlackBorder() {
        System.out.print("增加黑色边框：");      // 装饰类新增方法
    }
}
