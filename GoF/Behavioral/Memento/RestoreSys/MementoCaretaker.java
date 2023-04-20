package GoF.Behavioral.Memento.RestoreSys;

import java.util.ArrayList;

public class MementoCaretaker {
    private ArrayList<ChessmanMemento> mementos = new ArrayList<>();
    // 提取备忘录对象
    public ChessmanMemento getMemento(int i) {
        return mementos.get(i);
    }
    // 存储备忘录对象
    public void setMemento(ChessmanMemento memento) {
        mementos.add(memento);
    }
}
