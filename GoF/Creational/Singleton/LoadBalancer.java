package GoF.Creational.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadBalancer {
    private static LoadBalancer loadBalancer = null;
    private List<String> serverList = null;

    private LoadBalancer() {
        serverList = new ArrayList<>();
    }

    public static LoadBalancer getLoadBalancer() { // 懒汉式
        if (loadBalancer == null) {
            loadBalancer = new LoadBalancer();
        }
        return loadBalancer;
    }

    public void addServer(String server) {
        serverList.add(server);
    }
    public void removeServer(String server) {
        serverList.remove(server);
    }
    public String getServer() {
        Random random = new Random();  // 每次在 serverList 中随机选一台服务器来响应客户端的请求
        return serverList.get(random.nextInt(serverList.size()));
    }
}
