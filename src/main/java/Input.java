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

    public static String getString(String prompt) {
        String input;
        Output.print(prompt);
        while (true) {
            try {
                input = reader.readLine();
                return input;
            } catch (IOException e) {
                Output.println("Unable to capture input. Please try again. ");
                continue;
            }
        }

    }

    public static String getString() {
        return getString("");
    }

    public static int getInt(String prompt) {
        String input;
        int i = 0;

        while (true) {
            Output.print(prompt);

            try {
                input = reader.readLine();
            } catch (IOException e) {
                Output.println("Unable to capture input. Please try again. ");
                continue;
            }

            try {
                i = Integer.parseInt(input);
                break;
            } catch (Exception e) {
                Output.println("Input must be an integer.");
            }
        }

        return i;
    }

    public static int getInt() {
        return getInt("");
    }

    public static char getChar(String prompt) throws IOException {
        String input;
        char i = '0';

        while (true) {
            Output.print(prompt);
            input = reader.readLine();

            if (input.length() == 1) {
                i = input.toCharArray()[0];
                break;
            } else {
                Output.println("Input must be one character. ");
            }
        }

        return i;
    }

    public static char getChar() throws IOException {
        return getChar("");
    }

    public static Date getDate(String prompt) {
        String input;
        Date d = new Date();

        while (true) {
            Output.print(prompt);
            try {
                input = reader.readLine();   
            } catch (IOException e) {
                Output.println("Unable to capture input. Please try again. ");
                continue;
            }

            try {
                d = df.parse(input);
                break;
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
