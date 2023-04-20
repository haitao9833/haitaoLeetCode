package GoF.Behavioral.Iterator.ListSys;

import java.util.List;

public class ProductIterator implements AbstractIterator {
    private List<Object> products;     // 关联一个具体聚合对象的成员变量
    private int cursor1;               // 游标，正向遍历
    private int cursor2;               // 游标，逆向遍历

    public ProductIterator(ProductList productList) {
        this.products = productList.getObjects();
        cursor1 = 0;                             // 初始化为有效值，首部元素
        cursor2 = products.size() - 1;           // 初始化为有效值，尾部元素
    }

    // isLast 判断 --> getNextItem 取值 --> next 移动游标
    @Override
    public boolean isLast() {
        return cursor1 == products.size();
    }
    @Override
    public Object getNextItem() {
        return products.get(cursor1);
    }
    @Override
    public void next() {
        if (cursor1 < products.size()) {
            cursor1 ++;
        }
    }

    // isFirst 判断 --> getPreviousItem 取值 --> previous 移动游标
    @Override
    public boolean isFirst() {
        return cursor2 == -1;
    }
    @Override
    public Object getPreviousItem() {
        return products.get(cursor2);
    }
    @Override
    public void previous() {
        if (cursor2 > -1) {
            cursor2--;
        }
    }
}
