package src.tools;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * class to output texts from .properties files. Contains of temporary methods.
 */
public class OutputText {
    private static final Locale locale = new Locale("ru", "RU");

    private static final ResourceBundle startInfo = ResourceBundle.getBundle("resources.StartInfo", locale);
    private static final ResourceBundle errors = ResourceBundle.getBundle("resources.Errors", locale);
    private static final ResourceBundle inputs = ResourceBundle.getBundle("resources.Inputs", locale);
    private static final ResourceBundle results = ResourceBundle.getBundle("resources.Results", locale);

    public static void startInformation(String info) {
        System.out.println(startInfo.getString(info));
    }

    public static void error(String error) {
        System.out.println(errors.getString(error));
    }

    public static void input(String input) {
        System.out.println(inputs.getString(input));
    }

    public static void result(String result) {
        System.out.println(results.getString(result));
    }
}
