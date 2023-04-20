package GoF.Creational;

import GoF.Creational.Factory.LoggerFactory;
import GoF.Creational.AbstractFactory.SkinFactory;
import GoF.Creational.Builder.ActorBuilder;

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
            doc = docBuilder.parse(new File(".\\src\\GoF\\Creational\\config.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * SimpleFactory
     */
    public static String[] getChartTypes() {
        NodeList nodeList = doc.getElementsByTagName("chartType");
        String[] res = new String[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            res[i] = nodeList.item(i).getFirstChild().getNodeValue().trim();
        }
        return res;
    }

    /**
     * Factory
     */
    public static LoggerFactory[] getFactoryBeans() {
        NodeList nodeList = doc.getElementsByTagName("factoryClassName");
        LoggerFactory[] res = new LoggerFactory[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res[i] = (LoggerFactory) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * AbstractFactory
     */
    public static SkinFactory[] getAbstractFactoryBeans() {
        NodeList nodeList = doc.getElementsByTagName("abstractFactoryClassName");
        SkinFactory[] res = new SkinFactory[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res[i] = (SkinFactory) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * Builder
     */
    public static ActorBuilder[] getBuilderBeans() {
        NodeList nodeList = doc.getElementsByTagName("builderClassName");
        ActorBuilder[] res = new ActorBuilder[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res[i] = (ActorBuilder) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
