package GoF.Structural.Proxy;

import java.util.regex.Pattern;

public class AccessValidator {
    public boolean validate(String userId) {
        if (Pattern.matches("\\d+" , userId)) {
            System.out.println(userId + " 用户登录成功！");
            return true;
        } else {
            System.out.println("登陆失败，无此 " + userId + " 用户");
            return false;
        }
    }
}
