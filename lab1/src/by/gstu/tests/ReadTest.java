package by.gstu.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTest {

    public static void main(String[] args) {
        try (InputStreamReader reader = new InputStreamReader(System.in)) {
            System.out.println("Чтение с помощью InputStreamReader:");
            while (true) {
                int symbol = reader.read();
                if ((char) symbol == 'z') break;
                System.out.print((char) symbol);
            }
            System.out.println("Чтение с помощью BufferedSteamReader:");
            try (BufferedReader buffReader = new BufferedReader(reader)){
                while (true) {
                    String line = buffReader.readLine();
                    if (line.equals("выход")) break;
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
