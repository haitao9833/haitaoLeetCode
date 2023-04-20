package GoF.XML;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLReader {
    public static void main(String[] args) {
        try {
            // DocumentBuilderFactory --> DocumentBuilder --> Document
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(".\\src\\GoF\\XML\\config.xml"));

            // Document --> NodeList 节点集合
            NodeList bookList = doc.getElementsByTagName("book");
            System.out.println("【一共有 " + bookList.getLength() + " 个 <book>...</book> 标签】");

            // NodeList 节点集合 --> Node 每一个节点
            for (int i = 0 ; i < bookList.getLength() ; i++) {
                System.out.printf("---第 %d 个节点---\n" , i);
                Node book = bookList.item(i);
                getAttrs(book);
                getChildren(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Node 节点 --> NamedNodeMap 属性集合 --> Node 每一个属性
     */
    private static void getAttrs(Node node) {
        NamedNodeMap attrs = node.getAttributes();
        System.out.printf("   共 %d 个属性：\n" , attrs.getLength());
        for (int i = 0 ; i < attrs.getLength() ; i++) {
            Node attr = attrs.item(i);
            System.out.printf("      属性名：%-7s   属性值：%-7s   (nodeType == %d)\n"
                    , attr.getNodeName()
                    , attr.getNodeValue().trim()
                    , attr.getNodeType());
        }
        System.out.println();
    }

    /**
     * Node 节点 --> NodeList 子节点集合 --> Node 子节点
     *      子节点个数：
     *      <A>...
     *          <a>...<a/>
     *          <b>...<b/>
     *      <A/>
     *      共 5 个，分别为：
     *          ... + 空格 + 回车
     *          <a>
     *          空格 + 回车
     *          <b>
     *          空格 + 回车
     *                                      <X>...<X/> == ELEMENT_NODE
     *                      <X>...<X/>.getFirstChild() == TEXT_NODE
     *       <X>...<X/>.getFirstChild().getNodeValue() == ...
     */
    private static void getChildren(Node node) {
        NodeList childList = node.getChildNodes();
        System.out.printf("   共 %d 个子节点：\n" , childList.getLength());
        for (int i = 1 ; i < childList.getLength() ; i += 2) {
            Node childNode = childList.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                System.out.printf("      节点名：%-7s   节点值：%-10s   (nodeType == %d) (nodeTypeChild == %d) (children = %d)\n"
                        , childNode.getNodeName()
                        , childNode.getFirstChild().getNodeValue().trim()
                        , childNode.getNodeType()
                        , childNode.getFirstChild().getNodeType()
                        , childNode.getChildNodes().getLength());
            }
        }
        System.out.println();
    }

    /**
     * Node 节点 --> Element + attrName 属性名 --> attrVal 属性值
     */
    private static void getAttrKnow(Node node , String attrName) {
        Element elm = (Element) node;
        String attrVal = elm.getAttribute(attrName);
        System.out.println(attrName + "=" + attrVal);
    }
}
