import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PriceGateway {
    private static final String PATH = "data/prices.xml";
    private static PriceGateway instance;
    
    /*
     * BEVERAGE-NIC-SMALL
     * BEVERAGE-NIC-MEDIUM
     * BEVERAGE-NIC-LARGE
     * BEVERAGE-NIC-BOX
     * BEVERAGE-NATE-SMALL
     * BEVERAGE-NATE-MEDIUM
     * BEVERAGE-NATE-LARGE
     * BEVERAGE-NATE-BOX
     * MILK-REGULAR
     * MILK-OAT
     * MILK-ALMOND
     * MILK-SOY
     * DECORATOR-MOCHA
     * DECORATOR-BROWNSUGAR
     * DECORATOR-SYRUP
     */
    private Map<String, Double> priceMap = new HashMap<>();

    private PriceGateway() {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(PATH));
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("price");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Node forAttribute = node.getAttributes().getNamedItem("for");

                String key = forAttribute.getTextContent();
                double value = Double.parseDouble(node.getTextContent());

                priceMap.put(key, value);
            }

        } catch (IOException e) {
            System.err.println("IO Error: " + e.getLocalizedMessage());
        } catch (SAXException e) {
            System.err.println("Parse Error: " + e.getLocalizedMessage());
        } catch (NumberFormatException e) {
            System.err.println("Number Format Error: " + e.getLocalizedMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
    }

    public static PriceGateway getInstance() {
        if (instance == null) {
            instance = new PriceGateway();
        }
        return instance;
    }

    public double getPrice(String key) {
        return priceMap.get(key);
    }
}
