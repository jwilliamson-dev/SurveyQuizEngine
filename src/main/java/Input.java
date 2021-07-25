package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Input {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    public static String getString(String prompt) throws IOException {
        if (prompt != "")
            Output.print(prompt);

        String input = reader.readLine();
        return input;
    }

    public static String getString() throws IOException {
        return getString("");
    }

    public static int getInt(String prompt) throws IOException {
        String input;
        int i = 0;
        boolean valid = false;

        while (!valid) {
            if (prompt != "")
                Output.print(prompt);

            input = reader.readLine();

            try {
                i = Integer.parseInt(input);
                valid = true;
            } catch (Exception e) {
                Output.println("Input must be an integer.");
            }
        }

        return i;
    }

    public static int getInt() throws IOException {
        return getInt("");
    }

    public static char getChar(String prompt) throws IOException {
        String input;
        boolean valid = false;
        char i = '0';

        while (!valid) {
            if (prompt != "")
                Output.print(prompt);

            input = reader.readLine();

            if (input.length() == 1) {
                valid = true;
                i = input.toCharArray()[0];
            } else {
                Output.println("Input must be one character. ");
            }
        }

        return i;
    }

    public static char getChar() throws IOException {
        return getChar("");
    }

    public static Date getDate(String prompt) throws IOException {
        String input;
        boolean valid = false;
        Date d = new Date();

        while (!valid) {
            if (prompt != "")
                Output.print(prompt);
            input = reader.readLine();
            try {
                d = df.parse(input);
                valid = true;
            } catch (ParseException e) {
                Output.println("Input must be a valid date in format: " + df.toPattern() + " .");
            }
        }

        return d;
    }
    
    public static Date getDate() throws IOException {
        return getDate("");
    }
}
