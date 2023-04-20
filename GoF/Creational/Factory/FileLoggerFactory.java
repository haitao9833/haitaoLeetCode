package GoF.Creational.Factory;

public class FileLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        // 创建文件等操作
        Logger logger = new FileLogger();
        return logger;
    }
}
