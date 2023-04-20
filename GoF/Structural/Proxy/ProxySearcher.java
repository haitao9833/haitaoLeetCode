package GoF.Structural.Proxy;

public class ProxySearcher implements Searcher {
    private RealSearcher searcher = new RealSearcher();    // 关联一个真实主题的成员变量
    private AccessValidator validator;
    private Logger logger;

    public boolean validate(String userId) {
        validator = new AccessValidator();
        return validator.validate(userId);
    }
    public void log(String userId) {
        logger = new Logger();
        logger.log(userId);
    }

    @Override
    public String doSearch(String userId, String keyword) {
        if (this.validate(userId)) {
            String res = searcher.doSearch(userId , keyword);
            this.log(userId);
            return res;
        } else {
            return null;
        }
    }
}
