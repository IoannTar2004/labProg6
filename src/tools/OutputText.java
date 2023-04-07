package src.tools;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * class to output texts from .properties files.
 */
public class OutputText {
    private static final Locale locale = new Locale("ru", "RU");

    private static final ResourceBundle startInfo = ResourceBundle.getBundle("resources.StartInfo", locale);
    private static final ResourceBundle errors = ResourceBundle.getBundle("resources.Errors", locale);
    private static final ResourceBundle inputs = ResourceBundle.getBundle("resources.Inputs", locale);
    private static final ResourceBundle results = ResourceBundle.getBundle("resources.Results", locale);
    private static final ResourceBundle values = ResourceBundle.getBundle("resources.MaxValues", locale);
    private static final ResourceBundle errorsWithArgs = ResourceBundle.getBundle("resources.ErrorsWithArgs", locale);

    public static void startInformation(String info) {
        String s = startInfo.getString(info);
        System.out.println(s);
    }

    public static void error(String error) {
        System.out.println(errors.getString(error));
    }

    public static void input(String input) {
        System.out.println(inputs.getString(input));
    }

    public static String result(String result) {
        return results.getString(result);
    }

    public static void maxValues(String value) {System.out.println(values.getString(value));}

    public static void errorWithArgs(String error, Object o) {System.out.printf(errorsWithArgs.getString(error), o);}
}
