package GoF.Structural.Flyweight;

public abstract class Chessman {
    public abstract String getColor();
    public void display(Coordinates coordinates) {  // 使用时传入外部状态 Coordinates
        System.out.printf("%s 的棋子位于 (%d , %d)\n" , this.getColor() , coordinates.getX() , coordinates.getY());
    }
}
