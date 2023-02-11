package src;

import org.xml.sax.SAXException;
import src.commands.*;
import src.tools.Invoker;
import src.tools.Reader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{
        Reader.parse("D:\\Program Files\\IntelliJ IDEA 2022.2.3\\PROJECTS\\laba5\\src\\src\\objects.xml");
        Invoker.invoke();
    }
}

