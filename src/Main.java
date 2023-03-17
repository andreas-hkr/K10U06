import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    static String translate(String text) {
        String result = "";
        for (int i= 0; i < text.length(); i++) {
            char c = text.charAt(i);
            result += switch (c) {
                case 'a', 'e', 'i', 'o', 'u', 'y', 'å', 'ä', 'ö' -> c;
                case ' ', '.' -> c;
                default -> c + "o" + c;
            };
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        // Översätt en inläst text till rövarspråk och spara den i en textfil

        Scanner input = new Scanner(System.in);
        System.out.print("Ange en text: ");
        String text = input.nextLine();

        String translated = translate(text);
        System.out.println("Översatt: " + translated);

        PrintWriter fileOut = new PrintWriter(new BufferedWriter(new FileWriter("translated.txt")));
        fileOut.println(translated);
        fileOut.close();
    }
}