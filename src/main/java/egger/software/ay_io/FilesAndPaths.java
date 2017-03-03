package egger.software.ay_io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesAndPaths {
    public static void main(String[] args) throws IOException {
        Files.write(Paths.get("test.txt"), "test".getBytes());
        Files.move(Paths.get("test.txt"), Paths.get("test-new.txt"));
        Files.readAllLines(Paths.get("test-new.txt")).forEach(System.out::println);
    }
}
