package GoF.Behavioral.Mediator.CRMSys;

public class ComboBox extends Component {
    @Override
    public void update() {
        System.out.println("组合框增加一项：A");
    }
    public void select() {
        System.out.println("组合框选中一项：B");
    }
}
