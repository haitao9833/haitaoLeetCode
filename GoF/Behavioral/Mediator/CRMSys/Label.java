package GoF.Behavioral.Mediator.CRMSys;

public class Label extends Component {
    @Override
    public void update() {
        System.out.println("文本标签内容改变，客户数量加 1");
    }
}
