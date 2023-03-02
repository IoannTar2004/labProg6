package src.tools;

import src.support.Checks;
import src.support.FileManager;

import java.io.File;
import java.util.Scanner;

public class ProgramStart {
    /**
     * This method runs at the beginning. It explains basic things of this program and requests initial xml file.
     */
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        String data;
        OutputText.startInformation("CorrectXmlFile");

        do {
            data = scanner.nextLine();
            if(data.matches("\\s*y\\s*")) {
               OutputText.startInformation("Example");
                break;
            } else if(data.matches("\\s*n\\s*")) {break;}

            else {OutputText.startInformation("yes_no");}
        } while (true);

        OutputText.startInformation("EnvVar");
        File file;
        do {
            data = scanner.nextLine();
            file = Checks.fileChecker(data);
            if (file != null) {
                FileManager.setFile(file);
                break;
            }
        } while (true);

        OutputText.startInformation("ReadFile");
        do {
            data = scanner.nextLine();
            if(data.matches("\\s*y\\s*")) {
                XMLReader.parse(file);
                break;
            } else if(data.matches("\\s*n\\s*")) {break;}
            else {OutputText.startInformation("yes_no");}
        } while (true);

        OutputText.startInformation("ProgramReady");
    }
}
