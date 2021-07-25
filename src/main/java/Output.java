package main.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Output {
    private static SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    public static void println(String text) {
        System.out.println(text);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static String dateString(Date d) {
        return df.format(d);
    }
}
