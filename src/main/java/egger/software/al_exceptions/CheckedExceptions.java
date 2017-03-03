package egger.software.al_exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CheckedExceptions {
    public static void main(String[] args) {
        //checked exceptions have to be caught or rethrown
        try {
            readFile("unknown");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFile(String fileName) throws IOException {
        //checked exceptions have to be caught or rethrown
        Files.readAllLines(Paths.get(fileName));
    }
}
