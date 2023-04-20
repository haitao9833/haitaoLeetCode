package GoF.Behavioral.Memento.RestoreSys;

/**
 * 备忘录模式：
 *          角色：
 *              1、Originator  原发器      需要保存内部状态的类，仅原发器可以调用备忘录的构造函数
 *              2、Memento     备忘录      仅供原发器和负责人使用
 *              3、Caretaker   负责人      仅仅是存储备忘录对象
 *          1
 */

public class Client {

    private static int index = -1;   // 索引指向最新的备忘录对象
    private static MementoCaretaker mementoCaretaker = new MementoCaretaker();

    public static void main(String[] args) {
        Chessman chessman = new Chessman("车" , 1 , 1);
        play(chessman);
        chessman.setX(3);
        play(chessman);
        chessman.setY(3);
        play(chessman);
        chessman.setLabel("将");
        play(chessman);
        System.out.println();
        undo(chessman);
        undo(chessman);
        undo(chessman);
        System.out.println();
        redo(chessman);
        redo(chessman);
        redo(chessman);
    }

    // 下棋
    private static void play(Chessman chessman) {
        mementoCaretaker.setMemento(chessman.save());
        index++;
        chessman.display();
    }
    // 悔棋
    private static void undo(Chessman chessman) {
        index--;
        chessman.restore(mementoCaretaker.getMemento(index));
        chessman.display();
    }
    // 撤销悔棋
    private static void redo(Chessman chessman) {
        index++;
        chessman.restore(mementoCaretaker.getMemento(index));
        chessman.display();
    }
}
