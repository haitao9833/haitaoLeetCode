package GoF.Behavioral.Memento.RestoreSys;

public class Chessman {
    private String label;
    private int x;
    private int y;
    public Chessman(String label , int x , int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getLabel() {
        return label;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void display() {
        System.out.printf("当前状态为：%2s (%2d , %2d)\n" , this.label , this.x , this.y);
    }
    // 保存状态
    public ChessmanMemento save() {
        return new ChessmanMemento(this.label , this.x , this.y);
    }
    // 恢复状态
    public void restore(ChessmanMemento memento) {
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }
}
