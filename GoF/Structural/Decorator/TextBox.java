package GoF.Structural.Decorator;

public class TextBox extends Component {
    @Override
    public void display() {
        System.out.println("显式文本框！");
    }
}
