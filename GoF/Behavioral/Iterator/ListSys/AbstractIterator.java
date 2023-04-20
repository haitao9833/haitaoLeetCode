package GoF.Behavioral.Iterator.ListSys;

public interface AbstractIterator {
    void next();
    void previous();
    boolean isFirst();
    boolean isLast();
    Object getNextItem();
    Object getPreviousItem();
}
