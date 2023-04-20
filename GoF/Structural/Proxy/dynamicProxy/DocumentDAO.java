package GoF.Structural.Proxy.dynamicProxy;

import java.util.regex.Pattern;

public class DocumentDAO implements AbstractDocumentDAO {
    @Override
    public Boolean deleteDocumentById(String documentId) {
        if (Pattern.matches("Doc\\d+" , documentId)) {
            System.out.println("删除 ID 为 " + documentId + " 的文档成功！");
            return true;
        } else {
            System.out.println("删除 ID 为 " + documentId + " 的文档失败，不存在该文档！");
            return false;
        }
    }
}
