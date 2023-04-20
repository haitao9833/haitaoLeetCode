package GoF.Behavioral.Memento.RestoreSys;

public class ChessmanMemento {
    private String label;
    private int x;
    private int y;
    public ChessmanMemento(String label , int x , int y) {
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
}
