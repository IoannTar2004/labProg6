package org.example.tools;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Class to output texts from .properties files.
 */
public class OutputText {
    private static final Locale locale = new Locale("ru", "RU");

    private static final ResourceBundle startInfo = ResourceBundle.getBundle("properties.StartInfo", locale);
    private static final ResourceBundle errors = ResourceBundle.getBundle("properties.Errors", locale);
    private static final ResourceBundle inputs = ResourceBundle.getBundle("properties.Inputs", locale);
    private static final ResourceBundle results = ResourceBundle.getBundle("properties.Results", locale);
    private static final ResourceBundle values = ResourceBundle.getBundle("properties.MaxValues", locale);
    private static final ResourceBundle errorsWithArgs = ResourceBundle.getBundle("properties.ErrorsWithArgs", locale);
    private static final ResourceBundle serverErrors = ResourceBundle.getBundle("properties.ServerErrors", locale);

    public static String startInformation(String info) {
        return startInfo.getString(info);
    }

    public static String error(String error) {
        return errors.getString(error);
    }

    public static String input(String input) {
        return inputs.getString(input);
    }

    public static String result(String result) {
        return results.getString(result);
    }

    public static String maxValues(String value) {return values.getString(value);}

    public static String errorWithArgs(String error, Object o) {return String.format(errorsWithArgs.getString(error), o);}

    public static String serverError(String error) {return serverErrors.getString(error);}
}
