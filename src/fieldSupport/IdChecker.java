package src.fieldSupport;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdChecker {
    public static Long check(String id) {

        Pattern pattern = Pattern.compile("\\d{12}");
        Matcher matcher = pattern.matcher(id);

        Pattern pattern1 = Pattern.compile("\\d{1,11}|\\d{13,}");
        Matcher matcher1 = pattern1.matcher(id);

        Pattern pattern2 = Pattern.compile("\\s*.\\D*\\s+.*");
        Matcher matcher2 = pattern2.matcher(id);

        Pattern pattern3 = Pattern.compile("-\\d{12}");
        Matcher matcher3 = pattern3.matcher(id);

        Pattern pattern4 = Pattern.compile("-\\d{1,11}|-\\d{13,}");
        Matcher matcher4 = pattern4.matcher(id);

        Pattern pattern5 = Pattern.compile("-?\\d*\\.\\d+");
        Matcher matcher5 = pattern5.matcher(id);

        if (matcher.matches()) {
            return Long.parseLong(id);

        } else if (matcher1.matches()) {
            System.out.println("id должен содержать 12 цифр!");
        } else if (matcher3.matches()) {
            System.out.println("id должен быть положительным!");
        } else if (matcher4.matches()) {
            System.out.println("id должен содержать 12 цифр и быть положительным!");
        } else if (matcher5.matches()) {
            System.out.println("id должен быть целым положительным числом");
        }  else {
            System.out.println("id должен содержать 12 цифр в десятичной сс!");
        }
        return -1L;
    }
}
