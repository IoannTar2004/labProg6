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
        InputManager inputManager = new InputManager();

        OutputText.startInformation("CorrectXmlFile");
        String data;
        if (inputManager.yesNoInput()) {
            OutputText.startInformation("Example");
        }

        OutputText.startInformation("EnvVar");
        File file;
        do {
            data = inputManager.scanner();
            file = Checks.fileChecker(data);
            FileManager.setFile(file);
        } while (file == null);

        OutputText.startInformation("ReadFile");
        if (inputManager.yesNoInput()) {
            if (FileManager.isNotEmpty(file)) {
                XMLReader.parse(file);
            }
        }

        OutputText.startInformation("ProgramReady");
    }
}
