package GoF.Structural;

import GoF.Structural.Adapter.CarTarget;
import GoF.Structural.Bridge.Image;
import GoF.Structural.Bridge.ImageImp;
import GoF.Structural.Facade.AbstractionEncryptFacade;
import GoF.Structural.Proxy.Searcher;
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
            doc = docBuilder.parse(new File(".\\src\\GoF\\Structural\\config.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adapter
     */
    public static CarTarget[] getAdapterBean() {
        NodeList nodeList = doc.getElementsByTagName("Adapter");
        CarTarget[] res = new CarTarget[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res[i] = (CarTarget) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * Bridge
     */
    public static Image[] getImageBeans() {
        NodeList nodeList = doc.getElementsByTagName("RefinedAbstraction");
        Image[] res = new Image[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res[i] = (Image) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }
    public static ImageImp[] getImageImpBeans() {
        NodeList nodeList = doc.getElementsByTagName("ConcreteImplementor");
        ImageImp[] res = new ImageImp[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res[i] = (ImageImp) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * Facade
     */
    public static AbstractionEncryptFacade[] getFacadeBeans() {
        NodeList nodeList = doc.getElementsByTagName("FacadeClassName");
        AbstractionEncryptFacade[] res = new AbstractionEncryptFacade[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res[i] = (AbstractionEncryptFacade) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * Proxy
     */
    public static Searcher[] getProxyBeans() {
        NodeList nodeList = doc.getElementsByTagName("ProxyClassName");
        Searcher[] res = new Searcher[nodeList.getLength()];
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            String className = nodeList.item(i).getFirstChild().getNodeValue().trim();
            try {
                res[i] = (Searcher) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
