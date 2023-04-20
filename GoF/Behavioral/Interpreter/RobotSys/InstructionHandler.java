package GoF.Behavioral.Interpreter.RobotSys;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class InstructionHandler { // 指令处理类，工具类，对输入的指令进行处理
    private AbstractNode res;
    public void handle(String instruction) {
        AbstractNode left , right;
        AbstractNode direction , action , distance;
        ArrayDeque<AbstractNode> stack = new ArrayDeque<>();
        String[] words = instruction.split("\\s+");
        // System.out.println(Arrays.toString(words));
        for (int i = 0 ; i < words.length ; i++) {
            if (words[i].equalsIgnoreCase("and")) {
                i++;
                direction = new DirectionNode(words[i]);
                i++;
                action = new ActionNode(words[i]);
                i++;
                distance = new DistanceNode(words[i]);
                right = new SentenceNode(direction , action , distance);
                left = stack.poll();                     // 先弹出
                stack.push(new AndNode(left , right));   // 再结合压入
            } else {
                direction = new DirectionNode(words[i]);
                i++;
                action = new ActionNode(words[i]);
                i++;
                distance = new DistanceNode(words[i]);
                left = new SentenceNode(direction , action , distance);
                stack.push(left);
            }
        }
        this.res = stack.peek();
    }
    public String output() {
        return this.res.interpret();
    }
}
