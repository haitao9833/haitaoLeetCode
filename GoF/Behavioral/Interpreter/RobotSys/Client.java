package GoF.Behavioral.Interpreter.RobotSys;

/**
 * 解释器模式：
 *          本质 ==
 *          角色：
 *              1、AbstractExpression      抽象表达式类
 *              2、TerminalExpression      终结符表达式
 *              3、NonterminalExpression   非终结符表达式   可以关联终结符表达式和非终结符表达式，以组成更大的子表达式
 *              4、Context                 环境类          存储一些公共的全局信息，通常也临时存储需要解释的语句
 */

public class Client {
    public static void main(String[] args) {
        String instruction = "down move  5 and   up  run 10 and    right    move    33";
        InstructionHandler handler = new InstructionHandler();
        handler.handle(instruction);
        System.out.println(handler.output());
    }
}
