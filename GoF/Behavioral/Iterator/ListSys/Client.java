package GoF.Behavioral.Iterator.ListSys;

import java.util.ArrayList;

/**
 * 迭代器模式：遥控器 --> 电视机
 */

public class Client {
    public static void main(String[] args) {
        AbstractObjectList list = new ProductList(new ArrayList<>(){
            {
                add("A");
                add("B");
                add("C");
            }
        });
        AbstractIterator iterator = list.createIterator();
        System.out.print("正向遍历：");
        while (!iterator.isLast()) {
            System.out.print(iterator.getNextItem() + " ");
            iterator.next();
        }
        System.out.println();
        System.out.print("逆向遍历：");
        while (!iterator.isFirst()) {
            System.out.print(iterator.getPreviousItem() + " ");
            iterator.previous();
        }
    }
}
