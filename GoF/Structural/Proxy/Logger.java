package GoF.Structural.Proxy;

public class Logger {
    public void log(String userId) {
        System.out.println("更新数据库，已记录用户 " + userId + " 的查询日志");
    }
}
