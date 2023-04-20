package GoF.Behavioral.Interpreter.RobotSys;

public class SentenceNode extends AbstractNode {  // 非终结符，关联了三个终结符
    private AbstractNode direction;
    private AbstractNode action;
    private AbstractNode distance;
    public SentenceNode(AbstractNode direction , AbstractNode action , AbstractNode distance) {
        this.direction = direction;
        this.action = action;
        this.distance = distance;
    }
    @Override
    public String interpret() {
        return direction.interpret() + action.interpret() + distance.interpret() + "个单位";
    }
}
