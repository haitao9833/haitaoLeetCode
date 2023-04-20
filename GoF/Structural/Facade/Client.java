package GoF.Structural.Facade;

import GoF.Structural.XMLUtil;

/**
 * 外观模式：
 *        软件系统中的服务员，使客户免于与复杂的子系统内部直接交互，为复杂的子系统提供一个高度抽象的使用入口
 *        角色：
 *            1、AbstractionFacade   抽象外观类      客户端面向抽象编程，定义抽象方法由具体外观类实现
 *            2、ConcreteFacade      具体外观类      关联子系统中的类，可以自定义想要关联的子系统，利于扩展
 *            3、SubSystem           复杂的子系统
 */

public class Client {
    public static void main(String[] args) {
        for (AbstractionEncryptFacade facade : XMLUtil.getFacadeBeans()) {
            facade.fileEncrypt("..." , "...");
            System.out.println();
        }
    }
}
