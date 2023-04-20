package GoF.Behavioral.Iterator.ListSys;

import java.util.List;

public class ProductList extends AbstractObjectList {
    public ProductList(List<Object> objectList) {
        super(objectList);
    }
    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}
