package GoF.Behavioral.Iterator.ListSys;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractObjectList {
    protected List<Object> objectList = new ArrayList<>();
    public AbstractObjectList(List<Object> objectList) {
        this.objectList = objectList;
    }
    public void addObject(Object object) {
        objectList.add(object);
    }
    public void removeObject(Object object) {
        objectList.remove(object);
    }
    public List<Object> getObjects() {
        return this.objectList;
    }
    public abstract AbstractIterator createIterator();
}
