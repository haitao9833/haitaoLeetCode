package GoF.Structural.Decorator;

public class ComponentDecorator extends Component {
    private Component component;                      // 聚合一个抽象构件对象成员
    public ComponentDecorator(Component component) {  // 构造注入
        this.component = component;
    }
    @Override
    public void display() {
        component.display();
    }
}
