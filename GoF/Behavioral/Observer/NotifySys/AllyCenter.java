package GoF.Behavioral.Observer.NotifySys;

import java.util.ArrayList;

public abstract class AllyCenter {
    protected String allyName;
    protected ArrayList<Observer> players = new ArrayList<>();
    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }
    public String getAllyName() {
        return allyName;
    }
    // 订阅
    public void join(Observer observer) {
        players.add(observer);
        System.out.printf("%3s 加入 %3s 联盟战队\n" , observer.getName() , this.allyName);
    }
    // 取消订阅
    public void quit(Observer observer) {
        players.remove(observer);
        System.out.printf("%3s 退出 %3s 联盟战队\n" , observer.getName() , this.allyName);
    }
    // 抽象通知方法
    public abstract void notifyObserver(String name);
}
