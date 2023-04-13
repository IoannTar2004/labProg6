package src.tools;

import src.client.Validation;
import src.support.Checks;
import src.support.FileManager;
import src.support.Processing;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProgramStart {
    /**
     * This method runs at the beginning. It explains basic things of this program and requests initial xml file.
     */
    public static void start() throws IOException {
        Socket socket = connectionToServer();
        socket.close();
        Validation validation = new Validation();

        OutputText.startInformation("CorrectXmlFile");
        String data;
        if (validation.yesNoInput()) {
            OutputText.startInformation("Example");
        }

        OutputText.startInformation("EnvVar");
        File file;
        do {
            data = new Processing().scanner();
            file = Checks.fileChecker(data);
            FileManager.setCurrentFile(file);
        } while (file == null);

        OutputText.startInformation("ReadFile");
        if (validation.yesNoInput()) {
            if (FileManager.isNotEmpty(file)) {
                XMLReader.parse(file);
            }
        }

        OutputText.startInformation("ProgramReady");
    }

    /**
     * Method processes input of server host and port
     * @return socket
     */
    private static Socket connectionToServer() {
        Processing processing = new Processing();
        System.out.println("Программа работает с коллекцией и вызывает команды на сервере. Введите имя хоста.");
        do {
            String host = processing.scanner();

            System.out.println("Введите номер порта");
            do {
                try {
                    int port = Integer.parseInt(processing.scanner());
                    return new Socket(host, port);
                } catch (NumberFormatException e) {
                    System.out.println("Порт - целое положительное число");
                } catch (UnknownHostException e) {
                    System.out.println("Неизвестный хост");
                    break;
                } catch (ConnectException e) {
                    System.out.println("Программа не смогла подключиться к серверу. Проверьте порт!");
                } catch (Exception e) {e.printStackTrace();}
            } while (true);
        } while (true);
    }
}
