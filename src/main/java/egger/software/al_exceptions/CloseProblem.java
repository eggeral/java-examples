package egger.software.al_exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CloseProblem {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() throws IOException {
        try(InputStream is = new FileInputStream("test")) {
            is.read();
        }
    }

}
