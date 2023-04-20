package GoF.Behavioral.Mediator.CRMSys;

public class List extends Component {
    @Override
    public void update() {
        System.out.println("列表框增加一项：A");
    }
    public void select() {
        System.out.println("列表框选中一项：B");
    }
}
