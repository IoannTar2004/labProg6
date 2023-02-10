package src.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import src.collectionClasses.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Date;

public class Reader implements CollArrayDeque {
    public static void parse(String path) throws ParserConfigurationException, IOException, SAXException {
        File xml = new File(path);
        DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = dbfact.newDocumentBuilder();
        Document document = dbuilder.parse(xml);

        System.out.println(document.getDocumentElement().getNodeName());
        NodeList nodeList = document.getElementsByTagName("object");

        String[] coor;
        String data;

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node obj = nodeList.item(i);
            Element element = (Element) obj;

            Long id = Long.parseLong(element.getAttribute("id"));
            String name = element.getElementsByTagName("name").item(0).getTextContent();
            int age = Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent());

            coor = element.getElementsByTagName("coordinates").item(0).getTextContent().split("\s*;\s*");
            Coordinates coordinates = new Coordinates(Integer.parseInt(coor[0]), Long.parseLong(coor[1]));

            Color color = Color.valueOf(element.getElementsByTagName("color").item(0).getTextContent());
            DragonType type = DragonType.valueOf(element.getElementsByTagName("type").item(0).getTextContent());
            DragonCharacter character = DragonCharacter.valueOf(element.getElementsByTagName("character").item(0).getTextContent());
            DragonCave cave = new DragonCave(Double.parseDouble(element.getElementsByTagName("cave").item(0).getTextContent()));
            Date date = new Date();

            Dragon dragon = new Dragon(id, name, coordinates, age, color, type, character, cave, date);
            dragons.add(dragon);
        }
    }
}
