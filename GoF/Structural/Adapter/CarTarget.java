package GoF.Structural.Adapter;

public abstract class CarTarget {
    public void move() {
        System.out.println("移动！");
    }

    public abstract void phonate();   // 复用 PoliceSound 代码
    public abstract void twinkle();   // 复用 PoliceLamp  代码
}
