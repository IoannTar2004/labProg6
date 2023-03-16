package src.tools;

import src.support.Checks;
import src.support.FileManager;
import src.support.InputManager;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProgramStart {
    /**
     * This method runs at the beginning. It explains basic things of this program and requests initial xml file.
     */
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        OutputText.startInformation("CorrectXmlFile");

        try {
            String data;
            if (InputManager.yesNoInput()) {
                OutputText.startInformation("Example");
            }

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

            if (InputManager.yesNoInput()) {
                if (FileManager.isNotEmpty(file)) {
                    XMLReader.parse(file);
                }
            }

            OutputText.startInformation("ProgramReady");
        } catch (NoSuchElementException e) {System.exit(0);}
    }
}
