package src;

import org.xml.sax.SAXException;
import src.commands.*;
import src.parser.Reader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

import static src.collectionClasses.CollArrayDeque.dragons;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{
        Reader.parse("D:\\Program Files\\IntelliJ IDEA 2022.2.3\\PROJECTS\\laba5\\src\\src\\objects.xml");
        System.out.println(dragons);
        Scanner scanner = new Scanner(System.in);

        exit:
        {
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "help":
                    CommandHelp.execute();
                    break;
                case "exit":
                    break exit;
            }
        }
        }
    }
}

