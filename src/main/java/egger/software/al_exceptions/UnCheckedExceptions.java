package egger.software.al_exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UnCheckedExceptions {
    public static void main(String[] args) {
        readFile("test");
    }

    public static void readFile(String fileName) {
        try {
            Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}
