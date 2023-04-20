package GoF.Behavioral.Observer.NotifySys;

public class ConcreteAllyCenter extends AllyCenter {
    public ConcreteAllyCenter(String allyName) {
        this.allyName = allyName;
        System.out.println(allyName + " 联盟战队组建成功");
    }
    @Override
    public void notifyObserver(String name) {
        for (Observer observer : players) {
            if (!observer.getName().equalsIgnoreCase(name)) {
                observer.help();
            }
        }
    }
}
