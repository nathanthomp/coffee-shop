package coffeeshop.service;

import coffeeshop.domain.items.Beverage;
import coffeeshop.domain.items.Food;
import coffeeshop.domain.items.Item;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class MenuService {

    private final List<Item> menuItems;
    private static final String MENU_RESOURCE = "/menu.xml";

    public MenuService() {
        this.menuItems = loadMenuItems();
    }

    public List<Item> loadMenu() {
        return menuItems;
    }

    private List<Item> loadMenuItems() {
        try (InputStream inputStream = MenuService.class.getResourceAsStream(MENU_RESOURCE)) {
            if (inputStream == null) {
                throw new IllegalStateException("Menu resource not found: " + MENU_RESOURCE);
            }

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            Document document = documentBuilderFactory.newDocumentBuilder().parse(inputStream);
            document.getDocumentElement().normalize();

            List<Item> loadedItems = new ArrayList<>();
            addBeverages(document, loadedItems);
            addFoods(document, loadedItems);
            return List.copyOf(loadedItems);
        } catch (Exception exception) {
            throw new IllegalStateException("Failed to load menu from resource: " + MENU_RESOURCE, exception);
        }
    }

    private void addBeverages(Document document, List<Item> loadedItems) {
        NodeList beverages = document.getElementsByTagName("beverage");

        for (int index = 0; index < beverages.getLength(); index++) {
            Element beverageElement = (Element) beverages.item(index);
            loadedItems.add(new Beverage(
                    readChildText(beverageElement, "name"),
                    new BigDecimal(readChildText(beverageElement, "price")),
                    readChildText(beverageElement, "description")
            ));
        }
    }

    private void addFoods(Document document, List<Item> loadedItems) {
        NodeList foods = document.getElementsByTagName("food");

        for (int index = 0; index < foods.getLength(); index++) {
            Element foodElement = (Element) foods.item(index);
            loadedItems.add(new Food(
                    readChildText(foodElement, "name"),
                    new BigDecimal(readChildText(foodElement, "price")),
                    readChildText(foodElement, "description")
            ));
        }
    }

    private String readChildText(Element parentElement, String tagName) {
        return parentElement.getElementsByTagName(tagName).item(0).getTextContent().trim();
    }
}
