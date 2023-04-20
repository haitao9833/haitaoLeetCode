package GoF.Behavioral.Observer.NotifySys;

public interface Observer {
    String getName();
    void setName(String name);
    void help();
    void beAttacked(AllyCenter allyCenter);
}
