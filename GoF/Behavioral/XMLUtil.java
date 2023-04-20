package GoF.Behavioral;

import GoF.Behavioral.Command.Command;
import GoF.Behavioral.Strategy.DiscountSys.Discount;
import GoF.Behavioral.TemplateMethod.AccountSys.Account;
import GoF.Behavioral.Visitor.DepartmentSys.Department;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLUtil {
    private static Document doc;
    static {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(new File(".\\src\\GoF\\Behavioral\\config.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 泛型编程
     */
    public static <T> T getBeans(String label) {
        NodeList nodeList = doc.getElementsByTagName("CommandClass");
        T res = null;
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res = (T) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * Command
     */
    public static Command[] getCommandBeans() {
        NodeList nodeList = doc.getElementsByTagName("CommandClass");
        Command[] res = new Command[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res[i] = (Command) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * Strategy
     */
    public static Discount[] getStrategyBeans() {
        NodeList nodeList = doc.getElementsByTagName("StrategyClass");
        Discount[] res = new Discount[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res[i] = (Discount) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * Template Method
     */
    public static Account[] getAccountBeans() {
        NodeList nodeList = doc.getElementsByTagName("TemplateMethod");
        Account[] res = new Account[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res[i] = (Account) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * Visitor
     */
    public static Department[] getVisitorBeans() {
        NodeList nodeList = doc.getElementsByTagName("VisitorClass");
        Department[] res = new Department[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res[i] = (Department) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
