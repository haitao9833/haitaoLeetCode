package GoF.Behavioral.Observer.NotifySys;

public class Player implements Observer {
    private String name;
    public Player(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void help() {
        System.out.println(this.name + " 已收到通知，将提供帮助");
    }
    @Override
    public void beAttacked(AllyCenter allyCenter) {
        System.out.println(this.name + " 受到攻击，已发送通知");
        allyCenter.notifyObserver(this.name);
    }
}
