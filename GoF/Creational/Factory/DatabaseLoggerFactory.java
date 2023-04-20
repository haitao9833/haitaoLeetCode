package GoF.Creational.Factory;

public class DatabaseLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        // 连接数据库等操作
        Logger logger = new DatabaseLogger();
        return logger;
    }
}
