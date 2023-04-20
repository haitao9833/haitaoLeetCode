package GoF.Structural.Proxy.dynamicProxy;

import java.util.regex.Pattern;

public class UserDAO implements AbstractUserDAO {
    @Override
    public Boolean findUserById(String userId) {
        if (Pattern.matches("\\d+" , userId)) {
            System.out.println("查询 ID 为 " + userId + " 的用户信息成功！");
            return true;
        } else {
            System.out.println("查询 ID 为 " + userId + " 的用户信息失败，不存在该用户！");
            return false;
        }
    }
}
