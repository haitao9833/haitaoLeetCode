package GoF.Behavioral.Observer.NotifySys;

/**
 * 观察者模式 == 订阅模式
 */

public class Client {
    public static void main(String[] args) {
        AllyCenter allyCenter = new ConcreteAllyCenter("XXX");
        Observer player1 = new Player("A");
        Observer player2 = new Player("B");
        Observer player3 = new Player("C");
        Observer player4 = new Player("D");
        allyCenter.join(player1);
        allyCenter.join(player2);
        allyCenter.join(player3);
        allyCenter.join(player4);
        System.out.println();
        player3.beAttacked(allyCenter);
    }
}
