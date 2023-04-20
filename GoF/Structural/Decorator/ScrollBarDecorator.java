package GoF.Structural.Decorator;

public class ScrollBarDecorator extends ComponentDecorator {
    public ScrollBarDecorator(Component component) {
        super(component);
    }
    @Override
    public void display() {
        this.setScrollBar();
        super.display();                  // 调用抽象装饰类中的方法
    }
    private void setScrollBar() {
        System.out.print("增加滚动条：");   // 装饰类新增方法
    }
}
