package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketApp {

    public static void main(String[] args) throws IOException {
        String input;
        while (true) {
            System.out.println("print some text include brackets");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                System.out.println("end! thx");
                break;
            }
            BracketChecker bracketChecker = new BracketChecker(input);
            bracketChecker.check();
        }
    }

    private static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }

}
