package GoF.Structural.Flyweight;

import java.util.HashMap;

public class ChessmanFactory {
    private static final ChessmanFactory factory = new ChessmanFactory();  // 单例模式，确保工厂对象唯一性
    private static HashMap<String , Chessman> pool;                        // 简单工厂模式

    private ChessmanFactory() {
        pool = new HashMap<>();
        pool.put("b" , new BlackChessman());
        pool.put("w" , new WhiteChessman());
    }

    public static ChessmanFactory getInstance() {
        return factory;
    }
    public Chessman getChessman(String color) {
        return pool.get(color);
    }
}
